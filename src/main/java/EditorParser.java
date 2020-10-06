import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.text.ParseException;
import java.util.*;

public class EditorParser {

    public String getEditors(JsonArray revision) throws ParseException {
        String finalString = "";
        if (revision == null)
            return "";
        for (int i = 0; i < revision.size(); i++) {

            JsonObject submission = revision.get(i).getAsJsonObject();
            JsonElement editor = submission.get("user");
            JsonObject submissionTime = revision.get(i).getAsJsonObject();
            String timeStamp = submissionTime.get("timestamp").getAsString();

            TimeLocalizer timeLocalizer = new TimeLocalizer();
            Date dateTimeStamp = timeLocalizer.localizeTime(timeStamp);

            finalString = finalString + ("\nEditor " + (i + 1) + ": " + editor + "\nTime Stamp: " + dateTimeStamp);
        }
        return finalString;
    }
}
