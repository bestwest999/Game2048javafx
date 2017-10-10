package app2048;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.animation.TranslateTransition;
import javafx.beans.Observable;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class Animation {

    private GridPane board;
    private ApplicationView view;
   static boolean  colis = false;
    BooleanBinding collission = new BooleanBinding() {
        @Override
        protected boolean computeValue() {
            return colis;
        }};


        public Animation(ApplicationView applicationView) {
            view = applicationView;
            board = view.getBoard();


        }

        public void moveTiles() {
            GridPane board = this.view.getBoard();
            ObservableList<Node> childrens = board.getChildren();
            ObservableList<Bounds> bounds = FXCollections.observableArrayList();


            for (Node node : childrens) {
                TranslateTransition tt = new TranslateTransition(Duration.seconds(1), node);
                node.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
                                                              @Override
                                                              public void changed(ObservableValue<? extends Bounds> observable, Bounds oldValue, Bounds newValue) {

                                                                  if (newValue.getMinX() < 0) {
                                                                        tt.stop();
                                                                      System.out.println("Fuck off");

                                                                  }
                                                              }
                                                          });
                       
                tt.setByX(-100);
                tt.setCycleCount(1);
                tt.play();


            }
        }

       // static public void collisionCheck(ObservableList<Node> children , Node node,  ) {



            //System.out.println("LayoutX = " + tile.getLayoutX() + "TranslateX = " + tile.getTranslateX() + "board witdth = " + board.getWidth());
            //System.out.println("getBoundsInParent = " + tile.getBoundsInParent() + "getBoundsInLocal = " + tile.getBoundsInLocal() + "getBoundsInLocal = " + board.getBoundsInLocal().getMaxX());



        public void handle(KeyEvent e) {
            //Animation animation= new Animation(view);
            String type = e.getEventType().getName();
            KeyCode keyCode = e.getCode();
            System.out.println(type + ": Key Code=" + keyCode.getName() + ", Text=" + e.getText());
            moveTiles();


        }


        public static void onChanged(ObservableValue<? extends Bounds> change, Bounds oldValue, Bounds newValue) {
            //System.out.println(change.toString());
            //System.out.println(newValue.getMinX());


            if (newValue.getMinX() < 0) {

                System.out.println("Fuck off");

            }
        }

    }


