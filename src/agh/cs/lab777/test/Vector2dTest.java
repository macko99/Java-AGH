package agh.cs.lab777.test;

import agh.cs.lab2.Vector2d;
import org.junit.Test;

import static org.junit.Assert.*;

public class Vector2dTest {
    @Test
    public void precedesTest(){
        assertTrue(new Vector2d(1, 1).precedes(new Vector2d(10, 10)));
        assertTrue(new Vector2d(3, 5).precedes(new Vector2d(5, 5)));
        assertFalse(new Vector2d(20, -3).precedes(new Vector2d(0, 0)));
    }
    @Test
    public void followsTest(){
        assertTrue(new Vector2d(10, 10).follows(new Vector2d(1, 1)));
        assertTrue(new Vector2d(3, 4).follows(new Vector2d(-1, -1)));
        assertFalse(new Vector2d(-2, -3).follows(new Vector2d(0, 0)));
    }
    @Test
    public void upperRightTest(){
        assertEquals(new Vector2d(5,1).upperRight(new Vector2d(1,5)),new Vector2d(5,5));
    }
    @Test
    public void lowerLeftTest(){
        assertEquals(new Vector2d(5,1).lowerLeft(new Vector2d(1,5)),new Vector2d(1,1));
    }
    @Test
    public void addTest(){
        assertEquals(new Vector2d(5,5).add(new Vector2d(1,1)),new Vector2d(6,6));
    }
    @Test
    public void oppositeTest(){
        assertEquals(new Vector2d(1,1).opposite(),new Vector2d(-1,-1));
    }
    @Test
    public void subtractTest(){
        assertEquals(new Vector2d(-1,-1).subtract(new Vector2d(1,1)),new Vector2d(-2,-2));
    }
    @Test
    public void equalsTest(){
        assertEquals(new Vector2d(1,1),new Vector2d(1,1));
    }
    @Test
    public void toStringTest(){
        assertEquals(new Vector2d(1,1).toString(),"(1,1)");
    }

}
