package agh.cs.lab5.test.test;

import agh.cs.lab5.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class UnboundTest {

    private IWorldMap map;
    private IWorldMap map2;

    @Before
    public void setUp() {
        map2 = new UnboundedMap(Arrays.asList(new Stone(new Vector2d(-4,-4)),
                new Stone(new Vector2d(7,7)),
                new Stone(new Vector2d(3,6)),
                new Stone(new Vector2d(-2,0))));
        map = new UnboundedMap(Arrays.asList(new Stone(new Vector2d(-4,-4)),
                new Stone(new Vector2d(7,7)),
                new Stone(new Vector2d(3,6)),
                new Stone(new Vector2d(-2,0))));
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2d(3,4)));
        map2.place(new Animal(map2));
        map2.place(new Animal(map2, new Vector2d(3,4)));
    }

    @Test
    public void placeTest() {
        assertTrue(map.place(new Animal(map, new Vector2d(0,0))));
        assertFalse(map.place(new Animal(map, new Vector2d(-4,-4))));
        assertFalse(map.place(new Animal(map, new Vector2d(3,4))));
        assertTrue(map.place(new Animal(map, new Vector2d(-10,-10))));
    }

    @Test
    public void canMoveToTest() {
        assertTrue(map.canMoveTo(new Vector2d(0,0)));
        assertFalse(map.canMoveTo(new Vector2d(-4,-4)));
        assertFalse(map.canMoveTo(new Vector2d(3,4)));
        assertTrue(map.canMoveTo(new Vector2d(-10,-10)));
    }

    @Test
    public void runTest() {
        map2.run(new OptionsParser().parse(new String[]{"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"}));
        Animal end1 = new Animal(map2, new Vector2d(3,5), MapDirection.NORTH);
        Animal end2 = new Animal(map2, new Vector2d(2,-1), MapDirection.SOUTH);
        assertEquals(map2.objectAt(new Vector2d(3, 5)), end1);
        assertEquals(map2.objectAt(new Vector2d(2, -1)), end2);
    }

    @Test
    public void isOccupiedTest() {
        assertFalse(map.isOccupied(new Vector2d(0,0)));
        assertTrue(map.isOccupied(new Vector2d(-4,-4)));
        assertTrue(map.isOccupied(new Vector2d(3,4)));
        assertFalse(map.isOccupied(new Vector2d(-10,-10)));
    }

    @Test
    public void objectAtTest() {
        Animal animal1 = new Animal(map);
        assertEquals(map.objectAt(new Vector2d(2,2)), animal1);
        assertEquals(map.objectAt(new Vector2d(-4,-4)), new Stone(new Vector2d(-4, -4)));
        assertNotEquals(map.objectAt(new Vector2d(0,0)), animal1);
        assertNull(map.objectAt(new Vector2d(3,3)));
    }

}
