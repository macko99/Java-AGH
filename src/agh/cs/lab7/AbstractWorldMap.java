package agh.cs.lab7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap {

    private Map<Vector2d, Animal> animalsMap = new HashMap<>();
    List<Animal> animals = new ArrayList<>();

    abstract Vector2d getLowerLeft();
    abstract Vector2d getUpperRight();

    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition())) {
            throw new IllegalArgumentException(animal.getPosition().toString() + " is already occupied");
        }
        animals.add(animal);
        animalsMap.put(animal.getPosition(), animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        if (animals.size() > 0) {
            for (int i = 0, j = 0; i < directions.length; i++, j++) {
                j = j % animals.size();
                Animal animalCurr = animals.get(j);
                Vector2d oldVector = animalCurr.getPosition();

                animalCurr.move(directions[i]);
                if(oldVector != animalCurr.getPosition()){
                    animalsMap.remove(oldVector);
                    animalsMap.put(animalCurr.getPosition(), animalCurr);
                }
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
}
