package app2048;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import javax.swing.text.StyledEditorKit;

import static app2048.Utilities.shuffleArray;


public class ApplicationView extends GridPane {
    private GridPane board = new GridPane();

    public GridPane getBoard() {
        return board;
    }

    public GridPane drawBoard() {
        board.setMinSize(400, 400);
        //board.setHgap(5);
        //board.setVgap(5);
        //board.setGridLinesVisible(true);

        int rowCount = 4;
        int colCount = 4;
        for (int i = 0; i < 4; i++) {
            ColumnConstraints numCol = new ColumnConstraints();
            numCol.setPercentWidth(100.0 / colCount);
            board.getColumnConstraints().add(numCol);
        }
        for (int i = 0; i < 4; i++) {
            RowConstraints numRow = new RowConstraints();
            numRow.setPercentHeight(100 / rowCount);
            board.getRowConstraints().add(numRow);
        }
        board.setFocusTraversable(true);
        requestFocus();

        NodeOper addnode = new NodeOper(board);
        addnode.addNode(board);
        for (int i = 0; i < 9; i++)
            board = addnode.addRndNode(board);
        return board;

    }


}


