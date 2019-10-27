package agh.cs.lab4;

public class Vector2d {
    int x;
    int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")" ;
    }

    public boolean precedes(Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2d other) {
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2d upperRight(Vector2d other){
        return new Vector2d(Math.max(other.x, this.x), Math.max(other.y, this.y));
    }

    public Vector2d lowerLeft(Vector2d other){
        return new Vector2d(Math.min(other.x, this.x), Math.min(other.y, this.y));
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(other.x+this.x, other.y+this.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x-other.x, this.y-other.y);
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if(!(other instanceof Vector2d))
            return false;
        Vector2d vector = (Vector2d) other;
        return vector.x == this.x && vector.y == this.y;
    }

    public Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }
}
