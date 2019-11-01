package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap {

    private List<Stone> stones;
    private List<Animal> animals = new ArrayList<>();
    private Vector2d lowerLeft = new Vector2d(0,0);
    private Vector2d upperRight = new Vector2d(0,0);

    public UnboundedMap (List<Stone> stones){
        this.stones = stones;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(super.isOccupied(position))
            return true;
        for (Stone stone : stones) {
            if (stone.getPosition().equals(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if(object != null)
            return object;
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
        for(Animal animal : animals){
            if (animal.getPosition().follows(upperRight))
                upperRight = animal.getPosition();
            if (animal.getPosition().precedes(lowerLeft))
                lowerLeft = animal.getPosition();
        }
        return new MapVisualizer(this).draw(this.lowerLeft, this.upperRight);
    }
}
