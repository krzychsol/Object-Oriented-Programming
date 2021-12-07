package agh.ics.oop;
import javax.xml.stream.XMLInputFactory;
import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver {

    protected List<Animal> animals = new ArrayList<>();
    protected Map<Vector2d,Animal> AnimalsMap = new HashMap<>();
    protected int width;
    protected int height;
    protected Vector2d lowerL = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
    protected Vector2d uppperR = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
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
        Vector2d targetPosition = animal.curPosition();
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
        /*
        for (Map.Entry<Vector2d, Animal> vector2dAnimalEntry : AnimalsMap.entrySet()) {
            Vector2d position = (Vector2d) ((Map.Entry) vector2dAnimalEntry).getKey();
            lowerL = lowerL.lowerLeft(position);
            uppperR = uppperR.upperRight(position);

        }
        if (lowerL.follows(getLowerLeft())){
            lowerL = getLowerLeft();
        }
        if (uppperR.precedes(getUpperRight())){
            uppperR = getUpperRight();
        }
        */
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
