package app2048;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import static app2048.Utilities.shuffleArray;
import static app2048.Utilities.getNodeByRowColumnIndex;

public class NodeOper {
    public GridPane addRndNode(GridPane Mainboard) {

        SimpleIntegerProperty number = new SimpleIntegerProperty(2);
        GridPane board = Mainboard;
        Label tile = new Label();
        tile.textProperty().bind(number.asString());
        tile.setMinSize(100, 100);
        int[] xCoord = shuffleArray();
        int[] yCoord = shuffleArray();
        //NodeOper first = new NodeOper();
        //board = first.addNode(board);

        for (int x = 0; x < xCoord.length - 1;x++) {
            for (int y = 0; y < yCoord.length - 1;y++) {

                if (getNodeByRowColumnIndex(xCoord[x], yCoord[y], board)) {
                    board.add(tile, xCoord[x], yCoord[y]);
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
