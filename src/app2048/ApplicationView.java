
package  app2048;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import static app2048.Utilities.shuffleArray;


public class ApplicationView extends GridPane {
   GridPane board = new GridPane();

   public GridPane drawBoard() {
      board.setMinSize(400, 400);
      board.setGridLinesVisible(true);

      return board;
   }

   public void addNode() {
      //GridPane b = new GridPane();
      Label[] tile = new Tile[4];
      int[] xCoord = shuffleArray();
      int[] yCoord = shuffleArray();
    //  for (int x = 3; x > 0; x--) {
      //   for (int y = 3; y > 0; y--) {
            board.add(tile[0], xCoord[0], yCoord[0]);
            board.add(tile[1], xCoord[1], yCoord[1]);

        // }
      //}
   }
}


