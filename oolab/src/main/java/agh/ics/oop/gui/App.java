package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application implements IGridPaneChangeObserver{

    private final Vector2d[] positions = {new Vector2d(1, 2), new Vector2d(8, 7),new Vector2d(9,9)};
    private final AbstractWorldMap grassMap = new GrassField(10);
    GridPane grid = new GridPane();
    Stage primaryStage = new Stage();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        grid = draw(grassMap,grassMap.getUpperRight(),grassMap.getLowerLeft());
        createScene(grid);
    }

    public GridPane draw(AbstractWorldMap map, Vector2d upRight, Vector2d lowLeft){

        //Set range of map side
        int startX = lowLeft.x;
        int endX = upRight.x;
        int startY = lowLeft.y;
        int endY = upRight.y;

        Label leftUpCornerIcon = new Label("y/x");
        grid.add(leftUpCornerIcon,0,0,1,1);

        for( int j=startX; j<=endX; j++ ){
            Label label = new Label(((Integer) j).toString());
            grid.add(label,j,0,1,1);
            GridPane.setHalignment(label, HPos.CENTER);
            grid.getColumnConstraints().add(new ColumnConstraints(40));
        }
        grid.getColumnConstraints().add(new ColumnConstraints(40));

        for( int j=startY; j<=endY; j++ ){
            Label label = new Label(((Integer) j).toString());
            grid.add(label,0,endY-j+1,1,1);
            grid.getRowConstraints().add(new RowConstraints(40));
        }
        grid.getRowConstraints().add(new RowConstraints(40));

        for( int i=startY; i<=endY;i++ ){
            for( int j=startX; j<=endX; j++ ){
                Vector2d position = new Vector2d(j,i);
                Label currentCell;
                if (map.objectAt(position) == null){
                    currentCell = new Label(" ");
                    grid.add(currentCell,j,endY-i+1,1,1);
                }
                else {
                    GuiElementBox objectAtCurrentPosition = new GuiElementBox((IMapElement)map.objectAt(position),position);
                    currentCell = new Label(map.objectAt(position).toString());
                    grid.add(objectAtCurrentPosition.cellContainer,j,endY-i+1,1,1);
                }

                GridPane.setHalignment(currentCell, HPos.CENTER);
            }
        }

        grid.setGridLinesVisible(true);
        return grid;
    }

    public void updateGridPane(){
        Platform.runLater(()->{
            grid.getChildren().clear();
            Vector2d lowerLeft = grassMap.getLowerLeft();
            Vector2d upperRight = grassMap.getUpperRight();
            grid = draw(grassMap,upperRight,lowerLeft);
            Scene scene = createScene(grid);
            primaryStage.setScene(scene);
            primaryStage.show();
        });
    }

    private Scene createScene(GridPane grid){
        TextField text = new TextField();
        Button button = new Button("Start");
        button.setOnAction(event -> {
            MoveDirection[] directions = new OptionsParser().parse(text.getText().split(" "));
            IEngine engine = new SimulationEngine(directions, grassMap, positions,this);
            Thread engineThread = new Thread((Runnable) engine);
            engineThread.start();
        });
        VBox box = new VBox(grid,button,text);
        box.setAlignment(Pos.CENTER);
        return new Scene(box,500,500);
    }

    @Override
    public void gridPaneChanged() {
        updateGridPane();
    }
}
