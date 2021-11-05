package agh.ics.opp;
import agh.ics.oop.MapDirection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {
    @Test
    public void nextWestTest(){
        MapDirection expected = MapDirection.WEST;
        assertEquals(expected,MapDirection.SOUTH.next());
    }

    @Test
    public void nextNorthTest(){
        MapDirection expected = MapDirection.NORTH;
        assertEquals(expected,MapDirection.WEST.next());
    }

    @Test
    public void nextEastTest(){
        MapDirection expected = MapDirection.EAST;
        assertEquals(expected,MapDirection.NORTH.next());
    }

    @Test
    public void nextSouthTest(){
        MapDirection expected = MapDirection.SOUTH;
        assertEquals(expected,MapDirection.EAST.next());
    }

    @Test
    public void previousWestTest(){
        MapDirection expected = MapDirection.WEST;
        assertEquals(expected,MapDirection.NORTH.previous());
    }

    @Test
    public void previousNorthTest(){
        MapDirection expected = MapDirection.NORTH;
        assertEquals(expected,MapDirection.EAST.previous());
    }

    @Test
    public void previousEastTest(){
        MapDirection expected = MapDirection.EAST;
        assertEquals(expected,MapDirection.SOUTH.previous());
    }

    @Test
    public void previousSouthTest(){
        MapDirection expected = MapDirection.SOUTH;
        assertEquals(expected,MapDirection.WEST.previous());
    }

}
