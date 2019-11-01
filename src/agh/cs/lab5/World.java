package agh.cs.lab5;

import java.util.Arrays;

public class World {

    public static void main(String[] args) {

        MoveDirection[] directions = new OptionsParser().parse(args);

        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2d(3,4)));
        System.out.println(map.toString());
        map.run(directions);
        System.out.println(map.toString());

        IWorldMap map2 = new UnboundedMap(Arrays.asList(new Stone(new Vector2d(-4,-4)),
                new Stone(new Vector2d(7,7)),
                new Stone(new Vector2d(3,6)),
                new Stone(new Vector2d(-2,0))));

        map2.place(new Animal(map2));
        map2.place(new Animal(map2, new Vector2d(3,4)));
        System.out.println(map2.toString());
        map2.run(directions);
        System.out.println(map2.toString());

    }
}
