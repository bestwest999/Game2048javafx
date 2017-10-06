package app2048;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import static app2048.Utilities.shuffleArray;

public class NodeOper {
    public GridPane addNode(GridPane Mainboard){

        SimpleIntegerProperty number = new SimpleIntegerProperty(2);
        GridPane board =  Mainboard;
        Label tile = new Label();
        Label tile2 = new Label();
        tile.textProperty().bind(number.asString());
        tile.setMinSize(100,100);
        tile2.textProperty().bind(number.asString());
        tile2.setMinSize(100,100);
        int[] xCoord = shuffleArray();
        int[] yCoord = shuffleArray();
        board.add(tile,3,3);
        return board;
    }
}
