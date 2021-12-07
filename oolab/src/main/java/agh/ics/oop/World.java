package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    public static void main(String[] args) {
        try {
            //LIST OF MOVES
            String[] moves = {"f", "b", "r", "l"};

            //PARSING MOVES LIST
            MoveDirection[] directions = new OptionsParser().parse(moves);

            //LIST OF INITIAL POSITIONS OF ANIMALS
            Vector2d[] positions = {new Vector2d(1, 2), new Vector2d(8, 7),new Vector2d(4,4)};

            //CREATE NEW GRASS FIELD MAP
            IWorldMap grassMap = new GrassField(10);

            //RUN ENGINE
            IEngine engine = new SimulationEngine(directions, grassMap, positions);
            engine.run();

            System.out.println(grassMap);

            Application.launch(App.class, args);

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

}
