package agh.cs.lab777.test;

import agh.cs.lab2.Animal;
import agh.cs.lab2.Vector2d;
import org.junit.Before;
import org.junit.Test;

import static agh.cs.lab2.MapDirection.*;
import static agh.cs.lab2.MoveDirection.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AnimalTest {

    private Animal animal1;
    private Animal animal2;
    private Vector2d initialVector;;

    @Before
    public void setUp() {
        animal1 = new Animal();
        animal2 = new Animal();
        initialVector = new Vector2d(2,2);
    }

    @Test
    public void orientationTest(){
        assertEquals(NORTH, animal1.getDirection());
        assertNotEquals(EAST, animal2.getDirection());
    }

    @Test
    public void move(){
        assertEquals(initialVector, animal1.getPosition());

        animal1.move(FORWARD);
        assertEquals(new Vector2d(2,3), animal1.getPosition());

        animal1.move(BACKWARD);
        assertEquals(new Vector2d(2,2), animal1.getPosition());

        animal1.move(LEFT);
        assertEquals(WEST, animal1.getDirection());

        animal1.move(RIGHT);
        assertEquals(NORTH, animal1.getDirection());

        animal1.move(LEFT);animal1.move(FORWARD);animal1.move(FORWARD);animal1.move(LEFT);animal1.move(FORWARD);
        assertEquals(SOUTH, animal1.getDirection());
        assertEquals(new Vector2d(0,1), animal1.getPosition());
    }

    @Test
    public void moveToBounds(){
        assertEquals(initialVector, animal1.getPosition());

        animal1.move(FORWARD);animal1.move(FORWARD);animal1.move(FORWARD);animal1.move(FORWARD);animal1.move(FORWARD);
        assertEquals(new Vector2d(2,4), animal1.getPosition());

        animal2.move(RIGHT); animal2.move(FORWARD);animal2.move(FORWARD);animal2.move(FORWARD);animal2.move(FORWARD);animal2.move(FORWARD);
        assertEquals(new Vector2d(4,2), animal2.getPosition());
    }

}
