
package  app2048;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import static app2048.Utilities.shuffleArray;


public class ApplicationView extends GridPane {

     public GridPane drawBoard() {

        //pane[0].setVisible(false);
        GridPane board = new GridPane();
        board.setMinSize(400,400);
        board.setGridLinesVisible(true);
        return board;
    }

    public static void addNode(ApplicationView board) {
       //GridPane board = board;
       Label tile = new Tile();
       int[] xCoord = shuffleArray();
       int[] yCoord = shuffleArray();
       for (int x=3; x>0; x++){
          for (int y=3; y>0; y++) {
          }
       }
    }

 }

