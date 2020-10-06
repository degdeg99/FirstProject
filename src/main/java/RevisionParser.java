import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

public class RevisionParser {// this is to parse the revisions out of the JSON file

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

    public JsonArray getRedirectList(InputStream connection) {
        Reader reader = new InputStreamReader(connection);
        JsonElement rootElement = JsonParser.parseReader(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        return rootObject.getAsJsonObject("query").getAsJsonArray("redirects");
    }
}