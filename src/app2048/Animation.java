package app2048;

import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class Animation {


    public void moveTiles(ApplicationView applicationView) {
        GridPane board = applicationView.getBoard();
        ObservableList<Node> childrens = board.getChildren();


        for (Node node : childrens) {

            TranslateTransition tt = new TranslateTransition(Duration.seconds(2), node);
            tt.setFromX(node.getLayoutX());
            tt.setToX(board.getWidth() );
            tt.setCycleCount(1);
            tt.setAutoReverse(true);
            tt.play();
        }


    }

    public  void handle(KeyEvent e, ApplicationView view) {
        Animation animation= new Animation();
        String type = e.getEventType().getName();
        KeyCode keyCode = e.getCode();
        System.out.println(type + ": Key Code=" + keyCode.getName() + ", Text=" + e.getText());
        animation.moveTiles(view);


    }

}
