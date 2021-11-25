package agh.ics.opp;
import agh.ics.oop.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    Animal animal = new Animal(new RectangularMap(4,4),new Vector2d(2,2));
    RectangularMap map = new RectangularMap(10,10);

    @Test
    public void canMoveToOccupiedPlaceTest(){
        map.place(animal);
        assertFalse(map.canMoveTo(new Vector2d(2,2)));
    }

    @Test
    public void canMoveToNotOccupiedPlaceTest(){
        map.place(animal);
        assertTrue(map.canMoveTo(new Vector2d(2,5)));
    }

    @Test
    public void canMoveToOutOfTheMapTest(){
        map.place(animal);
        assertFalse(map.canMoveTo(new Vector2d(-1,5)));
    }

    @Test
    public void placeBasicTest(){
        map.place(animal);
        assertTrue(map.isOccupied(new Vector2d(2,2)));
    }

    @Test
    public void placeInTheMapOccupiedTest(){
        map.place(animal);
        Animal animal_tmp = new Animal(map,new Vector2d(2,2));
        assertFalse(map.place(animal_tmp));
    }

    @Test
    public void isOccupiedBasicTest(){
        map.place(animal);
        assertTrue(map.isOccupied(new Vector2d(2,2)));
    }

    @Test
    public void isOccupiedFreePlaceTest(){
        assertFalse(map.isOccupied(new Vector2d(5,5)));
    }

    @Test
    public void ObjectAtTest(){
        map.place(animal);
        assertNotNull(map.objectAt(new Vector2d(2,2)));
    }

    @Test
    public void ObjectAtNullTest(){
        map.place(animal);
        assertNull(map.objectAt(new Vector2d(5,5)));
    }

}
