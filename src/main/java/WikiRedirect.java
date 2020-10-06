import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class WikiRedirect {
    public void printRedirectList(JsonArray redirectList) {
        if (redirectList == null) {
            return;
        }
        for (JsonElement jsonElement : redirectList) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            String from = jsonObject.get("from").getAsString();
            String to = jsonObject.get("to").getAsString();

            System.out.printf("redirected from %s to %s\n",from,to);
        }
    }
}
