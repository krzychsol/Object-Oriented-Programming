package agh.ics.oop;
import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver {

    protected Map<Vector2d,Animal> AnimalsMap = new HashMap<>();
    protected int width;
    protected int height;
    public MapBoundary boundary = new MapBoundary();
    public Vector2d getLowerLeft(){return boundary.getLowerLeft();}
    public Vector2d getUpperRight(){return boundary.getUpperRight();}

    //GRASS FIELD MAP AND RECTANGULAR MAP METHODS

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d targetPosition = animal.getPosition();
        if(AnimalsMap.containsKey(targetPosition)){
            throw new IllegalArgumentException("Position "+targetPosition+" is not available");
        }
        AnimalsMap.put(targetPosition,animal);
        boundary.addElement(targetPosition);

        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(AnimalsMap.containsKey(position)){
            return AnimalsMap.get(position);
        }
        return null;
    }


    public String toString(){
        MapVisualizer mapVis = new MapVisualizer(this);

        //return mapVis.draw(new Vector2d(lowerL.x, lowerL.y),new Vector2d(uppperR.x, uppperR.y));
        return mapVis.draw(new Vector2d(getLowerLeft().x, getLowerLeft().y),new Vector2d(getUpperRight().x, getUpperRight().y));
    }

    //OBSERVER

    @Override
    public boolean positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animalAtOldPosition = AnimalsMap.get(oldPosition);
        AnimalsMap.remove(oldPosition,animalAtOldPosition);
        AnimalsMap.put(newPosition,animalAtOldPosition);
        return true;
    }
}
