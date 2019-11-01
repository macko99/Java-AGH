package agh.cs.lab5;

public class Stone {
    private Vector2d position;

    public Stone (Vector2d position){
        this.position = position;
    }

    public Vector2d getPosition() {
        return position;
    }

    public String toString(){
        return ("s");
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if(!(other instanceof Stone))
            return false;
        Stone stone = (Stone) other;
        return this.position.equals(stone.position);
    }
}
