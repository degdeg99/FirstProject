import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.InputStream;

public class EditorParser {// used to get the editors and the time stamps of when they edited

    public void getEditors(RevisionParser revisionParser, InputStream connection) {
        JsonArray revisions = revisionParser.GetRevisions(connection);

        for (int i = 0; i < revisions.size(); i++) {

            JsonObject submission = revisions.get(i).getAsJsonObject();
            JsonElement editor = submission.get("user");
            JsonObject submissionTime = revisions.get(i).getAsJsonObject();
            JsonElement timeStamp = submissionTime.get("timestamp");

            System.out.printf("Editor"+ i+1 +": %s\nTime Stamp: %s\n\n",editor,timeStamp);
        }
    }
}