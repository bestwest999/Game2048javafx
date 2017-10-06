package app2048;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AddNewNode {

    static void addNode(ApplicationView board) {
        int[] xCoord = shuffleArray();
        int[] yCoord = shuffleArray();


    }


    private static int[] shuffleArray() {
        Random rnd = ThreadLocalRandom.current();
        int[] ar = {0, 1, 2, 3};
        for (int i = 3; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            //dfgdf
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }
}