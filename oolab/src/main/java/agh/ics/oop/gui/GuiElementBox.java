package agh.ics.oop.gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import agh.ics.oop.Animal;
import agh.ics.oop.IMapElement;
import agh.ics.oop.Vector2d;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import static javafx.geometry.Pos.CENTER;

public class GuiElementBox {

    public VBox cellContainer = new VBox();

    public GuiElementBox(IMapElement currentObject, Vector2d animalPosition){
        Image image = null;
        String path = "";
        {
            try {
                if(currentObject instanceof Animal){
                    String direction = ((Animal) currentObject).curDirection().toString();
                    switch (direction){
                        case "Północ" -> path = currentObject.getUpIconPath();
                        case "Południe" -> path = currentObject.getDownIconPath();
                        case "Wschód" -> path = currentObject.getLeftIconPath();
                        case "Zachód" -> path = currentObject.getRightIconPath();
                    }
                }
                else{
                    path = currentObject.getGrassIconPath();
                }
                image = new Image(new FileInputStream(path));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        Label animalPos = new Label(animalPosition.toString());
        cellContainer.getChildren().add(imageView);
        cellContainer.getChildren().add(animalPos);
        cellContainer.setAlignment(CENTER);

    }
}
