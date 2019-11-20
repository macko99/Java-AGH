package agh.cs.lab8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    private Map<Vector2d, Animal> animalsMap = new HashMap<>();
    private List<Animal> animals = new ArrayList<>();
    MapBoundary boundaries = new MapBoundary();

    abstract Vector2d getLowerLeft();
    abstract Vector2d getUpperRight();

    @Override
    public boolean place(Animal animal) {

        if (!canMoveTo(animal.getPosition())) {
            throw new IllegalArgumentException(animal.getPosition().toString() + " is already occupied");
        }
        animals.add(animal);
        animalsMap.put(animal.getPosition(), animal);
        boundaries.addElement(animal.getPosition());
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
        return objectAt(position) != null;
    }

    @Override
    public boolean canMoveTo (Vector2d position){
        return animalsMap.get(position) == null;
    }

    @Override
    public Object objectAt(Vector2d position) {
            return animalsMap.get(position);
    }
    @Override
    public String toString () {
        return new MapVisualizer(this).draw(getLowerLeft(), getUpperRight());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animalsMap.get(oldPosition);
        animalsMap.remove(oldPosition);
        animalsMap.put(newPosition, animal);
        boundaries.positionChanged(oldPosition,newPosition);
    }
}
