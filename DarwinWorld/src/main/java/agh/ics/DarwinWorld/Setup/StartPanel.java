package agh.ics.DarwinWorld.Setup;

import agh.ics.DarwinWorld.Map.RectangularMap;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel implements ActionListener {

    //
    public static final int PANEL_HEIGHT = 600;
    public static final int PANEL_WIDTH = 600;

    //Fields for data entry
    private TextField width;
    private TextField height;
    private TextField startAnimalEnergy;
    private TextField moveEnergy;
    private TextField plantEnergy;
    private TextField jungleRatio;

    //Labels to identify the fields
    private Label widthLabel;
    private Label heightLabel;
    private Label startAnimalEnergyLabel;
    private Label moveEnergyLabel;
    private Label plantEnergyLabel;
    private Label jungleRatioLabel;

    //button
    private Button startButton;

    //Scene
    private Scene start;

    public StartPanel(int[] defaultParameters){

        //LABELS
        widthLabel = new Label("Map width:      ");
        heightLabel = new Label("Map height:      ");
        startAnimalEnergyLabel = new Label("Animal start energy:      ");
        moveEnergyLabel = new Label("Daily energy cost:      ");
        plantEnergyLabel = new Label("Grass energy profit:      ");
        jungleRatioLabel = new Label("Ratio between jungle and steppe (%):      ");

        //TEXT FIELDS
        int a = 10;
        width = new TextField();
        width.setPrefColumnCount(a);
        width.setText(defaultParameters[0].toString());

        height = new TextField();
        height.setPrefColumnCount(a);
        height.setText(defaultParameters[1].toString());

        startAnimalEnergy = new TextField();
        startAnimalEnergy.setPrefColumnCount(a);
        startAnimalEnergy.setText(defaultParameters[2].toString());

        moveEnergy = new TextField();
        moveEnergy.setPrefColumnCount(a);
        moveEnergy.setText(defaultParameters[3].toString());

        plantEnergy = new TextField();
        plantEnergy.setPrefColumnCount(a);
        plantEnergy.setText(defaultParameters[4].toString());

        jungleRatio = new TextField();
        jungleRatio.setPrefColumnCount(a);
        jungleRatio.setText(defaultParameters[5].toString());

        //ADD TEXT FIELDS TO LABELS
        widthLabel.setLabelFor(width);
        heightLabel.setLabelFor(height);
        startAnimalEnergyLabel.setLabelFor(startAnimalEnergy);
        moveEnergyLabel.setLabelFor(moveEnergy);
        plantEnergyLabel.setLabelFor(plantEnergy);
        jungleRatioLabel.setLabelFor(jungleRatio);

        VBox box1 = new VBox(widthLabel,width);
        VBox box2 = new VBox(heightLabel,height);
        VBox box3 = new VBox(startAnimalEnergyLabel,startAnimalEnergy);
        VBox box4 = new VBox(moveEnergyLabel,moveEnergy);
        VBox box5 = new VBox(plantEnergyLabel,plantEnergy);
        VBox box6 = new VBox(jungleRatioLabel,jungleRatio);

        //ADD BUTTON
        startButton = new Button();

        //Scene mainPanel = new Scene()
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RectangularMap map = new RectangularMap(
                Integer.parseInt(width.getText()),
                Integer.parseInt(height.getText()),
                Integer.parseInt(startAnimalEnergy.getText()),
                Integer.parseInt(moveEnergy.getText()),
                Integer.parseInt(plantEnergy.getText()),
                Integer.parseInt(jungleRatio.getText()),
        );
        //IEngine simulation = new SimulationEngine(
                //map, Integer.parseInt(delay.getText()),
                //Integer.parseInt(numOfSpawnedAnimals.getText()),
                //Integer.parseInt(grassSpawnedInEachDay.getText()));
        //simulation.startSimulation();
    }
}
