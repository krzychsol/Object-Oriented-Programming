package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("System wystartował");
        MoveDirection[] myArgs = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT};

        //Testing MapDirection Class
        MapDirection direction = MapDirection.EAST;
        System.out.println(direction);
        System.out.println(direction.next());
        System.out.println(direction.previous());
        System.out.println(direction.toUnitVector());

        run(myArgs);

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
        System.out.println("System zakończył działanie ");
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
