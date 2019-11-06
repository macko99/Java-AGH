package agh.cs.lab7;

public class World {

    public static void main(String[] args) {
        try {
            MoveDirection[] directions = new OptionsParser().parse(args);

           /* IWorldMap map = new RectangularMap(10, 5);
            map.place(new Animal(map));
            map.place(new Animal(map, new Vector2d(3,4)));
            System.out.println(map.toString());
            map.run(directions);
            System.out.println(map.toString());*/

            IWorldMap map2 = new GrassField(10);

            map2.place(new Animal(map2));
            map2.place(new Animal(map2, new Vector2d(3, 4)));
            //map2.place(new Animal(map2, new Vector2d(3, 4)));
            System.out.println(map2.toString());
            map2.run(directions);
            System.out.println(map2.toString());
        }
        catch(IllegalArgumentException ex){
            System.out.println(ex);
        }
    }
}
