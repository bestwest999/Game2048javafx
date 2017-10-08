package app2048;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

import static app2048.Utilities.checkNodeSpaceIsEmpty;
import static app2048.Utilities.shuffleArray;


public class NodeOper {
    public GridPane addRndNode(GridPane Mainboard) {

        SimpleIntegerProperty number = new SimpleIntegerProperty(2);
        GridPane board = Mainboard;
        Label tile = new Label();
        tile.textProperty().bind(number.asString());
        tile.setMinSize(100, 100);
        tile.setAlignment(Pos.CENTER);
        tile.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: red; -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );-fx-background-color: yellow ");
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
        tile.setAlignment(Pos.CENTER);
        tile.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: red; -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );-fx-background-color: yellow ");
        board.add(tile, 3, 3);
        return board;


    }
}
