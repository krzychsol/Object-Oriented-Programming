package agh.ics.oop;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Animal{

    private MapDirection currentDirection = MapDirection.NORTH;
    private Vector2d currentPosition;
    private final IWorldMap map;
    private final List<IPositionChangeObserver> observers = new ArrayList<>();

    //ANIMAL CONSTRUCTOR
    public Animal(IWorldMap map,Vector2d initialPosition){
        this.map = map;
        this.currentPosition = initialPosition;
        addObserver((AbstractWorldMap) map);
    }

    //GET ANIMAL DIRECTION
    public MapDirection curDirection(){
        return currentDirection;
    }

    //GET ANIMAL POSITION
    public Vector2d curPosition(){
        return currentPosition;
    }

    //ANIMAL METHODS

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
            positionChanged(currentPosition,newPostion);
            currentPosition = newPostion;
        }
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

    //OBSERVER

    void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }
    void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    void positionChanged(Vector2d oldPosition,Vector2d newPosition){
        for(IPositionChangeObserver o: observers){
            o.positionChanged(oldPosition,newPosition);
        }
    }
}
