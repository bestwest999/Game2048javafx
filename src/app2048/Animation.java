package app2048;

import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class Animation {

    private GridPane board;
    private ApplicationView view;

    public Animation(ApplicationView applicationView) {
         view = applicationView;
        board = view.getBoard();

    }

    public void moveTiles() {
        //GridPane board = this.view.getBoard();
        ObservableList<Node> childrens = board.getChildren();


        for (Node node : childrens) {

            TranslateTransition tt = new TranslateTransition(Duration.seconds(1), node);
            tt.setByX(-100);
            tt.setCycleCount(1);
            tt.play();
        }


    }

    public  void handle(KeyEvent e) {
        //Animation animation= new Animation(view);
        String type = e.getEventType().getName();
        KeyCode keyCode = e.getCode();
        System.out.println(type + ": Key Code=" + keyCode.getName() + ", Text=" + e.getText());
        this.moveTiles();



    }

}
