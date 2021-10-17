package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("System wystartował");
        Direction[] myArgs = {Direction.FORWARD,Direction.FORWARD,Direction.LEFT,Direction.RIGHT};
        run(myArgs);
        System.out.println("System zakończył działanie ");
    }
    public static void run(Direction[] arr){
        for(Direction arg: arr){
            switch (arg){
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case LEFT:
                    System.out.println("Zwierzak idzie w lewo");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak idzie w prawo");
                    break;
                default: break;

            }
        }
    }
}
