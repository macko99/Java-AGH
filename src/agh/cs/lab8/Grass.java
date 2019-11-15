package agh.cs.lab8;

public class Grass {
    private Vector2d position;

    public Grass(Vector2d position){
        this.position = position;
    }

    public Vector2d getPosition() {
        return position;
    }

    public String toString(){
        return ("g");
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if(!(other instanceof Grass))
            return false;
        Grass grass = (Grass) other;
        return this.position.equals(grass.position);
    }
}
