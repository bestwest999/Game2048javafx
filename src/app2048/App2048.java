package app2048;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


j

public class App2048 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        ApplicationView view = new ApplicationView();
        Scene scene = new Scene(view.drawBoard());
        Animation animation = new Animation();
        stage.setScene(scene);
        scene.setOnKeyPressed(e -> animation.handle  (e, view) );
        stage.setTitle("Adding Children to a GridPane");
        //board2.setFocusTraversable(true);
        //board2.requestFocus();
        // board2.setOnKeyPressed(e -> userInput.handle(e));
        stage.show();


    }
}
