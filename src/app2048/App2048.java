package app2048;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App2048 extends Application {

        public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) {

        ApplicationView board = new ApplicationView();
        Scene scene = new Scene(board.drawBoard());
        stage.setScene(scene);
        stage.setTitle("Adding Children to a GridPane");
        stage.show();
    }
}
