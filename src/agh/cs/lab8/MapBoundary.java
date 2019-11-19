package agh.cs.lab8;

import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {

    private SortedSet<Vector2d> animalsX = new TreeSet<>((v1, v2) -> {
        if (v1.x < v2.x)
            return -1;
        else if (v1.x > v2.x)
            return 1;
        else return Integer.compare(v1.y, v2.y);
    });

    private SortedSet<Vector2d> animalsY = new TreeSet<>((v1, v2) -> {
        if (v1.y < v2.y)
            return -1;
        else if (v1.y > v2.y)
            return 1;
        else return Integer.compare(v1.x, v2.x);
    });

    void addElement(Vector2d vector){
        animalsX.add(vector);
        animalsY.add(vector);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        animalsX.remove(oldPosition);
        animalsY.remove(oldPosition);
        addElement(newPosition);
    }
    public Vector2d getUpperRight (){
        return new Vector2d(animalsX.last().x,animalsY.last().y);
    }
    public Vector2d getLowerLeft (){
        return new Vector2d(animalsX.first().x,animalsY.first().y);
    }
}
