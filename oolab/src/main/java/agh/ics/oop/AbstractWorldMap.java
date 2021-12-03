package agh.ics.oop;
import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver {

    protected List<Animal> animals = new ArrayList<>();
    protected Map<Vector2d,Animal> AnimalsMap = new HashMap<>();
    protected int width;
    protected int height;
    protected Vector2d lowerL = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
    protected Vector2d uppperR = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);

    //GRASS FIELD MAP AND RECTANGULAR MAP METHODS

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d targetPosition = animal.curPosition();
        if(AnimalsMap.containsKey(targetPosition)){
            return false;
        }
        AnimalsMap.put(targetPosition,animal);
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

        for (Map.Entry<Vector2d, Animal> vector2dAnimalEntry : AnimalsMap.entrySet()) {
            Vector2d position = (Vector2d) ((Map.Entry) vector2dAnimalEntry).getKey();
            lowerL = lowerL.lowerLeft(position);
            uppperR = uppperR.upperRight(position);

        }

        MapVisualizer mapVis = new MapVisualizer(this);
        return mapVis.draw(new Vector2d(lowerL.x, lowerL.y),new Vector2d(uppperR.x, uppperR.y));
    }

    //OBSERVER

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animalAtOldPosition = AnimalsMap.get(oldPosition);
        AnimalsMap.remove(oldPosition,animalAtOldPosition);
        AnimalsMap.put(newPosition,animalAtOldPosition);
    }
}
