package agh.ics.oop;

import java.util.Map;

public class World {
    public static void main(String[] args) {
        System.out.println("System wystartował");
        MoveDirection[] myArgs = {MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.RIGHT};
        run(myArgs);
        System.out.println("System zakończył działanie ");
    }
    public static void run(MoveDirection[] arr){
        for(MoveDirection arg: arr){
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
            }
        }
    }
}
