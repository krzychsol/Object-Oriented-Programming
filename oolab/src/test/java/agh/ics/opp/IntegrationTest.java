package agh.ics.opp;
import agh.ics.oop.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {
    Animal animal = new Animal(new RectangularMap(4,4),new Vector2d(2,2));
    RectangularMap map = new RectangularMap(10,10);

    @Test
    public void randomWalkOrientationTest(){
        MoveDirection[] listOfMoves = {MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.RIGHT,MoveDirection.RIGHT,MoveDirection.BACKWARD};
        Arrays.stream(listOfMoves).forEach(m -> animal.move(m));
        MapDirection expectedDir = MapDirection.EAST;
        assertEquals(expectedDir,animal.curDirection());
    }

    @Test
    public void fourSpinsOrientationTest(){
        for(int i=0;i<4;i++){
            animal.move(MoveDirection.LEFT);
        }
        MapDirection expectedDir = MapDirection.NORTH;
        assertEquals(expectedDir,animal.curDirection());
    }

    @Test
    public void forwardWalkOrientationTest(){
        for(int i=0;i<100;i++){
            animal.move(MoveDirection.FORWARD);
        }
        MapDirection expectedDir = MapDirection.NORTH;
        assertEquals(expectedDir,animal.curDirection());
    }

    @Test
    public void randomWalkPositionTest(){
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.BACKWARD);
        Vector2d expectedPosition = new Vector2d(4,2);
        System.out.println(animal.curPosition());
        assertTrue(animal.isAt(expectedPosition));
    }

    @Test
    public void returnToStartPositionTest(){
        for(int i=0;i<2;i++){
            animal.move(MoveDirection.FORWARD);
        }

        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);

        for(int i=0;i<2;i++){
            animal.move(MoveDirection.FORWARD);
        }
        Vector2d expectedPosition = new Vector2d(2,2);
        assertTrue(animal.isAt(expectedPosition));
    }

    @Test
    public void tryToWalkOutsidePositionTest(){
        for(int i=0;i<100;i++){
            animal.move(MoveDirection.FORWARD);
        }

        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);

        for(int i=0;i<100;i++){
            animal.move(MoveDirection.FORWARD);
        }
        Vector2d expectedPosition = new Vector2d(2,0);
        assertTrue(animal.isAt(expectedPosition));
    }

    @Test
    public void isInsideTheMapTest(){
        for(int i=0;i<10;i++){
            animal.move(MoveDirection.BACKWARD);
        }

        animal.move(MoveDirection.LEFT);

        for(int i=0;i<10;i++){
            animal.move(MoveDirection.FORWARD);
        }
        Vector2d expectedPosition = new Vector2d(0,0);
        assertTrue(animal.isAt(expectedPosition));
    }

    @Test
    public void randomWalkIsInsideTheMapTest(){
        for(int i=0;i<100;i++){
            animal.move(MoveDirection.BACKWARD);
        }

        animal.move(MoveDirection.LEFT);

        for(int i=0;i<100;i++){
            animal.move(MoveDirection.FORWARD);
        }
        Vector2d expectedPosition = new Vector2d(0,0);
        assertTrue(animal.isAt(expectedPosition));
    }

    @Test
    public void stringInputTest(){

        String[] listOfMoves = {"f","forward","kot","ala","backward","l","r"};
        OptionsParser parser = new OptionsParser();
        MoveDirection[] parsedList = parser.parse(listOfMoves);

        for(MoveDirection m:parsedList){
            animal.move(m);
        }

        Vector2d expectedPosition = new Vector2d(2,3);
        assertTrue(animal.isAt(expectedPosition));
    }

    @Test
    public void canMoveToOccupiedPlaceTest(){
        Animal a1 = new Animal(map,new Vector2d(5,5));
        map.place(a1);
        assertFalse(map.canMoveTo(new Vector2d(5,5)));
    }

    @Test
    public void canMoveToOutOfTheMap(){
        assertFalse(map.canMoveTo(new Vector2d(125,125)));
    }

    @Test
    public void isOccupiedTest(){
        Animal a1 = new Animal(map,new Vector2d(5,5));
        map.place(a1);
        assertTrue(map.isOccupied(new Vector2d(5,5)));
    }

    @Test
    public void ObjectAtTest(){
        Animal a1 = new Animal(map,new Vector2d(5,5));
        map.place(a1);
        assertNotNull(map.objectAt(new Vector2d(5,5)));
    }

    @Test
    public void SimulationEngineTest(){
        String[] moves = {"f","b","r","l"};
        MoveDirection[] directions = new OptionsParser().parse(moves);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(2,3)));
        assertTrue(map.isOccupied(new Vector2d(3,3)));
    }

    @Test
    public void SimulationEngineCollisionTest(){
        String[] moves = {"f","b","r","l","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(moves);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,3) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(3,2)));
        assertTrue(map.isOccupied(new Vector2d(1,3)));
    }
}
