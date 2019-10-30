package agh.cs.lab4;

import java.util.ArrayList;
import java.util.List;

public class UnboundedMap implements IWorldMap{

    private List<Stone> stones;
    private List<Animal> animals = new ArrayList<>();
    private Vector2d lowerLeft = new Vector2d(0,0);
    private Vector2d upperRight = new Vector2d(0,0);

    public UnboundedMap (List<Stone> stones){
        this.stones = stones;
    }

    private void updateBoundsAnimal (Animal animal) {
        if (animal.getPosition().follows(upperRight))
            upperRight = animal.getPosition();
        if (animal.getPosition().precedes(lowerLeft))
            lowerLeft = animal.getPosition();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (this.isOccupied(animal.getPosition()))
            return false;
        animals.add(animal);
        updateBoundsAnimal(animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        if (animals.size() > 0) {
            for (int i = 0, j = 0; i < directions.length; i++, j++) {
                j = j % animals.size();
                animals.get(j).move(directions[i]);
                updateBoundsAnimal(animals.get(j));
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position))
                return true;
        }
        for (Stone stone : stones) {
            if (stone.getPosition().equals(position))
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
        for (Stone stone : stones) {
            if (stone.getPosition().equals(position))
                return stone;
        }
        return null;
    }

    @Override
    public String toString () {
        for (Stone stone : stones) {
            if (stone.getPosition().follows(upperRight))
                upperRight = stone.getPosition();
            if (stone.getPosition().precedes(lowerLeft))
                lowerLeft = stone.getPosition();
        }
        return new MapVisualizer(this).draw(this.lowerLeft, this.upperRight);
    }
}
