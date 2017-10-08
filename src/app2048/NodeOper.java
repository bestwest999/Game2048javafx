package app2048;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import static app2048.Utilities.checkNodeSpaceIsEmpty;
import static app2048.Utilities.shuffleArray;


public class NodeOper {
    public GridPane addRndNode(GridPane Mainboard) {

        SimpleIntegerProperty number = new SimpleIntegerProperty(2);
        GridPane board = Mainboard;
        Label tile = new Label();
        tile.textProperty().bind(number.asString());
        tile.setMinSize(100, 100);
        int[] xCoordCol = shuffleArray();
        int[] yCoordRow = shuffleArray();
        //NodeOper first = new NodeOper();jgh
        //board = first.addNode(board);

        for (int x = 0; x < xCoordCol.length; x++) {
            for (int y = 0; y < yCoordRow.length; y++) {

                if (checkNodeSpaceIsEmpty(xCoordCol[x], yCoordRow[y], board)) {
                    board.add(tile, xCoordCol[x], yCoordRow[y]);

                    return board;

                }

            }

        }
        return board;
    }


    public GridPane addNode(GridPane Mainboard) {

        SimpleIntegerProperty number = new SimpleIntegerProperty(2);
        GridPane board = Mainboard;
        Label tile = new Label();
        tile.textProperty().bind(number.asString());
        tile.setMinSize(100, 100);
        board.add(tile, 3, 3);
        return board;


    }
}
