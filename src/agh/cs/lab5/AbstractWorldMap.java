package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap{

    protected List<Animal> animals = new ArrayList<>();

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
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
