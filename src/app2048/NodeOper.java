package app2048;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.*;

import static app2048.Utilities.checkNodeSpaceIsEmpty;
import static app2048.Utilities.removeList;
import static app2048.Utilities.shuffleArray;


public class NodeOper {


  synchronized   public GridPane addRndNode(GridPane board) {

        SimpleIntegerProperty number = new SimpleIntegerProperty(2);
        Tile tile = new Tile();
        int[] xCoordCol = shuffleArray();
        int[] yCoordRow = shuffleArray();

        for (int x = 0; x < xCoordCol.length; x++) {
            for (int y = 0; y < yCoordRow.length; y++) {

                if (checkNodeSpaceIsEmpty(xCoordCol[x], yCoordRow[y], board)) {
                    board.add(tile.getTile(), (xCoordCol[x] / 100), (yCoordRow[y] / 100));

                    return board;

                }
            }

        }
        return board;
    }

   synchronized public GridPane removeNodeLeftRight(GridPane board , String direction ) {
        Node lastNode0 = null;
        Node lastNode100 = null;
        Node lastNode200 = null;
        Node lastNode300 = null;
        List<Node> removeList = new ArrayList<Node>();
        SortedList<Node> sorted;

        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return ((int) node1.getBoundsInParent().getMinX() - (int) node2.getBoundsInParent().getMinX());
            }
        };

if(direction == "left")

    sorted = new SortedList<Node>(board.getChildren(), comparator);
else
    sorted = new SortedList<Node>(board.getChildren(), comparator.reversed());


        for (Node node : sorted) {
         //   System.out.println(((Label) node).getText());

            if ((int) node.getBoundsInParent().getMinY() == 0)
                if (lastNode0 == null) {
                    lastNode0 = node;
                } else if (((Label) node).getText().equals( ((Label) lastNode0).getText())  ){
                    int textNumber = Integer.parseInt(((Label) lastNode0).getText()) *2;
                    ((Label) lastNode0).setText(String.valueOf(textNumber));
                    removeList.add(node);
                    lastNode0 = null;
                } else {
                    lastNode0 = node;
                }

            if ((int) node.getBoundsInParent().getMinY() == 100)
                if (lastNode100 == null) {
                    lastNode100 = node;
                } else if (((Label) node).getText().equals( ((Label) lastNode100).getText())  ){
                    int textNumber = Integer.parseInt(((Label) lastNode100).getText()) *2;
                    ((Label) lastNode100).setText(String.valueOf(textNumber));
                    removeList.add(node);
                    lastNode100 = null;
                } else {
                    lastNode100 = node;
                }

            if ((int) node.getBoundsInParent().getMinY() == 200)
                if (lastNode200 == null) {
                    lastNode200 = node;
                } else if (((Label) node).getText().equals( ((Label) lastNode200).getText())  ){
                    int textNumber = Integer.parseInt(((Label) lastNode200).getText()) *2;
                    ((Label) lastNode200).setText(String.valueOf(textNumber));
                    removeList.add(node);
                    lastNode200 = null;
                } else {
                    lastNode200 = node;
                }


            if ((int) node.getBoundsInParent().getMinY() == 300)
                if (lastNode300 == null) {
                    lastNode300 = node;
                } else if (((Label) node).getText().equals( ((Label) lastNode300).getText())  ){
                    int textNumber = Integer.parseInt(((Label) lastNode300).getText()) *2;
                    ((Label) lastNode300).setText(String.valueOf(textNumber));
                    removeList.add(node);
                    lastNode300 = null;
                } else {
                    lastNode300 = node;
                }
        }

        if (!(removeList.isEmpty()))
            board.getChildren().removeAll(removeList);
return board;
}

 synchronized    public GridPane removeNodeUpDown(GridPane board , String direction ) {
        Node lastNode0 = null;
        Node lastNode100 = null;
        Node lastNode200 = null;
        Node lastNode300 = null;
        List<Node> removeList = new ArrayList<Node>();
        SortedList<Node> sorted;

        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return ((int) node1.getBoundsInParent().getMinY() - (int) node2.getBoundsInParent().getMinY());
            }
        };

        if(direction == "up")

            sorted = new SortedList<Node>(board.getChildren(), comparator);
        else
            sorted = new SortedList<Node>(board.getChildren(), comparator.reversed());


        for (Node node : sorted) {

            if ((int) node.getBoundsInParent().getMinX() == 0)
                if (lastNode0 == null) {
                    lastNode0 = node;
                } else if (((Label) node).getText().equals( ((Label) lastNode0).getText())  ){
                    int textNumber = Integer.parseInt(((Label) lastNode0).getText()) *2;
                ((Label) lastNode0).setText(String.valueOf(textNumber));
                    removeList.add(node);
                    lastNode0 = null;
                } else {
                    lastNode0 = node;
                }

            if ((int) node.getBoundsInParent().getMinX() == 100)
                if (lastNode100 == null) {
                    lastNode100 = node;
                } else if (((Label) node).getText().equals( ((Label) lastNode100).getText())  ){
                    int textNumber = Integer.parseInt(((Label) lastNode100).getText()) *2;
                ((Label) lastNode100).setText(String.valueOf(textNumber));
                    removeList.add(node);
                    lastNode100 = null;
                } else {
                    lastNode100 = node;
                }

            if ((int) node.getBoundsInParent().getMinX() == 200)
                if (lastNode200 == null) {
                    lastNode200 = node;
                } else if (((Label) node).getText().equals( ((Label) lastNode200).getText())  ){
                    int textNumber = Integer.parseInt(((Label) lastNode200).getText()) *2;
                    ((Label) lastNode200).setText(String.valueOf(textNumber));
                    removeList.add(node);
                    lastNode200 = null;
                } else {
                    lastNode200 = node;
                }


            if ((int) node.getBoundsInParent().getMinX() == 300)
                if (lastNode300 == null) {
                    lastNode300 = node;
                } else if (((Label) node).getText().equals( ((Label) lastNode300).getText())  ){
                    int textNumber = Integer.parseInt(((Label) lastNode300).getText()) *2;
                    ((Label) lastNode300).setText(String.valueOf(textNumber));
                    removeList.add(node);
                    lastNode300 = null;
                } else {
                    lastNode300 = node;
                }
        }

        if (!(removeList.isEmpty()))
            board.getChildren().removeAll(removeList);
        return board;
    }






}
