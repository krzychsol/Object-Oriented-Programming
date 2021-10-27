package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {
    @Test
    public void nextTest1(){
        MapDirection expected = MapDirection.WEST;
        assertEquals(expected,MapDirection.SOUTH.next());
    }

    @Test
    public void nextTest2(){
        MapDirection expected = MapDirection.NORTH;
        assertEquals(expected,MapDirection.WEST.next());
    }

    @Test
    public void nextTest3(){
        MapDirection expected = MapDirection.EAST;
        assertEquals(expected,MapDirection.NORTH.next());
    }

    @Test
    public void nextTest4(){
        MapDirection expected = MapDirection.SOUTH;
        assertEquals(expected,MapDirection.EAST.next());
    }

    @Test
    public void previosuTest1(){
        MapDirection expected = MapDirection.WEST;
        assertEquals(expected,MapDirection.NORTH.previous());
    }

    @Test
    public void previousTest2(){
        MapDirection expected = MapDirection.NORTH;
        assertEquals(expected,MapDirection.EAST.previous());
    }

    @Test
    public void previousTest3(){
        MapDirection expected = MapDirection.EAST;
        assertEquals(expected,MapDirection.SOUTH.previous());
    }

    @Test
    public void previousTest4(){
        MapDirection expected = MapDirection.SOUTH;
        assertEquals(expected,MapDirection.WEST.previous());
    }

}
