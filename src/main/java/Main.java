import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class Main extends Application {
    public static String search = "";


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Wikipedia editor search");
        Button SearchButton = new Button("Search");
        TextField SearchTF = new TextField("");
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                search = SearchTF.getText();
                UI ui= new UI();
                try {
                    ui.runUI();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        };
        SearchButton.setOnAction(event);
        GridPane r = new GridPane();
        r.addRow(4,SearchButton,SearchTF);
        Scene scene = new Scene(r, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();



    }
}
