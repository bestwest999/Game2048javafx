
package  app2048;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;



 public class ApplicationView {

    private SimpleIntegerProperty number = new SimpleIntegerProperty(2);

     public GridPane drawBoard() {
        Label[] pane = new Label[2];
        Label a = new Label();
        Label b = new Label();
         Label c = new Label();
        a.textProperty().bind(number.asString());
        b.textProperty().bind(number.asString());


        pane[0] = a;
        pane[1] = b;
        pane[0].setMinSize(100, 100);
        pane[1].setMinSize(100, 100);
        pane[0].setVisible(false);
        GridPane board = new GridPane();
        board.setMinSize(400,400);
        board.add(pane[0],0,0);
        board.add(pane[1],1,0);
        board.setGridLinesVisible(true);
        return board;
    }
}

