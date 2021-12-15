package agh.ics.oop.gui;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class GiuElementBox {

    public GiuElementBox(){
        Image image = null;
        {
            try {
                image = new Image(new FileInputStream("src/main/resources/up.png"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        Label animalPosition = new Label();
        VBox cellContainer = new VBox();
    }
}
