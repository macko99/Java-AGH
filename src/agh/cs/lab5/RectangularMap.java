package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {

    private final Vector2d lowerLeft;
    private final Vector2d upperRight;

    private List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height) {

        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width - 1, height - 1);
    }

    public boolean canMoveTo(Vector2d position) {
        boolean canMove = super.canMoveTo(position);
        return (canMove && position.precedes(upperRight) && position.follows(lowerLeft));
    }

    @Override
    public String toString () {
        return new MapVisualizer(this).draw(this.lowerLeft, this.upperRight);
    }

}
