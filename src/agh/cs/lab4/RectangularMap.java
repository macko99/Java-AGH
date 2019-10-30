package agh.cs.lab4;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {

    private final Vector2d lowerLeft;
    private final Vector2d upperRight;

    private List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height) {

        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width - 1, height - 1);
    }

    @Override
    public String toString () {
        return new MapVisualizer(this).draw(this.lowerLeft, this.upperRight);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!isOccupied(position) && position.precedes(upperRight) && position.follows(lowerLeft));
    }

    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition()))
            return false;
        animals.add(animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        if (animals.size() > 0) {
            for (int i = 0, j = 0; i < directions.length; i++, j++) {
                j = j % animals.size();
                animals.get(j).move(directions[i]);
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position))
                return animal;
        }
            return null;
    }

}
