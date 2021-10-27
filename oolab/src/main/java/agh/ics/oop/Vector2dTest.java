package agh.ics.oop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    @Test
    public void equalsTest1(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);
        assertEquals(v1,v2);
    }

    @Test
    public void equalsTest2(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(-1,2);
        assertNotEquals(v1, v2);
    }

    @Test
    public void equalsTest3(){
        Vector2d v1 = new Vector2d(1,2);
        MapDirection m1 = MapDirection.EAST;
        assertNotEquals(v1, m1);
    }

    @Test
    public void toStringTest1(){
        Vector2d v = new Vector2d(-1,3);
        String expected = "(-1,3)";
        assertEquals(expected,v.toString());
    }

    @Test
    public void toStringTest2(){
        Vector2d v = new Vector2d(-5,3);
        String expected = "(-2,3)";
        assertNotEquals(expected,v.toString());
    }

    @Test
    public void precedesTest1(){
        Vector2d v1 = new Vector2d(-5,2);
        Vector2d v2 = new Vector2d(5,2);
        assertTrue(v1.precedes(v2));
    }

    @Test
    public void precedesTest2(){
        Vector2d v1 = new Vector2d(-5,3);
        Vector2d v2 = new Vector2d(5,2);
        assertFalse(v1.precedes(v2));
    }

    @Test
    public void precedesTest3(){
        Vector2d v1 = new Vector2d(5,2);
        Vector2d v2 = new Vector2d(5,2);
        assertTrue(v1.precedes(v2));
    }

    @Test
    public void precedesTest4(){
        Vector2d v1 = new Vector2d(10,1);
        Vector2d v2 = new Vector2d(5,2);
        assertFalse(v1.precedes(v2));
    }

    @Test
    public void followsTest1(){
        Vector2d v1 = new Vector2d(10,2);
        Vector2d v2 = new Vector2d(5,2);
        assertTrue(v1.follows(v2));
    }

    @Test
    public void followsTest2(){
        Vector2d v1 = new Vector2d(5,2);
        Vector2d v2 = new Vector2d(5,2);
        assertTrue(v1.follows(v2));
    }

    @Test
    public void followsTest3(){
        Vector2d v1 = new Vector2d(2,1);
        Vector2d v2 = new Vector2d(5,2);
        assertFalse(v1.follows(v2));
    }

    @Test
    public void followsTest4(){
        Vector2d v1 = new Vector2d(-1,2);
        Vector2d v2 = new Vector2d(5,2);
        assertFalse(v1.follows(v2));
    }

    @Test
    public void upperRightTest1(){
        Vector2d v1 = new Vector2d(-1,3);
        Vector2d v2 = new Vector2d(5,2);
        Vector2d expected = new Vector2d(5,3);
        assertEquals(expected,v1.upperRight(v2));
    }

    @Test
    public void upperRightTest2(){
        Vector2d v1 = new Vector2d(5,2);
        Vector2d v2 = new Vector2d(5,2);
        Vector2d expected = new Vector2d(5,2);
        assertEquals(expected,v1.upperRight(v2));
    }

    @Test
    public void lowerLeftTest1(){
        Vector2d v1 = new Vector2d(-1,2);
        Vector2d v2 = new Vector2d(5,1);
        Vector2d expected = new Vector2d(-1,1);
        assertEquals(expected,v1.lowerLeft(v2));
    }

    @Test
    public void lowerLeftTest2(){
        Vector2d v1 = new Vector2d(5,2);
        Vector2d v2 = new Vector2d(5,2);
        Vector2d expected = new Vector2d(5,2);
        assertEquals(expected,v1.lowerLeft(v2));
    }

    @Test
    public void addTest1(){
        Vector2d v1 = new Vector2d(0,0);
        Vector2d v2 = new Vector2d(5,2);
        Vector2d expected = new Vector2d(5,2);
        assertEquals(expected,v1.add(v2));
    }

    @Test
    public void addTest2(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(5,3);
        Vector2d expected = new Vector2d(6,5);
        assertEquals(expected,v1.add(v2));
    }

    @Test
    public void subtractTest1(){
        Vector2d v1 = new Vector2d(0,0);
        Vector2d v2 = new Vector2d(5,2);
        Vector2d expected = new Vector2d(-5,-2);
        assertEquals(expected,v1.subtract(v2));
    }

    @Test
    public void subtractTest2(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(5,3);
        Vector2d expected = new Vector2d(-4,-1);
        assertEquals(expected,v1.subtract(v2));
    }

    @Test
    public void oppositeTest1(){
        Vector2d v = new Vector2d(0,0);
        Vector2d expected = new Vector2d(0,0);
        assertEquals(expected,v.opposite());
    }

    @Test
    public void oppositeTest2(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d expected = new Vector2d(-1,-2);
        assertEquals(expected,v1.opposite());
    }
}
