package app2048;


import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.beans.EventHandler;
import java.util.Comparator;


public class Animation {

    private GridPane board;
    private ApplicationView view;


    public Animation(ApplicationView applicationView) {
        view = applicationView;
        board = view.getBoard();


    }

    public void moveLeft() {
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
            TranslateTransition tt = new TranslateTransition(Duration.seconds(2), node);


            bounds.add(node.getBoundsInParent());


            node.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
                @Override
                public void changed(ObservableValue<? extends Bounds> observable, Bounds oldValue, Bounds newValue) {
                    int x = (int)(newValue.getMinX()/100)*100;
                    int y = (int)(newValue.getMinY()/100)*100;

                    if (newValue.getMinX() < 0) {
                        tt.pause();



                    } else if  (leftCollisionCheck(bounds, node)) {

                        tt.pause();


                    }

                    bounds.remove(oldValue);
                    bounds.add(newValue);


                }

            });

tt.setNode(node);
           tt.setByX(-300);
           tt.play();

        }
    }

    public void moveRight() {
        GridPane board = this.view.getBoard();
        ObservableList<Node> childrens = board.getChildren();
        ObservableList<Bounds> bounds = FXCollections.observableArrayList();

        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return ((int) node1.getBoundsInParent().getMinX() - (int) node2.getBoundsInParent().getMinX());
            }
        };
        SortedList<Node> sorted = new SortedList<Node>(childrens, comparator.reversed());


        for (Node node : sorted) {
            TranslateTransition tt = new TranslateTransition(Duration.seconds(2), node);

            bounds.add(node.getBoundsInParent());


            node.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
                @Override
                public void changed(ObservableValue<? extends Bounds> observable, Bounds oldValue, Bounds newValue) {


                    if (newValue.getMaxX() > 400) {
                        tt.pause();
                        board.requestLayout();

                    } else if (rightCollisionCheck(bounds, node)) {
                        double x = (int)(newValue.getMinX()/100)*100;
                        tt.pause();
                    }

                    double x = (int)(newValue.getMinX()/100)*100;
                    int y = (int)(newValue.getMinY()/100)*100;


                    bounds.remove(oldValue);
                    bounds.add(newValue);



                }

            });

            tt.setNode(node);
    tt.setByX(300);
    tt.play();

        }
    }





    public boolean leftCollisionCheck(ObservableList<Bounds> children, Node node) {

       // System.out.println(" before LayoutX = " + node.getBoundsInParent().getMinX());


        for (Bounds tile : children) {

            if (node.getBoundsInParent() != tile) if (node.getBoundsInParent().intersects(tile))
                if (node.getBoundsInParent().getMaxY() == tile.getMaxY())
                    if (node.getBoundsInParent().getMinX() > tile.getMinX())

                    {


                        return true;
                    } else {
                        return false;

                    }
        }


        return false;
    }



    public boolean rightCollisionCheck(ObservableList<Bounds> children, Node node) {

       // System.out.println(" before LayoutX = " + node.getBoundsInParent().getMinX());


        for (Bounds tile : children) {

            if (node.getBoundsInParent() != tile) if (node.getBoundsInParent().intersects(tile))
                if (node.getBoundsInParent().getMaxY() == tile.getMaxY())
                    if (node.getBoundsInParent().getMinX() < tile.getMinX())

                    {


                        return true;
                    } else {
                        return false;

                    }
        }


        return false;
    }



    // System.out.println("LayoutX = " + tile.getLayoutX() + "TranslateX = " + tile.getTranslateX() + "board witdth = " + board.getWidth());
    //System.out.println("getBoundsInParent = " + tile.getBoundsInParent() + "getBoundsInLocal = " + tile.getBoundsInLocal() + "getBoundsInLocal = " + board.getBoundsInLocal().getMaxX());


    public void handle(KeyEvent e) {
        String type = e.getEventType().getName();
        KeyCode keyCode = e.getCode();
        System.out.println(type + ": Key Code=" + keyCode.getName() + ", Text=" + e.getText());
        if (e.getCode() == KeyCode.LEFT) {
            moveLeft();

        }
        else if (e.getCode() == KeyCode.RIGHT) {
            moveRight();
        } else{
            System.out.println("Do nothing");
        }
    }


}



