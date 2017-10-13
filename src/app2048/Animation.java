package app2048;


import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import java.util.Comparator;
import java.util.Observable;

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

        Comparator<Node> comparator = new Comparator<Node>() {
           @Override
          public int compare(Node node1, Node node2) {
             return ((int) node1.getBoundsInParent().getMinX() - (int) node2.getBoundsInParent().getMinX());
        }
         };
        SortedList<Node> sorted = new SortedList<Node>(childrens, comparator);



        for (Node node : sorted) {
            TranslateTransition tt = new TranslateTransition(Duration.seconds(1), node);
            // ObservableList<Node> childrens = board.getChildren();

            bounds.add(node.getBoundsInParent());




           node.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
                @Override
                public void changed(ObservableValue<? extends Bounds> observable, Bounds oldValue, Bounds newValue) {



                    if (newValue.getMinX() < 0) {
                        tt.pause();
                        System.out.println("Fuck off");

                    } else if (collisionCheck(bounds , node)) {
                        tt.pause();
                        System.out.println("Fuck node");

                    }
                    bounds.remove(oldValue);
                    bounds.add(newValue);


                }

            });

                tt.setByX(-400);
                tt.setCycleCount(3);
                tt.play();
        }
    }

    public boolean collisionCheck(ObservableList<Bounds> children, Node node) {

        //System.out.println("LayoutX = " + node.getBoundsInParent().getMinX());


        for (Bounds tile : children) {

            if (node.getBoundsInParent() != tile) if (node.getBoundsInParent().intersects(tile))
                if (node.getBoundsInParent().getMaxY() == tile.getMaxY())
                    if (node.getBoundsInParent().getMinX() > tile.getMinX())

                    {         //     && (node.getLayoutX()!=node.getLayoutX())
                        // System.out.println("LayoutX = " + node.getBoundsInParent() + "LayoutY = " + node.getLayoutY());
                        //System.out.println("LayoutX = " + tile.getBoundsInParent() + "LayoutY = " + node.getLayoutY());

                        return true;
                    } else if (node.getBoundsInParent().getMinX() > tile.getMinX()) {
                        System.out.println("bad");
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
    }


}



