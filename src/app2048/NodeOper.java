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
import static app2048.Utilities.shuffleArray;


public class NodeOper {


    public GridPane addRndNode(GridPane board) {

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

    public GridPane removeNode(GridPane board) {
        Node lastNode0 = null;
        Node lastNode100 = null;
        Node lastNode200 = null;
        Node lastNode300 = null;
        List<Node> removeList = new ArrayList<Node>();


        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return ((int) node1.getBoundsInParent().getMinX() - (int) node2.getBoundsInParent().getMinX());
            }
        };
        SortedList<Node> sorted = new SortedList<Node>(board.getChildren(), comparator);


        for (Node node : sorted) {

            if ((int) node.getBoundsInParent().getMinY() == 0)
                if (lastNode0 == null) {
                    lastNode0 = node;
                } else if (((Label) node).getText() == ((Label) lastNode0).getText()) {
                String id;
                    ((Label) lastNode0).setText("4");
                    id = node.getId();
                    removeList.add(node);
                   lastNode0 = null;
                } else {
                lastNode0 = node;
                }
        }

        if (!(removeList.isEmpty()))
            board.getChildren().removeAll(removeList);
return board;
}}
