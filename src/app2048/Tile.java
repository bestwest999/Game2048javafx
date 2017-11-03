package app2048;


import javafx.geometry.Pos;
import javafx.scene.control.Label;


 class Tile  {
  //  SimpleIntegerProperty number = new SimpleIntegerProperty(2);
    private  Label tile ;
private static Integer id = 1;
    Tile ()
    {
        tile= new Label();
        tile.setText("2");
        tile.setMinSize(100, 100);
        tile.setAlignment(Pos.CENTER);
        tile.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: red; -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );-fx-background-color: yellow;-fx-border-width: 4.0; -fx-border-color: blue;");
        tile.setId(id.toString());
        id++;
    }

    Label getTile() {
        return tile;
    }
}
