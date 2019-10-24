package agh.cs.lab1;

import java.util.*;

public class World {

    public static void run (Direction[] values) {

        for (Direction arg : values) {

            if (arg == null) {
                System.out.println("Invalid arg!");
                continue;
            }

            switch (arg) {
                case FORWARD:
                    System.out.println("Moving forward...");
                    break;
                case BACKWARD:
                    System.out.println("Moving backward...");
                    break;
                case LEFT:
                    System.out.println("Moving left...");
                    break;
                case RIGHT:
                    System.out.println("Moving right...");
                    break;
            }
        }
    }

    public static Direction conversion(String value){

        switch (value) {
            case "f":
                return Direction.FORWARD;
            case "b":
                return Direction.BACKWARD;
            case "l":
                return Direction.LEFT;
            case "r":
                return Direction.RIGHT;
            }
        return null;
    }

    public static void main(String[] args) {

        System.out.println("System started");

        Direction[] directions = new Direction[args.length];

        for(int i=0; i<args.length; i++) {
            directions[i] = conversion(args[i]);
        }

        run(directions);
        System.out.println("System ended");

        if( new Integer(10) == new Integer(10))
            System.out.println("tak");
    }

}
