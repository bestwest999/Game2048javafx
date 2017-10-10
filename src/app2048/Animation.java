package app2048;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.animation.TranslateTransition;
import javafx.beans.Observable;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
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
        GridPane board = this.view.getBoard();
        ObservableList<Node> childrens = board.getChildren();
        ObservableList<Bounds> bounds = FXCollections.observableArrayList();


        for (Node node : childrens) {
            TranslateTransition tt = new TranslateTransition(Duration.seconds(1), node);
            bounds.add(node.getBoundsInParent());
            node.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
                @Override
                public void changed(ObservableValue<? extends Bounds> observable, Bounds oldValue, Bounds newValue) {

                    if (newValue.getMinX() < 0) {
                        tt.pause();
                        System.out.println("Fuck off");

                    } else if (collisionCheck(childrens, node)) {
                        tt.pause();
                        System.out.println("Fuck node");


                    }
                }
            });

            tt.setByX(-500);
            tt.setCycleCount(2);
            tt.play();

        }
    }

    public boolean collisionCheck(ObservableList<Node> children, Node node) {


        for (Node tile : children) {

            if (node != tile) if (node.getBoundsInParent().intersects(tile.getBoundsInParent()) )

            {         //     && (node.getLayoutX()!=node.getLayoutX())
                System.out.println("LayoutX = " + node.getBoundsInParent() + "LayoutY = " + node.getLayoutY());
                System.out.println("LayoutX = " + tile.getBoundsInParent()+ "LayoutY = " + node.getLayoutY());

                return true;
            }

        }
        return false;
    }


   // System.out.println("LayoutX = " + tile.getLayoutX() + "TranslateX = " + tile.getTranslateX() + "board witdth = " + board.getWidth());
    //System.out.println("getBoundsInParent = " + tile.getBoundsInParent() + "getBoundsInLocal = " + tile.getBoundsInLocal() + "getBoundsInLocal = " + board.getBoundsInLocal().getMaxX());


    public void handle(KeyEvent e) {
       // for(int i=0; i<3; i++) {
            String type = e.getEventType().getName();
            KeyCode keyCode = e.getCode();
            System.out.println(type + ": Key Code=" + keyCode.getName() + ", Text=" + e.getText());
            moveTiles();
            //moveTiles();
        //}



    }


}



