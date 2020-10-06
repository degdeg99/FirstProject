import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;

public class AlertBox {
    public static void newWindow(String title,String search) throws IOException, ParseException {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        EditorParser editorParser = new EditorParser();
        RevisionParser revisionParser = new RevisionParser();
        URLBuild url = new URLBuild();
        WikiRedirect wikiRedirect= new WikiRedirect();

        Label redirect = new Label();
        String redirectMessage =  wikiRedirect.printRedirectList(revisionParser.getRedirectList(url.URLBuilder(search)));
        redirect.setText(redirectMessage);

        Label mostEditsList = new Label();
        String mostList = editorParser.getMostEdits(revisionParser.GetRevisions(url.URLBuilder(search)));
        mostEditsList.setText("20 most recent Editors with the most Edits" + mostList);

        Label recentEditList = new Label();
        String recentList = editorParser.getEditors(revisionParser.GetRevisions(url.URLBuilder(search)));
        recentEditList.setText("\n20 most recent Editors\n\n" + recentList);

        VBox layout = new VBox();
        layout.getChildren().addAll(redirect,recentEditList,mostEditsList);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
