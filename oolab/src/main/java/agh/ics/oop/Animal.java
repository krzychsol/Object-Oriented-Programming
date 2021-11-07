package agh.ics.oop;
import org.jetbrains.annotations.NotNull;

public class Animal{

    private MapDirection currentDirection = MapDirection.NORTH;
    private Vector2d currentPosition;
    private final IWorldMap map;

    public Animal(IWorldMap map,Vector2d initialPosition){
        this.map = map;
        this.currentPosition = initialPosition;
    }

    //Getter which get current direction
    public MapDirection curDir(){
        return currentDirection;
    }

    //Getter which get current position
    public Vector2d curPos(){
        return currentPosition;
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

    public boolean isAt(@NotNull Vector2d position) {
        return (position.x == currentPosition.x && position.y == currentPosition.y);
    }

    public void move(@NotNull MoveDirection direction) {
        Vector2d newPostion = new Vector2d(currentPosition.x,currentPosition.y);
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
        if(map.canMoveTo(newPostion)){
            currentPosition = newPostion;
        }
    }
}
