import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLBuild {//this makes the url
    private  String wikiURL;
    private String page;
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
}
