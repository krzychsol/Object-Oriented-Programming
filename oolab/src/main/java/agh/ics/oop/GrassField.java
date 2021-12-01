package agh.ics.oop;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;

public class GrassField extends AbstractWorldMap{

    public final int width;
    public final int height;
    public final ArrayList<Grass> grassList = new ArrayList<>();

    public GrassField(int numberOfTuftsOfGrass){
        this.width = (int)Math.sqrt(numberOfTuftsOfGrass*10);
        this.height = (int)Math.sqrt(numberOfTuftsOfGrass*10);
        Random rng = new Random();
        LinkedHashSet<Integer> generated = new LinkedHashSet<>();

        while (generated.size()<numberOfTuftsOfGrass) {
            int next = rng.nextInt(width*height+1);
            if(generated.add(next)){
                Vector2d randomPosition = new Vector2d(next%width,next/width);
                Grass tuftOfGrass = new Grass(randomPosition);
                grassList.add(tuftOfGrass);
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) &&
        (!position.follows(new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE))
                || !position.precedes(new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE)));
    }

    @Override
    public Object objectAt(Vector2d position) {
        if( super.objectAt(position) == null){
            for(Grass g: grassList){
                if(g.getPosition().equals(position)){
                    return g;
                }
            }
        }
        else{
            return super.objectAt(position);
        }
        return null;
    }

    public String toString(){
        for(Grass g: grassList){
            Vector2d grassPos = g.getPosition();
            lowerL =  lowerL.lowerLeft(grassPos);
            uppperR = uppperR.upperRight(grassPos);
        }

        return super.toString();

    }

}
