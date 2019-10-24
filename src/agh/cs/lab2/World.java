package agh.cs.lab2;

public class World {

    public static void main(String[] args) {
        Vector2d position1 = new Vector2d(1, 2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2, 1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        MapDirection direction = MapDirection.NORTH;
        System.out.println(direction.toString());
        direction = direction.next();
        System.out.println(direction.toString());

        Animal animal1 = new Animal();
        System.out.println(animal1.toString());
        String[] moves = new String[]{"r", "forward", "forward", "f"};
        MoveDirection[] directions = OptionsParser.parse(moves);
        for(MoveDirection arg : directions){
           animal1.move(arg);
        }
        System.out.println(animal1.toString());
    }
}
