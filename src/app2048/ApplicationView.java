
package  app2048;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import static app2048.Utilities.shuffleArray;


public class ApplicationView extends GridPane {
   GridPane board = new GridPane();


   public GridPane drawBoard() {

      //addNode();
     // return board;
   //}

  // public void addNode() {
      //GridPane b = new GridPane();
      SimpleIntegerProperty number = new SimpleIntegerProperty(2);
      board.setMinSize(400, 400);
      board.setGridLinesVisible(true);
      Label tile = new Label();
      Label tile2 = new Label();
      tile.textProperty().bind(number.asString());
      tile.setMinSize(100,100);
      tile2.textProperty().bind(number.asString());
      tile2.setMinSize(100,100);
      int[] xCoord = shuffleArray();
      System.out.println("a=" + xCoord[0] + "b=" + xCoord[1] + "c=" + xCoord[2] + "d=" + xCoord[3]);
      int[] yCoord = shuffleArray();
      System.out.println("a=" + yCoord[0] + "b=" + yCoord[1] + "c=" + yCoord[2] + "d=" + yCoord[3]);
      int a = xCoord[0];
      int b = yCoord[1];
      //  for (int x = 3; x > 0; x--) {
      //   for (int y = 3; y > 0; y--) {
            board.add(tile, a, b);
            board.add(tile2, xCoord[a], yCoord[b]);
      return board;

        // }
      //}
   }}
//}


