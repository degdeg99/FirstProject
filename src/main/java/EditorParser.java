import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.InputStream;

public class EditorParser {// used to get the editors and the time stamps of when they edited

    public void getEditors(JsonArray revision, InputStream connection) {

        for (int i = 0; i < revision.size(); i++) {

            JsonObject submission = revision.get(i).getAsJsonObject();
            JsonElement editor = submission.get("user");
            JsonObject submissionTime = revision.get(i).getAsJsonObject();
            JsonElement timeStamp = submissionTime.get("timestamp");

            System.out.printf("Editor "+ (i+1) +": %s\nTime Stamp: %s\n\n",editor,timeStamp);
        }
    }
}