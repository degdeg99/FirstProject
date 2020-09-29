import java.io.IOException;
import java.util.Scanner;

public class UI {
    public void runUI() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("HELLO\n\nPlease Type Your Search Below.");
        String search = scanner.nextLine();
        search.replaceAll(" ", "");
        URLBuild url = new URLBuild();
        try {
            url.URLBuilder(search);
        } catch (IOException e) {
            e.printStackTrace();
        }
        RevisionParser revisionParser = new RevisionParser();
        EditorParser editorParser = new EditorParser();
        revisionParser.GetRevisions(url.URLBuilder(search));
        editorParser.getEditors(revisionParser, url.URLBuilder(search));
    }
}
