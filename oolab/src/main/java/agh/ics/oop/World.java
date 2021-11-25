package agh.ics.oop;

import java.util.jar.Manifest;

public class World {
    public static void main(String[] args) {
        System.out.println("System wystartował");
        //MoveDirection[] myArgs = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT};
        //run(myArgs);

        //Moving the animal using OptionParser
        String[] moves = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(moves);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IWorldMap grassMap = new GrassField(10);
        IEngine engine = new SimulationEngine(directions, grassMap, positions);
        engine.run();
        System.out.println(grassMap);
        System.out.println("System zakończył działanie");

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
