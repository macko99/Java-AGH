package agh.cs.lab8;

import java.util.ArrayList;
import java.util.List;

public class GrassField extends AbstractWorldMap {

    private List<Grass> grasses = new ArrayList<>();
    private Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
    private Vector2d upperRight = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);

    GrassField(int grassFieldsTarget){
        for (int i=0; i < grassFieldsTarget;){
            double randomX = Math.random()*Math.sqrt(grassFieldsTarget*10);
            int randomXInt = (int) randomX;
            double randomY = Math.random()*(Math.sqrt(grassFieldsTarget*10));
            int randomYInt = (int) randomY;

            Vector2d vectorInt = new Vector2d(randomXInt, randomYInt);

            if (!isOccupied(vectorInt)) {
                grasses.add(new Grass(vectorInt));
                i++;
            }
        }
    }

    public GrassField (List<Grass> grasses){
        this.grasses = new ArrayList<>(grasses);
    }

    @Override
    public Object objectAt (Vector2d position) {
        Object object = super.objectAt(position);
        if(object != null)
            return object;
        for (Grass grass : grasses) {
            if (grass.getPosition().equals(position))
                return grass;
            }
            return null;
        }

    private void updateBounds() {
        for (Grass grass : grasses) {
            if (!grass.getPosition().isInBounds(lowerLeft, upperRight))
                upperRight = upperRight.upperRight(grass.getPosition());
                lowerLeft = lowerLeft.lowerLeft(grass.getPosition());
        }
        for(Animal animal : animals){
            if (!animal.getPosition().isInBounds(lowerLeft, upperRight))
                upperRight = upperRight.upperRight(animal.getPosition());
                lowerLeft = lowerLeft.lowerLeft(animal.getPosition());
        }
    }

    public Vector2d getLowerLeft(){
        updateBounds();
        return lowerLeft;
    }

    public Vector2d getUpperRight() {
        return upperRight;
    }
}
