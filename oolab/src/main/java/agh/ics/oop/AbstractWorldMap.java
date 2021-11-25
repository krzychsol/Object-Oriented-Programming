package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap{
    protected List<Animal> animals = new ArrayList<>();
    protected int width;
    protected int height;
    protected Vector2d lowerL = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
    protected Vector2d uppperR = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);

    @Override
    public boolean canMoveTo(Vector2d position) {
        for(Animal a : animals){
            if(a.isAt(position)){
                return false;
            }
        }
        return (position.follows(new Vector2d(0,0)) && position.precedes(new Vector2d(width,height)));
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d targetPosition = animal.curPosition();
        for(Animal a: animals){
            if (a.isAt(targetPosition)){
                return false;
            }
        }
        animals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal a: animals){
            Vector2d aPosition = a.curPosition();
            if (aPosition.x == position.x && aPosition.y == position.y){
                return a;
            }
        }
        return null;
    }

    public String toString(){

        for(Animal a: animals){
            Vector2d animalPos = a.curPosition();
            lowerL =  lowerL.lowerLeft(animalPos);
            uppperR = uppperR.upperRight(animalPos);
        }

        MapVisualizer mapVis = new MapVisualizer(this);
        return mapVis.draw(new Vector2d(lowerL.x, lowerL.y),new Vector2d(uppperR.x, uppperR.y));
    }
}
