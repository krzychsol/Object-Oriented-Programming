package agh.ics.oop;

public class Animal {
    private MapDirection currentDirection = MapDirection.NORTH;
    private Vector2d currentPosition;

    public Animal(IWorldMap map,Vector2d initialPosition){

        currentPosition = initialPosition;
    }

    public MapDirection curDir(){
        return currentDirection;
    }

    public String toString() {
        String ret = "";
        switch(currentDirection){
            case NORTH -> ret = "N";
            case SOUTH -> ret = "S";
            case EAST -> ret = "E";
            case WEST -> ret = "W";
        }
        return ret;
    }

    public boolean isAt(Vector2d position) {
        return (position.x == currentPosition.x && position.y == currentPosition.y);
    }

    public void move(MoveDirection direction) {
        Vector2d newPostion = currentPosition;
        switch (direction) {
            case RIGHT -> currentDirection = currentDirection.next();
            case LEFT -> currentDirection = currentDirection.previous();
            case FORWARD -> {
                newPostion = currentPosition.add(currentDirection.toUnitVector());
            }
            case BACKWARD -> {
                newPostion = currentPosition.subtract(currentDirection.toUnitVector());
            }
        }
        if (){
            currentPosition = newPostion;
        }
    }
}
