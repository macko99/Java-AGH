package agh.cs.lab8.test;

import agh.cs.lab8.*;
import org.junit.Before;
import org.junit.Test;

import static agh.cs.lab8.MoveDirection.BACKWARD;
import static agh.cs.lab8.MoveDirection.FORWARD;
import static org.junit.Assert.*;

public class MapTest {

    private IWorldMap map1;
    private IWorldMap map2;
    private IWorldMap map3;
    private IWorldMap map4;
    private IWorldMap map5;
    private IWorldMap map6;


    @Before
    public void setUp() {
        map1 = new RectangularMap(5, 10);
        map2 = new RectangularMap(5,10);
        map3 = new RectangularMap(5, 10);
        map4 = new RectangularMap(5,10);
        map5 = new RectangularMap(5, 10);
        map6 = new RectangularMap(5,10);
        for(int i=0; i<5; i++) {
            map3.place(new Animal(map3, new Vector2d(i,i+1)));
            map4.place(new Animal(map4, new Vector2d(i,2*i)));
            map6.place(new Animal(map6, new Vector2d(i,i+1)));
        }
    }

    @Test
    public void placeTest() {
        for(int i=0; i<5; i++) {
            assertTrue(map1.place(new Animal(map1, new Vector2d(i,i+1))));
            assertTrue(map2.place(new Animal(map2, new Vector2d(i,2*i))));
            assertFalse(map4.place(new Animal(map3, new Vector2d(i+5,i))));
            assertFalse(map5.place(new Animal(map4, new Vector2d(i,i+10))));
            assertFalse(map6.place(new Animal(map5, new Vector2d(i-10,i))));
        }
    }

    @Test
    public void canMoveToTest() {
        assertTrue(map1.canMoveTo(new Vector2d(0,2)));
        assertFalse(map2.canMoveTo(new Vector2d(-4,4)));
        assertTrue(map3.canMoveTo(new Vector2d(3,3)));
        assertFalse(map4.canMoveTo(new Vector2d(3,6)));
    }

    @Test
    public void runTest() {
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2d(3,4)));
        map.run(new OptionsParser().parse(new String[]{"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"}));
        Animal end1 = new Animal(map, new Vector2d(3,4), MapDirection.NORTH);
        Animal end2 = new Animal(map, new Vector2d(2,0), MapDirection.SOUTH);
        assertEquals(map.objectAt(new Vector2d(2, 0)), end2);
        assertEquals(map.objectAt(new Vector2d(3, 4)), end1);

        map1.run(new MoveDirection[]{FORWARD, FORWARD, FORWARD, FORWARD});
        assertEquals(map1.toString(),map2.toString());
        map6.run(new MoveDirection[]{FORWARD, FORWARD, FORWARD, FORWARD, FORWARD,
                BACKWARD, BACKWARD, BACKWARD, BACKWARD, BACKWARD});
        assertEquals(map3.toString(),map6.toString());
    }

    @Test
    public void isOccupiedTest() {
        assertFalse(map1.isOccupied(new Vector2d(0,2)));
        assertFalse(map2.isOccupied(new Vector2d(-4,4)));
        assertTrue(map3.isOccupied(new Vector2d(3,4)));
        assertTrue(map4.isOccupied(new Vector2d(3,6)));
    }

    @Test
    public void objectAtTest() {
        Animal animal1 = new Animal(map1);
        map1.place(animal1);
        assertEquals(map1.objectAt(new Vector2d(2,2)), animal1);
        Animal animal2 = new Animal(map2);
        map2.place(animal2);
        assertNotEquals(map2.objectAt(new Vector2d(0,0)), animal2);
        assertNull(map5.objectAt(new Vector2d(3,3)));
    }

    @Test
    public void ToStringTest() {
        assertEquals(map1.toString(), map2.toString());
        assertNotEquals(map1.toString(), map3.toString());
        assertNotEquals(map4.toString(), map5.toString());
    }


}
