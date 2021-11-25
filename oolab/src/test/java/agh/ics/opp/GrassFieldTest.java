package agh.ics.opp;
import agh.ics.oop.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {
    GrassField grassMap = new GrassField(10);
    Vector2d animalPos = new Vector2d(2,2);
    Animal animal = new Animal(grassMap,animalPos);

    @Test
    public void canMoveToOccupiedPlaceTest(){
        grassMap.place(animal);
        assertFalse(grassMap.canMoveTo(animalPos));
    }

    @Test
    public void canMoveToOutOfTheMapTest(){
        grassMap.place(animal);
        assertFalse(grassMap.canMoveTo(new Vector2d(Integer.MAX_VALUE+10,Integer.MAX_VALUE+10)));
    }

    @Test
    public void placeAnimalOnGrassTest(){
        Grass grass = new Grass(animalPos);
        grassMap.grassList.add(grass);
        assertTrue(grassMap.place(animal));
    }

    @Test
    public void placeInTheMapOccupiedTest(){
        grassMap.place(animal);
        Animal animal_tmp = new Animal(grassMap,animalPos);
        assertFalse(grassMap.place(animal_tmp));
    }

    @Test
    public void isOccupiedAnimalTest(){
        grassMap.place(animal);
        assertTrue(grassMap.isOccupied(animalPos));
    }

    @Test
    public void isOccupiedFreePlaceTest(){
        assertFalse(grassMap.isOccupied(new Vector2d(5,5)));
    }

    @Test
    public void isOccupiedGrassTest(){
        Grass grass = new Grass(animalPos);
        grassMap.grassList.add(grass);
        assertTrue(grassMap.isOccupied(new Vector2d(2,2)));
    }

    @Test
    public void ObjectAtAnimalTest(){
        grassMap.place(animal);
        assertNotNull(grassMap.objectAt(animalPos));
    }

    @Test
    public void ObjectAtGrassTest(){
        Grass grass = new Grass(animalPos);
        grassMap.grassList.add(grass);
        assertNotNull(grassMap.objectAt(animalPos));
    }

    @Test
    public void ObjectAtNullTest(){
        grassMap.place(animal);
        assertNull(grassMap.objectAt(new Vector2d(5,5)));
    }
}
