import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class WikiConnection {
    public String WikiConnection() {
        try{
            URL wiki = new URL("http://wikipedia.org");
            URLConnection connection = wiki.openConnection();

            connection.connect();
            return ("Connection Successful");

        } catch (IOException e) {
            return ("Connection Not Found");

        }
    }
}

