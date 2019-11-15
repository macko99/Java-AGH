package agh.cs.lab8;

public class Vector2d {
    int x;
    int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash += this.x * 31;
        hash += this.y * 17;
        return hash;
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

    boolean isInBounds(Vector2d v1, Vector2d v2) {
        return this.follows(v1) && this.precedes(v2);
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
        return vector.hashCode() == this.hashCode();
    }

    public Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }
}
