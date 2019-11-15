package agh.cs.lab8.test;

import agh.cs.lab8.MoveDirection;
import agh.cs.lab8.OptionsParser;
import org.junit.Test;

import static agh.cs.lab8.MoveDirection.*;
import static org.junit.Assert.assertArrayEquals;


public class ParserTest {

    @Test
    public void parse() {
        assertArrayEquals(new MoveDirection[]{FORWARD, FORWARD, BACKWARD, BACKWARD},
                OptionsParser.parse(new String[]{"f", "forward", "b", "backward"}));
        assertArrayEquals(new MoveDirection[]{LEFT, RIGHT, LEFT, RIGHT},
                OptionsParser.parse(new String[]{"l", "r", "left", "right"}));

    }
}
