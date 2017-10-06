
package  app2048;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import static app2048.Utilities.shuffleArray;


public class ApplicationView extends GridPane {
   GridPane board = new GridPane();


   public GridPane drawBoard() {


      SimpleIntegerProperty number = new SimpleIntegerProperty(2);
      board.setMinSize(400, 400);
      board.setGridLinesVisible(true);

      int rowCount = 4;
      int colCount = 4;
      for (int i=0; i<4; i++){
         ColumnConstraints numCol = new ColumnConstraints();
         numCol.setPercentWidth(100.0/colCount);
         board.getColumnConstraints().add(numCol);
      }
      for (int i=0; i<4; i++){
         RowConstraints numRow = new RowConstraints();
         numRow.setPercentHeight(100/rowCount);
         board.getRowConstraints().add(numRow);
      }


      Label tile = new Label();
      Label tile2 = new Label();
      tile.textProperty().bind(number.asString());
      tile.setMinSize(100,100);
      tile2.textProperty().bind(number.asString());
      tile2.setMinSize(100,100);
      int[] xCoord = shuffleArray();
      int[] yCoord = shuffleArray();

      return board;


   }
}


