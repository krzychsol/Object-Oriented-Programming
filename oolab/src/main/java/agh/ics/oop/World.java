package agh.ics.oop;

public class World {
    public static void main(String[] args) {

        //LIST OF MOVES
        String[] moves = {"f","b","r","l"};

        //PARSING MOVES LIST
        MoveDirection[] directions = new OptionsParser().parse(moves);

        //LIST OF INITIAL POSITIONS OF ANIMALS
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };

        //CREATE NEW GRASS FIELD MAP
        IWorldMap grassMap = new GrassField(10);

        //RUN ENGINE
        IEngine engine = new SimulationEngine(directions, grassMap, positions);
        engine.run();

        System.out.println(grassMap);
    }

}
