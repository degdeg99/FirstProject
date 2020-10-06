import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditorParser {

    public void getEditors(JsonArray revision) {

        for (int i = 0; i < revision.size(); i++) {

            JsonObject submission = revision.get(i).getAsJsonObject();
            JsonElement editor = submission.get("user");
            JsonObject submissionTime = revision.get(i).getAsJsonObject();
            JsonElement timeStamp = submissionTime.get("timestamp");

            System.out.printf("Editor "+ (i+1) +": %s\nTime Stamp: %s\n\n",editor,timeStamp);
        }
    }
    public void getMostEdits(JsonArray revision){
        HashMap<JsonElement, Integer> users = new HashMap<>();

        for(int i=0;i<revision.size();i++){
            int duplicate = 0;
            JsonObject submission = revision.get(i).getAsJsonObject();
            JsonElement userToCheck = submission.get("user");

            for (int j = i + 1; j < revision.size(); j++) {
                JsonObject submissionToCheckAgainst = revision.get(j).getAsJsonObject();
                JsonElement userToCheckAgainst = submissionToCheckAgainst.get("user");

                if (userToCheck.equals(userToCheckAgainst)) {
                    duplicate = duplicate + 1;
                    revision.remove(userToCheckAgainst);
                    users.put(userToCheck, duplicate + 1);
                }

                else if (!users.containsKey(userToCheck)) {
                    users.put(userToCheck, duplicate + 1);
                } } }

            List<JsonElement> keyList = new ArrayList<>(users.keySet());
            List<Integer> valueList = new ArrayList<>(users.values());
            Map.Entry<JsonElement, Integer> maxEntry = null;
            for (Map.Entry<JsonElement, Integer> entry : users.entrySet()) {
                if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            } }

        for (int i = maxEntry.getValue(); i >= 0; i--) {
            for (int j = 0; j < users.size(); j++) {
                if (valueList.get(i) == j) {
                    System.out.println("Editor: " + keyList.get(i));
                    System.out.println("Number of Edits: " + valueList.get(i));
                    System.out.println();
                }
            }
        }
        }
    }
