package agh.ics.opp;
import agh.ics.oop.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegrationTest {
    Animal horse = new Animal();

    @Test
    public void randomWalkOrientationTest(){
        MoveDirection[] listOfMoves = {MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.RIGHT,MoveDirection.RIGHT,MoveDirection.BACKWARD};
        Arrays.stream(listOfMoves).forEach(m -> horse.move(m));
        MapDirection expectedDir = MapDirection.EAST;
        assertEquals(expectedDir,horse.curDir());
    }

    @Test
    public void fourSpinsOrientationTest(){
        for(int i=0;i<4;i++){
            horse.move(MoveDirection.LEFT);
        }
        MapDirection expectedDir = MapDirection.NORTH;
        assertEquals(expectedDir,horse.curDir());
    }

    @Test
    public void forwardWalkOrientationTest(){
        for(int i=0;i<100;i++){
            horse.move(MoveDirection.FORWARD);
        }
        MapDirection expectedDir = MapDirection.NORTH;
        assertEquals(expectedDir,horse.curDir());
    }

    @Test
    public void randomWalkPositionTest(){
        horse.move(MoveDirection.RIGHT);
        horse.move(MoveDirection.FORWARD);
        horse.move(MoveDirection.FORWARD);
        horse.move(MoveDirection.LEFT);
        horse.move(MoveDirection.FORWARD);
        horse.move(MoveDirection.BACKWARD);
        Vector2d expectedPosition = new Vector2d(4,2);
        assertTrue(horse.isAt(expectedPosition));
    }

    @Test
    public void returnToStartPositionTest(){
        for(int i=0;i<2;i++){
            horse.move(MoveDirection.FORWARD);
        }

        horse.move(MoveDirection.RIGHT);
        horse.move(MoveDirection.RIGHT);

        for(int i=0;i<2;i++){
            horse.move(MoveDirection.FORWARD);
        }
        Vector2d expectedPosition = new Vector2d(2,2);
        assertTrue(horse.isAt(expectedPosition));
    }

    @Test
    public void tryToWalkOutsidePositionTest(){
        for(int i=0;i<100;i++){
            horse.move(MoveDirection.FORWARD);
        }

        horse.move(MoveDirection.RIGHT);
        horse.move(MoveDirection.RIGHT);

        for(int i=0;i<100;i++){
            horse.move(MoveDirection.FORWARD);
        }
        Vector2d expectedPosition = new Vector2d(2,0);
        assertTrue(horse.isAt(expectedPosition));
    }

    @Test
    public void isInsideTheMapTest(){
        for(int i=0;i<10;i++){
            horse.move(MoveDirection.BACKWARD);
        }

        horse.move(MoveDirection.LEFT);

        for(int i=0;i<10;i++){
            horse.move(MoveDirection.FORWARD);
        }
        Vector2d expectedPosition = new Vector2d(0,0);
        assertTrue(horse.isAt(expectedPosition));
    }

    @Test
    public void randomWalkIsInsideTheMapTest(){
        for(int i=0;i<100;i++){
            horse.move(MoveDirection.BACKWARD);
        }

        horse.move(MoveDirection.LEFT);

        for(int i=0;i<100;i++){
            horse.move(MoveDirection.FORWARD);
        }
        Vector2d expectedPosition = new Vector2d(0,0);
        assertTrue(horse.isAt(expectedPosition));
    }

    @Test
    public void stringInputTest(){

        String[] listOfMoves = {"f","forward","kot","ala","backward","l","r"};
        OptionsParser parser = new OptionsParser();
        MoveDirection[] parsedList = parser.parse(listOfMoves);

        for(MoveDirection m:parsedList){
            horse.move(m);
        }

        Vector2d expectedPosition = new Vector2d(2,3);
        assertTrue(horse.isAt(expectedPosition));
    }

}
