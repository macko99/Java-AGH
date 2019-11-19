package agh.cs.lab8;

import java.util.ArrayList;
import java.util.List;

public class Animal {

    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);
    private IWorldMap map;

    private List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(IWorldMap map) {
        this.map = map;
        addObserver((IPositionChangeObserver) map);
        addObserver(map.getBoundaries());
    }

    public Animal (IWorldMap map, Vector2d position) {
        this.map = map;
        this.position = position;
        addObserver((IPositionChangeObserver) map);
        addObserver(map.getBoundaries());
    }
    public Animal (IWorldMap map, Vector2d position, MapDirection direction) {
        this.map = map;
        this.position = position;
        this.direction = direction;
        addObserver((IPositionChangeObserver) map);
        addObserver(map.getBoundaries());
    }

    private void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    void removeObserver (IPositionChangeObserver observer){
        observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    @Override
    public String toString() {
        return direction.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if(!(other instanceof Animal))
            return false;
        Animal animal = (Animal) other;
        return this.position.equals(animal.position) && this.direction.equals(animal.direction) && this.map.equals(animal.map);
    }

    public MapDirection getDirection (){
        return this.direction;
    }

    public Vector2d getPosition (){
        return this.position;
    }

    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT: this.direction = this.direction.next();
                break;
            case LEFT: this.direction = this.direction.previous();
                break;
            case FORWARD:
                Vector2d newPosition = position.add(this.direction.toUnitVector());
                if(map.canMoveTo(newPosition)) {
                    positionChanged(position, newPosition);
                    position = newPosition;
                }
                break;
            case BACKWARD:
                Vector2d newPosition2 = position.subtract(this.direction.toUnitVector());
                if(map.canMoveTo(newPosition2)) {
                    positionChanged(position, newPosition2);
                    position = newPosition2;
                }
                break;
        }
    }

}