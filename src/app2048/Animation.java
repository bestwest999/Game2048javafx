package app2048;

import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class Animation {


    public void moveTiles(ApplicationView applicationView) {
        GridPane board = applicationView.getBoard();
        ObservableList<Node> childrens = board.getChildren();


        for (Node node : childrens) {

            TranslateTransition tt = new TranslateTransition(Duration.seconds(2), node);
            tt.setFromX(board.getWidth());
            tt.setToX(-1.0 * node.getLayoutBounds().getWidth());
            tt.setCycleCount(3);
            tt.setAutoReverse(true);
            tt.play();
        }


    }
}
