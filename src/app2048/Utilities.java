package app2048;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utilities {


    public static int[] shuffleArray() {
        Random rnd = ThreadLocalRandom.current();
        int[] ar = {0, 1, 2, 3};
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
//if(!(childrens == null)) {
//    return result;
//}

        for (Node node : childrens) {
            if (mainBoard.getRowIndex(node) == row && mainBoard.getColumnIndex(node) == column) {
                System.out.println("row= "+ mainBoard.getRowIndex(node)+ "col= " + mainBoard.getColumnIndex(node) );
                result = false;
                return result;
               // break;

            }
        }


        return result;
    }




}