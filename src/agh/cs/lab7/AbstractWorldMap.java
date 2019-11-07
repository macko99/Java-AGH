package agh.cs.lab7;

import java.util.*;

abstract class AbstractWorldMap implements IWorldMap {

    private Map<Integer, Animal> animalsMap = new HashMap<>();
    List<Animal> animals = new ArrayList<>();

    abstract Vector2d getLowerLeft();
    abstract Vector2d getUpperRight();

    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition())) {
            throw new IllegalArgumentException(animal.getPosition().toString() + " is already occupied");
        }
        animals.add(animal);
        animalsMap.put(animal.getPosition().hashCode(), animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        if (animals.size() > 0) {
            for (int i = 0, j = 0; i < directions.length; i++, j++) {
                j = j % animals.size();
                Animal animalCurr = animals.get(j);
                int oldHash = animalCurr.getPosition().hashCode();

                animalCurr.move(directions[i]);
                if(oldHash != animalCurr.getPosition().hashCode()){
                    animalsMap.remove(oldHash);
                    animalsMap.put(animalCurr.getPosition().hashCode(), animalCurr);
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
        return animalsMap.get(position.hashCode()) == null;
    }

    @Override
    public Object objectAt(Vector2d position) {
            return animalsMap.get(position.hashCode());
    }
    @Override
    public String toString () {
        return new MapVisualizer(this).draw(getLowerLeft(), getUpperRight());
    }
}
