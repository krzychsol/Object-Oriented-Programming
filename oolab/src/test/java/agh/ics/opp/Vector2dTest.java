package agh.ics.opp;
import agh.ics.oop.MapDirection;
import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    @Test
    public void equalsSameVectorsTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);
        assertEquals(v1,v2);
    }

    @Test
    public void equalsDiffVectorsTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(-1,2);
        assertNotEquals(v1, v2);
    }

    @Test
    public void equalsVectorAndMapTest(){
        Vector2d v1 = new Vector2d(1,2);
        MapDirection m1 = MapDirection.EAST;
        assertNotEquals(v1, m1);
    }

    @Test
    public void toStringSameTest(){
        Vector2d v = new Vector2d(-1,3);
        String expected = "(-1,3)";
        assertEquals(expected,v.toString());
    }

    @Test
    public void toStringDiffTest(){
        Vector2d v = new Vector2d(-5,3);
        String expected = "(-2,3)";
        assertNotEquals(expected,v.toString());
    }

    @Test
    public void precedesTrueTest(){
        Vector2d v1 = new Vector2d(-5,2);
        Vector2d v2 = new Vector2d(5,2);
        assertTrue(v1.precedes(v2));
    }

    @Test
    public void precedesFalseTest(){
        Vector2d v1 = new Vector2d(-5,3);
        Vector2d v2 = new Vector2d(5,2);
        assertFalse(v1.precedes(v2));
    }

    @Test
    public void precedesSameVectorsTest(){
        Vector2d v1 = new Vector2d(5,2);
        Vector2d v2 = new Vector2d(5,2);
        assertTrue(v1.precedes(v2));
    }

    @Test
    public void followsTrueTest(){
        Vector2d v1 = new Vector2d(10,2);
        Vector2d v2 = new Vector2d(5,2);
        assertTrue(v1.follows(v2));
    }

    @Test
    public void followsSameVectorsTest(){
        Vector2d v1 = new Vector2d(5,2);
        Vector2d v2 = new Vector2d(5,2);
        assertTrue(v1.follows(v2));
    }

    @Test
    public void followsFalseTest(){
        Vector2d v1 = new Vector2d(2,1);
        Vector2d v2 = new Vector2d(5,2);
        assertFalse(v1.follows(v2));
    }

    @Test
    public void upperRightDiffVectorsTest(){
        Vector2d v1 = new Vector2d(-1,3);
        Vector2d v2 = new Vector2d(5,2);
        Vector2d expected = new Vector2d(5,3);
        assertEquals(expected,v1.upperRight(v2));
    }

    @Test
    public void upperRightSameVectorsTest(){
        Vector2d v1 = new Vector2d(5,2);
        Vector2d v2 = new Vector2d(5,2);
        Vector2d expected = new Vector2d(5,2);
        assertEquals(expected,v1.upperRight(v2));
    }

    @Test
    public void lowerLeftSameVectorsTest(){
        Vector2d v1 = new Vector2d(-1,2);
        Vector2d v2 = new Vector2d(5,1);
        Vector2d expected = new Vector2d(-1,1);
        assertEquals(expected,v1.lowerLeft(v2));
    }

    @Test
    public void lowerLeftDiffVectorsTest(){
        Vector2d v1 = new Vector2d(5,2);
        Vector2d v2 = new Vector2d(5,2);
        Vector2d expected = new Vector2d(5,2);
        assertEquals(expected,v1.lowerLeft(v2));
    }

    @Test
    public void addToZeroTest(){
        Vector2d v1 = new Vector2d(0,0);
        Vector2d v2 = new Vector2d(5,2);
        Vector2d expected = new Vector2d(5,2);
        assertEquals(expected,v1.add(v2));
    }

    @Test
    public void addToNonZeroTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(5,3);
        Vector2d expected = new Vector2d(6,5);
        assertEquals(expected,v1.add(v2));
    }

    @Test
    public void subtractFromZeroTest(){
        Vector2d v1 = new Vector2d(0,0);
        Vector2d v2 = new Vector2d(5,2);
        Vector2d expected = new Vector2d(-5,-2);
        assertEquals(expected,v1.subtract(v2));
    }

    @Test
    public void subtractFromNonZeroTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(5,3);
        Vector2d expected = new Vector2d(-4,-1);
        assertEquals(expected,v1.subtract(v2));
    }

    @Test
    public void oppositeOfZeroTest(){
        Vector2d v = new Vector2d(0,0);
        Vector2d expected = new Vector2d(0,0);
        assertEquals(expected,v.opposite());
    }

    @Test
    public void oppositeNonZeroTest(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d expected = new Vector2d(-1,-2);
        assertEquals(expected,v1.opposite());
    }
}
