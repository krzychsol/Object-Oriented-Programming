package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


public class App extends Application {

    GridPane grid = new GridPane();
    Scene scene = new Scene(grid,400,400);

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            //LIST OF MOVES
            String[] moves = {"f", "b", "r", "l"};

            //PARSING MOVES LIST
            MoveDirection[] directions = new OptionsParser().parse(moves);

            //LIST OF INITIAL POSITIONS OF ANIMALS
            Vector2d[] positions = {new Vector2d(1, 2), new Vector2d(8, 7),new Vector2d(10,10)};

            //CREATE NEW GRASS FIELD MAP
            AbstractWorldMap grassMap = new GrassField(10);

            //RUN ENGINE
            IEngine engine = new SimulationEngine(directions, grassMap, positions);
            engine.run();
            System.out.println(grassMap);

            //Set range of map side
            int startX = grassMap.getLowerLeft().x;
            int endX = grassMap.getUpperRight().x;
            int startY = grassMap.getLowerLeft().y;
            int endY = grassMap.getUpperRight().y;

            Label UpperLeftSymbol = new Label("y/x");
            grid.add(UpperLeftSymbol,0,0,1,1);

            for( int j=startX; j<=endX; j++ ){
                Label label = new Label(((Integer) j).toString());
                grid.add(label,j,0,1,1);
                GridPane.setHalignment(label, HPos.CENTER);
                grid.getColumnConstraints().add(new ColumnConstraints(30));
            }
            grid.getColumnConstraints().add(new ColumnConstraints(30));

            for( int j=startY; j<=endY; j++ ){
                Label label = new Label(((Integer) j).toString());
                grid.add(label,0,endY-j+1,1,1);
                grid.getRowConstraints().add(new RowConstraints(30));
            }
            grid.getRowConstraints().add(new RowConstraints(30));

            for( int i=startY; i<=endY;i++ ){
                for( int j=startX; j<=endX; j++ ){
                    Vector2d position = new Vector2d(j,i);
                    Label currentCell;
                    if (grassMap.objectAt(position) == null){
                        currentCell = new Label(" ");
                    }
                    else {
                        currentCell = new Label(grassMap.objectAt(position).toString());
                    }
                    grid.add(currentCell,j,endY-i+1,1,1);
                    GridPane.setHalignment(currentCell, HPos.CENTER);
                }
            }

            grid.setGridLinesVisible(true);
            primaryStage.setScene(scene);
            primaryStage.show();


        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
