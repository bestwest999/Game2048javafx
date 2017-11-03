package app2048;



import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Label;


class Tile {
    private Label tile;
    private static Integer id = 1;

    Tile() {
        tile = new Label();
        tile.setText("2");
        tile.setMinSize(100, 100);
        tile.setAlignment(Pos.CENTER);
        tile.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: red; -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );-fx-background-color: yellow;-fx-border-width: 4.0; -fx-border-color: blue;");
        tile.setId(id.toString());
        id++;
        tile.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.equals("4")) {
                    tile.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: red; -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );-fx-background-color: orange;-fx-border-width: 4.0; -fx-border-color: blue;");

                }
                if (newValue.equals("8")) {
                    tile.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: red; -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );-fx-background-color: #d0ffdc;-fx-border-width: 4.0; -fx-border-color: blue;");

                }
                if (newValue.equals("16")) {
                    tile.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: red; -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );-fx-background-color: #ff37ce;-fx-border-width: 4.0; -fx-border-color: blue;");

                }
                if (newValue.equals("32")) {
                    tile.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: red; -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );-fx-background-color: #23ffe1;-fx-border-width: 4.0; -fx-border-color: blue;");

                }
                if (newValue.equals("64")) {
                    tile.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: red; -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );-fx-background-color: #1bff31;-fx-border-width: 4.0; -fx-border-color: blue;");

                }
                if (newValue.equals("128")) {
                    tile.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: red; -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );-fx-background-color: #25918d;-fx-border-width: 4.0; -fx-border-color: blue;");

                }
                if (newValue.equals("256")) {
                    tile.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: red; -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );-fx-background-color: #682195;-fx-border-width: 4.0; -fx-border-color: blue;");

                }
                if (newValue.equals("512")) {
                    tile.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: red; -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );-fx-background-color: #2adaff;-fx-border-width: 4.0; -fx-border-color: blue;");

                }
                if (newValue.equals("1024")) {
                    tile.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: red; -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );-fx-background-color: #ff5b20;-fx-border-width: 4.0; -fx-border-color: blue;");

                }
                if (newValue.equals("2048")) {
                    tile.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: red; -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );-fx-background-color: #070607;-fx-border-width: 4.0; -fx-border-color: blue;");

                }

            }
        });
    }

    Label getTile() {
        return tile;
    }
}
