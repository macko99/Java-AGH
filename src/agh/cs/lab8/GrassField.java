package agh.cs.lab8;

import java.util.ArrayList;
import java.util.List;

public class GrassField extends AbstractWorldMap {

    private List<Grass> grasses = new ArrayList<>();

    GrassField(int grassFieldsTarget){
        for (int i=0; i < grassFieldsTarget;){
            double randomX = Math.random()*Math.sqrt(grassFieldsTarget*10);
            int randomXInt = (int) randomX;
            double randomY = Math.random()*(Math.sqrt(grassFieldsTarget*10));
            int randomYInt = (int) randomY;

            Vector2d vectorInt = new Vector2d(randomXInt, randomYInt);

            if (!isOccupied(vectorInt)) {
                grasses.add(new Grass(vectorInt));
                boundaries.addElement(vectorInt);
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

    public Vector2d getLowerLeft(){
        return boundaries.getLowerLeft();
    }

    public Vector2d getUpperRight() {
        return boundaries.getUpperRight();
    }

}
