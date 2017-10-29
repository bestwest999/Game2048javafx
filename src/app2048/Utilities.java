package app2048;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import javax.swing.text.html.ListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utilities {


    public static int[] shuffleArray() {
        Random rnd = ThreadLocalRandom.current();
        int[] ar = {0, 100, 200, 300};
        for (int i = 3; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }


    public static Boolean checkNodeSpaceIsEmpty (final int column, final int row, GridPane mainBoard) {
        Boolean result = true;

        ObservableList<Node> childrens = mainBoard.getChildren();


        for (Node node : childrens)
            if (node.getBoundsInParent().getMinY() == row && node.getBoundsInParent().getMinX() == column) {
             //   System.out.println("row= "+ node.getTranslateX()+ "col= " + node.getTranslateY() );
                result = false;
                return result;
            }


        //System.out.println("row= "+ row + "col= " + column );
        return result;
    }


public static List<Node> removeList (int x, Node node){
Node lastNode = null;
List<Node> removeList = new ArrayList<Node>();


return removeList;
}

}