package agh.cs.lab2;

public class Animal {

    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position1 = new Vector2d(2, 2);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Położenie: ").append(position1.toString()).append(" Orientacja: ").append(direction.toString());
        return sb.toString();
    }

    public MapDirection getDirection (){
        return this.direction;
    }

    public Vector2d getPosition (){
        return this.position1;
    }

    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT: this.direction = this.direction.next();
                break;
            case LEFT: this.direction = this.direction.previous();
                break;
            case FORWARD:
                Vector2d test = position1.add(this.direction.toUnitVector());
                if(test.follows( new Vector2d(0,0)) &&  test.precedes(new Vector2d(4,4))) {
                    position1 = test;
                }
                break;
            case BACKWARD:
                Vector2d test2 = position1.subtract(this.direction.toUnitVector());
                if(test2.follows( new Vector2d(0,0)) &&  test2.precedes(new Vector2d(4,4))) {
                    position1 = test2;
                }
                break;
        }
    }

}