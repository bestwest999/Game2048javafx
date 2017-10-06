package app2048;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
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
