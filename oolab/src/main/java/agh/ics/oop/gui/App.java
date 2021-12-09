package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import java.util.List;
import java.util.Map;

public class App extends Application {

    Label label = new Label("Zwierzak");
    Scene scene = new Scene(label,400,400);
    private AbstractWorldMap map;
    private int width;
    private int height;

    @Override
    public void init() throws Exception
    {
        try {
            //LIST OF MOVES
            String[] moves = {"f", "b", "r", "l"};

            //PARSING MOVES LIST
            MoveDirection[] directions = new OptionsParser().parse(moves);

            //LIST OF INITIAL POSITIONS OF ANIMALS
            Vector2d[] positions = {new Vector2d(1, 2), new Vector2d(8, 7),new Vector2d(4,4)};

            //CREATE NEW GRASS FIELD MAP
            AbstractWorldMap grassMap = new GrassField(10);

            //RUN ENGINE
            IEngine engine = new SimulationEngine(directions, grassMap, positions);
            engine.run();

            this.map = grassMap;
            this.width = map.getUpperRight().x - map.getLowerLeft().x;
            this.height = map.getUpperRight().y - map.getLowerLeft().y;

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(width));
        grid.getRowConstraints().add(new RowConstraints(height));
        grid.setGridLinesVisible(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
