package agh.cs.lab7.test;

import agh.cs.lab7.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GrassFieldTest {

    private IWorldMap map;

    @Before
    public void setUp() {
        map = new GrassField(Arrays.asList(new Grass(new Vector2d(0,0)),
                                            new Grass(new Vector2d(3,3))));
        map.place(new Animal(map, new Vector2d(1,1)));
    }

    @Test
    public void placeTest() {
        assertFalse(map.place(new Animal(map, new Vector2d(1,1))));
        assertTrue(map.place(new Animal(map, new Vector2d(-4,-4))));
        assertTrue(map.place(new Animal(map, new Vector2d(-1,-1))));
    }

    @Test
    public void canMoveToTest() {
        assertTrue(map.canMoveTo(new Vector2d(0,0)));
        assertFalse(map.canMoveTo(new Vector2d(1,1)));
        assertTrue(map.canMoveTo(new Vector2d(5,5)));
    }

    @Test
    public void runTest() {
        map.run(new OptionsParser().parse(new String[]{"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"}));
        Animal end1 = new Animal(map, new Vector2d(1,-5), MapDirection.SOUTH);
        assertEquals(map.objectAt(new Vector2d(1, -5)), end1);
    }

    @Test
    public void isOccupiedTest() {
        assertTrue(map.isOccupied(new Vector2d(3,3)));
        assertTrue(map.isOccupied(new Vector2d(1,1)));
        assertFalse(map.isOccupied(new Vector2d(-10,-10)));
    }

    @Test
    public void objectAtTest() {
        Animal animal1 = new Animal(map, new Vector2d(1,1), MapDirection.NORTH);
        System.out.println(map.toString());
        assertEquals(map.objectAt(new Vector2d(1,1)), animal1);
        assertEquals(map.objectAt(new Vector2d(3,3)), new Grass(new Vector2d(3, 3)));
        assertNotEquals(map.objectAt(new Vector2d(0,0)), animal1);
        assertNull(map.objectAt(new Vector2d(-6,-6)));
    }

}
