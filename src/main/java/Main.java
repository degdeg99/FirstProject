import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;

public class Main extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        WikiConnection wikiConnection = new WikiConnection();


        primaryStage.setTitle("Wikipedia editor search");
        Button SearchButton = new Button("Search");
        TextField SearchTF = new TextField("");
        Label wikiConnect = new Label(wikiConnection.WikiConnection());
        SearchButton.setOnAction(e -> {
            try {
                buttonClicked(SearchTF.getText());
            } catch (IOException | ParseException ioException) {
                ioException.printStackTrace();
            }
        });
        VBox layout = new VBox();
        layout.getChildren().addAll(SearchTF,SearchButton,wikiConnect);

        Scene scene = new Scene(layout,200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();



    }
    private void buttonClicked(String search) throws IOException, ParseException {
        AlertBox alertBox = new AlertBox();
        alertBox.newWindow("mostEdits",search);


    }
}

