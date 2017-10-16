package app2048;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.GridPane;

import static app2048.Utilities.checkNodeSpaceIsEmpty;
import static app2048.Utilities.shuffleArray;


public class NodeOper {

    GridPane board;

    public NodeOper(GridPane board) {
        this.board = board;
    }

    public GridPane addRndNode() {

        SimpleIntegerProperty number = new SimpleIntegerProperty(2);
        Tile tile = new Tile();
        int[] xCoordCol = shuffleArray();
        int[] yCoordRow = shuffleArray();

        for (int x = 0; x < xCoordCol.length; x++) {
            for (int y = 0; y < yCoordRow.length; y++) {

                if (checkNodeSpaceIsEmpty(xCoordCol[x], yCoordRow[y], board)) {
                    board.add(tile.getTile(), xCoordCol[x], yCoordRow[y]);

                    return board;

                }

            }

        }
        return board;
    }


    public GridPane addNode() {

        SimpleIntegerProperty number = new SimpleIntegerProperty(2);

        Tile tile = new Tile();
        board.add(tile.getTile(), 3, 3);
        return board;


    }
}
