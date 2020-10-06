import java.io.IOException;
import java.util.Scanner;

public class UI {
    public void runUI() throws IOException {
        WikiConnection wikiConnection = new WikiConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.println("HELLO\n\nPlease Type Your Search Below.");
        String search = scanner.nextLine();
        System.out.println(wikiConnection.WikiConnection());
        URLBuild url = new URLBuild();
        try {
            url.URLBuilder(Main.search);
        } catch (IOException e) {
            e.printStackTrace();
        }
        WikiRedirect wikiRedirect = new WikiRedirect();
        RevisionParser revisionParser = new RevisionParser();
        EditorParser editorParser = new EditorParser();
        wikiRedirect.printRedirectList(revisionParser.getRedirectList(url.URLBuilder(search)));
        System.out.print("\n\n1:See most recent editors\n2:See editors with the most activity\n\n");
        int selection = Integer.parseInt(scanner.nextLine());
        if(selection == 1) {
            editorParser.getEditors(revisionParser.GetRevisions(url.URLBuilder(Main.search)));
        }
        if(selection == 2){
            editorParser.getMostEdits(revisionParser.GetRevisions(url.URLBuilder(Main.search)));
        }
    }
}
