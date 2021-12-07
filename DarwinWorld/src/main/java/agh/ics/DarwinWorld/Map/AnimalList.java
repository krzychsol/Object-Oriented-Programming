package agh.ics.DarwinWorld.Map;

import agh.ics.DarwinWorld.Objects.Animal;

import java.util.ArrayList;

public class AnimalList implements IAnimalCollection{

    private final ArrayList<Animal> animals = new ArrayList<> ();

    @Override
    public Animal get ( int i ) {
        if (i < animals.size()){
            return animals.get(i);
        }
        return null;
    }

    @Override
    public void add ( Animal animal ) {
        if( animals.size() == 0){
            animals.add ( animal );
        }
        else{
            int i=0;
            while( i < animals.size() && animals.get(i).getEnergy() > animal.getEnergy()){
                i+=1;
            }
            animals.add ( animal );
        }
    }

    @Override
    public void remove ( Animal animal ) {
        animals.remove ( animal );
    }

    @Override
    public void energyChanged ( Animal animal ) {
        animals.remove ( animal );
        animals.add ( animal );
    }

    @Override
    public int size () {
        return animals.size();
    }
}
