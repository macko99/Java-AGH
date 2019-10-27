package agh.cs.lab4;

public class Animal {

    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);
    private IWorldMap map;


    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal (IWorldMap map, Vector2d position) {
        this.map = map;
        this.position = position;
    }

    @Override
    public String toString() {
        return direction.toString();
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
                    position = newPosition;
                }
                break;
            case BACKWARD:
                newPosition = position.subtract(this.direction.toUnitVector());
                if(map.canMoveTo(newPosition)) {
                    position = newPosition;
                }
                break;
        }
    }

}