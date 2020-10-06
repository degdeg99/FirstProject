import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLBuild {
    private  String wikiURL;
    private String format;
    private URL finishedURL = null;

    public java.io.InputStream URLBuilder(String page)throws IOException {
        wikiURL = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=";
        format = "&rvprop=timestamp|user&rvlimit=20&redirects";
        finishedURL = new URL(wikiURL+ URLEncoder.encode(page, StandardCharsets.UTF_8)+format);
        URLConnection connection = finishedURL.openConnection();
        connection.setRequestProperty("User","FirstProject (drankin@bsu.edu)");
        connection.connect();
        return connection.getInputStream();

    }
    public static JsonObject collectJsonObjectFromWikipedia(String searchTerm) throws IOException {
        URLBuild urlBuild = new URLBuild();
        InputStream connection = urlBuild.URLBuilder(searchTerm);
        return readJsonDataFrom(connection);
    }

    public static JsonObject readJsonDataFrom(InputStream connection) throws IOException {
        StringBuilder jsonStringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection));
        String jsonDataString;
        while ((jsonDataString = bufferedReader.readLine()) != null) {
            jsonStringBuilder.append(jsonDataString).append("\n");
        }
        String websiteInfo = jsonStringBuilder.toString().trim();
        return (JsonObject) JsonParser.parseString(websiteInfo);
    }
}
