package agh.cs.lab4;

class OptionsParser {

    static MoveDirection[] parse(String[] args){
        MoveDirection[] directions = new MoveDirection[args.length];
        int i=0;
        for(String arg : args){
            switch(arg){
                case "f":
                case "forward":
                    directions[i++] = MoveDirection.FORWARD;
                    break;
                case "b":
                case "backward":
                    directions[i++] = MoveDirection.BACKWARD;
                    break;
                case "r":
                case "right":
                    directions[i++] = MoveDirection.RIGHT;
                    break;
                case "l":
                case "left":
                    directions[i++] = MoveDirection.LEFT;
                    break;
            }
        }
        return directions;
    }
}
