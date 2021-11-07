package agh.ics.oop;

import java.util.jar.Manifest;

public class World {
    public static void main(String[] args) {
        /*
        System.out.println("System wystartował");
        //MoveDirection[] myArgs = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT};

        //Testing MapDirection Class
        MapDirection direction = MapDirection.EAST;
        System.out.println(direction);
        System.out.println(direction.next());
        System.out.println(direction.previous());
        System.out.println(direction.toUnitVector());

        //run(myArgs);

        //Testing Animal Class

        Animal hedgehog = new Animal();
        System.out.println(hedgehog);
        Vector2d v = new Vector2d(2, 2);
        System.out.println(hedgehog.isAt(v));
        hedgehog.move(MoveDirection.RIGHT);
        hedgehog.move(MoveDirection.FORWARD);
        hedgehog.move(MoveDirection.FORWARD);
        hedgehog.move(MoveDirection.FORWARD);
        System.out.println(hedgehog);

        //Moving the animal using OptionParser
        String[] moves = {"f", "forward", "kaczka", "b", "l", "reka", "r"};
        OptionsParser parseMoves = new OptionsParser();
        MoveDirection[] listOfMoves = parseMoves.parse(moves);
        for (MoveDirection m : listOfMoves) {
            hedgehog.move(m);
        }
        System.out.println(hedgehog);

        RectangularMap map1 = new RectangularMap(4,4);
        Vector2d v1 = new Vector2d(2,2);
        Vector2d v2 = new Vector2d(2,2);
        Vector2d v3 = new Vector2d(3,2);
        Animal animal1 = new Animal(map1,v1);
        //Animal animal2 = new Animal(map1,v2);
        Animal animal3 = new Animal(map1,v3);
        System.out.println(map1.place(animal1));
        System.out.println(map1.place(animal3));
        System.out.println(map1.toString());
        //System.out.println(map1.drawMap(map1));
         */
        String[] myArgs = {"forward","b","asd","left","backward","backward","right"};
        MoveDirection[] directions = new OptionsParser().parse(myArgs);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map.objectAt(new Vector2d(2,2)));
        System.out.println(map.objectAt(new Vector2d(3,4)));
        System.out.println(map.objectAt(new Vector2d(1,2)));
        System.out.println(map.objectAt(new Vector2d(4,3)));

    }

    public static void run(MoveDirection[] arr) {
        for (MoveDirection arg : arr) {
            switch (arg) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case LEFT -> System.out.println("Zwierzak idzie w lewo");
                case RIGHT -> System.out.println("Zwierzak idzie w prawo");
                default -> System.out.println("Nieznana komenda");
            }
        }
    }
}
