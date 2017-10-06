package app2048;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;

/**
 * Created by Denis.Kalashnikov on 06/10/2017.
 */
public class Tile extends Label {
     public Label Tile(){
        SimpleIntegerProperty number = new SimpleIntegerProperty(2);
        Label tile = new Label();
        tile.textProperty().bind(number.asString());
        tile.setMinSize(100,100);
        return tile;
    }

}
