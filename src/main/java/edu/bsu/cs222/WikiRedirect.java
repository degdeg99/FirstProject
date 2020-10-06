package edu.bsu.cs222;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class WikiRedirect {
    public String printRedirectList(JsonArray redirectList) {
        if (redirectList == null) {
            return "";
        }
        String from ;
        String to ;
        for (JsonElement jsonElement : redirectList) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            from = jsonObject.get("from").getAsString();
            to = jsonObject.get("to").getAsString();

            return ("redirected from "+from+ " to "+ to);
        }
        return "";
    }
}
