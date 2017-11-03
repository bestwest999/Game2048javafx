package app2048;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import javax.swing.text.html.ListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class Utilities {


     static int[] shuffleArray() {
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


     static Boolean checkNodeSpaceIsEmpty (final int column, final int row, GridPane mainBoard) {
        ObservableList<Node> childrens = mainBoard.getChildren();


        for (Node node : childrens)
            if (node.getBoundsInParent().getMinY() == row && node.getBoundsInParent().getMinX() == column) {
                return false;
            }
        return true;
    }



}