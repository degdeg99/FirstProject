package edu.bsu.cs222;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RevisionParser {
    private String user;
    private int numberOfEdits;

    public RevisionParser(String username, int numberOfEdits) {
        this.user = username;
        this.numberOfEdits = numberOfEdits;
    }

    public int getNumberOfEdits(){
        return numberOfEdits;
    }

    public String getUser(){
        return user;
    }


    public JsonArray GetRevisions(InputStream connection) {
        Reader reader = new InputStreamReader(connection);
        JsonElement rootElement = JsonParser.parseReader(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        JsonArray revisions = null;


        for (Map.Entry<String, JsonElement> entry : pages.entrySet()) {
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            revisions = entryObject.getAsJsonArray("revisions");
        }
        return revisions;
    }
    public static List<JsonObject> parseRevisionsToList(JsonObject wikiDataObject){
        JsonObject pages = wikiDataObject.getAsJsonObject("query").getAsJsonObject("pages");
        JsonArray revisionsArray = null;
        List<JsonObject> revisionsList = new ArrayList<>();
        for (Map.Entry<String, JsonElement> entry : pages.entrySet()) {
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            revisionsArray = entryObject.getAsJsonArray("revisions");
        }
        if (revisionsArray != null) {
            for (int i = 0; i < revisionsArray.size(); i++) {
                revisionsList.add(revisionsArray.get(i).getAsJsonObject());
            }
        }
        return revisionsList;
    }

    public JsonArray getRedirectList(InputStream connection) {
        Reader reader = new InputStreamReader(connection);
        JsonElement rootElement = JsonParser.parseReader(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        return rootObject.getAsJsonObject("query").getAsJsonArray("redirects");
    }

    public static RevisionParser collectEditorAsObject(List<JsonObject> revisionsList, int i) {
        String username = revisionsList.get(i).get("user").getAsString();
        int numberOfEdits = ActiveEditors.collectNumberOfEdits(revisionsList, i);
        return new RevisionParser(username, numberOfEdits);
    }
}