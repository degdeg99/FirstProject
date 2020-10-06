import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class WikiRedirect {
    public String printRedirectList(JsonArray redirectList) {
        if (redirectList == null) {
            return null;
        }
        String from ;
        String to ;
        for (JsonElement jsonElement : redirectList) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            from = jsonObject.get("from").getAsString();
            to = jsonObject.get("to").getAsString();

            return ("\nredirected from"+from+ "to"+ to);
        }
        return null;
    }
}
