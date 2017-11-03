package app2048;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;



 class ApplicationView extends GridPane {
  private GridPane board = new GridPane();

   synchronized   GridPane getBoard() {
        return board;
    }

 synchronized GridPane drawBoard() {
       board.setMinSize(400, 400);

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

        NodeOper addNode = new NodeOper();
        addNode.addRndNode(board);
        return board;

    }


}


