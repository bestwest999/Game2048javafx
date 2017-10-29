package app2048;


import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.util.Comparator;


public class Animation {

    private GridPane board;
    private ApplicationView view;
    Boolean column = false;


    Runnable removeNodeLeft = new Runnable() {
        @Override
        public void run() {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    NodeOper nodeoper = new NodeOper();
                    nodeoper.removeNode(board);
                    moveLeft();
                }
            });


        }
    };


    Runnable addRndNode = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(120);
            } catch (InterruptedException f) {
            }

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    NodeOper nodeoper = new NodeOper();
                    nodeoper.addRndNode(board);

                }
            });


        }
    };

    public Animation(ApplicationView applicationView) {
        view = applicationView;
        board = view.getBoard();


    }

    /*
     moveLeft() move all present tiles to left
     @param firstRowDist, secondRowDist, thirdRowDist, fouthRoWDist - distance filled by tilse that are allready moved left
     */

    public void moveLeft() {
        GridPane board = this.view.getBoard();
      //  ObservableList<Node> childrens = board.getChildren();

        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return ((int) node1.getBoundsInParent().getMinX() - (int) node2.getBoundsInParent().getMinX());
            }
        };
        SortedList<Node> sorted = new SortedList<Node>(board.getChildren(), comparator);

        double firstRowDist = 0;
        double secondRowDist = 0;
        double thirdRowDist = 0;
        double fouthRowDist = 0;

        for (Node node : sorted) {
            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.1), node);

            if (node.getBoundsInParent().getMinY() == 0) {
                tt.setByX(-(node.getBoundsInParent().getMinX()) + firstRowDist);
                firstRowDist += 100;
                tt.play();

            } else if (node.getBoundsInParent().getMinY() == 100) {

                tt.setByX(-(node.getBoundsInParent().getMinX()) + secondRowDist);
                secondRowDist += 100;
                tt.play();

            } else if (node.getBoundsInParent().getMinY() == 200) {
                tt.setByX(-(node.getBoundsInParent().getMinX()) + thirdRowDist);
                thirdRowDist += 100;
                tt.play();

            } else if (node.getBoundsInParent().getMinY() == 300) {
                tt.setByX(-(node.getBoundsInParent().getMinX()) + fouthRowDist);
                fouthRowDist += 100;
                tt.play();

            }
        }


    }

       /*
     moveRight() move all present tiles to left
     @param firstRowDist, secondRowDist, thirdRowDist, fouthRoWDist - distance not filled by tilse that are allready moved right
     */

    public void moveRight() {
        GridPane board = this.view.getBoard();
        ObservableList<Node> childrens = board.getChildren();
        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return ((int) node1.getBoundsInParent().getMinX() - (int) node2.getBoundsInParent().getMinX());
            }
        };
        SortedList<Node> sorted = new SortedList<Node>(childrens, comparator.reversed());
        double firstRowDist = 300;
        double secondRowDist = 300;
        double thirdRowDist = 300;
        double fouthRowDist = 300;

        for (Node node : sorted) {
            ObservableList<Bounds> bounds = FXCollections.observableArrayList();
            bounds.add(node.getBoundsInParent());
            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.1), node);
            if (node.getBoundsInParent().getMinY() == 0) {
                tt.setByX(-(node.getBoundsInParent().getMinX() - firstRowDist));
                firstRowDist -= 100;

            } else if (node.getBoundsInParent().getMinY() == 100) {
                tt.setByX(-(node.getBoundsInParent().getMinX() - secondRowDist));
                secondRowDist -= 100;
            } else if (node.getBoundsInParent().getMinY() == 200) {
                tt.setByX(-(node.getBoundsInParent().getMinX() - thirdRowDist));
                thirdRowDist -= 100;
            } else if (node.getBoundsInParent().getMinY() == 300) {
                tt.setByX(-(node.getBoundsInParent().getMinX() - fouthRowDist));
                fouthRowDist -= 100;

            }
            tt.play();
        }


    }


    public void moveUp() {
        GridPane board = this.view.getBoard();
        ObservableList<Node> childrens = board.getChildren();

        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return ((int) node1.getBoundsInParent().getMinY() - (int) node2.getBoundsInParent().getMinY());
            }
        };
        SortedList<Node> sorted = new SortedList<Node>(childrens, comparator);

        double firstColDist = 0;
        double secondColDist = 0;
        double thirdColDist = 0;
        double fouthColDist = 0;

        for (Node node : sorted) {
            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.1), node);

            if (node.getBoundsInParent().getMinX() == 0) {
                tt.setByY(-(node.getBoundsInParent().getMinY()) + firstColDist);
                firstColDist += 100;
                tt.play();
            } else if (node.getBoundsInParent().getMinX() == 100) {

                tt.setByY(-(node.getBoundsInParent().getMinY()) + secondColDist);
                secondColDist += 100;
                tt.play();
            } else if (node.getBoundsInParent().getMinX() == 200) {
                tt.setByY(-(node.getBoundsInParent().getMinY()) + thirdColDist);
                thirdColDist += 100;
                tt.play();
            } else if (node.getBoundsInParent().getMinX() == 300) {
                tt.setByY(-(node.getBoundsInParent().getMinY()) + fouthColDist);
                fouthColDist += 100;
                tt.play();
            }
        }

    }


    public void moveDown() {
        GridPane board = this.view.getBoard();
        ObservableList<Node> childrens = board.getChildren();

        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return ((int) node1.getBoundsInParent().getMinY() - (int) node2.getBoundsInParent().getMinY());
            }
        };
        SortedList<Node> sorted = new SortedList<Node>(childrens, comparator.reversed());

        double firstColDist = 300;
        double secondColDist = 300;
        double thirdColDist = 300;
        double fouthColDist = 300;

        for (Node node : sorted) {
            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.1), node);

            if (node.getBoundsInParent().getMinX() == 0) {
                tt.setByY(-(node.getBoundsInParent().getMinY() - firstColDist));
                firstColDist -= 100;
                tt.play();
            } else if (node.getBoundsInParent().getMinX() == 100) {

                tt.setByY(-(node.getBoundsInParent().getMinY() - secondColDist));
                secondColDist -= 100;
                tt.play();
            } else if (node.getBoundsInParent().getMinX() == 200) {
                tt.setByY(-(node.getBoundsInParent().getMinY() - thirdColDist));
                thirdColDist -= 100;
                tt.play();
            } else if (node.getBoundsInParent().getMinX() == 300) {
                tt.setByY(-(node.getBoundsInParent().getMinY() - fouthColDist));
                fouthColDist -= 100;
                tt.play();
            }
        }

    }


    public void handle(KeyEvent e) {

        String type = e.getEventType().getName();
        KeyCode keyCode = e.getCode();
        if (e.getCode() == KeyCode.LEFT) {
            moveLeft();
            new Thread(removeNodeLeft).start();
            new Thread(addRndNode).start();
        } else if (e.getCode() == KeyCode.RIGHT) {
            moveRight();
            new Thread(addRndNode).start();
        } else if (e.getCode() == KeyCode.UP) {
            moveUp();
            new Thread(addRndNode).start();
        } else if (e.getCode() == KeyCode.DOWN) {
            moveDown();
            new Thread(addRndNode).start();
        }


    }


}
