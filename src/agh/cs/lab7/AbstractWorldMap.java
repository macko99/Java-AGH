package agh.cs.lab7;

import java.util.*;

abstract class AbstractWorldMap implements IWorldMap {

    protected Map<Integer, Animal> animalsMap = new HashMap<>();
    protected List<Animal> animals = new ArrayList<>();

    abstract Vector2d getLowerLeft();
    abstract Vector2d getUpperRight();

    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition()))
            return false;
        animals.add(animal);
        animalsMap.put(animal.getPosition().hashCode(), animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        if (animals.size() > 0) {
            for (int i = 0, j = 0; i < directions.length; i++, j++) {
                j = j % animals.size();
                int oldHash = animals.get(j).hashCode();
                Animal animalCurr = animals.get(j);

                animalCurr.move(directions[i]);
                if(oldHash != animalCurr.hashCode()){
                    animalsMap.remove(oldHash);
                    animalsMap.put(animalCurr.hashCode(), animalCurr);
                }
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(objectAt(position) != null) {
            return true;
        }
        return false;
    }


    @Override
    public Object objectAt(Vector2d position) {
            return animals.get(position.hashCode());
    }
    @Override
    public String toString () {
        return new MapVisualizer(this).draw(getLowerLeft(), getUpperRight());
    }
}
