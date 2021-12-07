package agh.ics.DarwinWorld.Simulation;
import agh.ics.DarwinWorld.Map.RectangularMap;
import agh.ics.DarwinWorld.Math.Vector2d;
import agh.ics.DarwinWorld.Objects.Animal;

import java.util.ArrayList;
import java.util.Random;

public class AnimalsGenerator {

    public static ArrayList<Animal> generateAnimals( int numberOfAnimals, int startEnergy, RectangularMap spawnMap){
        ArrayList<Animal> newAnimals = new ArrayList<> ();
        int width = spawnMap.getWidth ();
        int height = spawnMap.getHeight ();
        Random generator = new Random ();

        for (int i = 0; i < numberOfAnimals; i++) {
            int x = generator.nextInt ( width );
            int y = generator.nextInt ( height );
            Vector2d animalPosition = new Vector2d (x, y);

            if (( spawnMap.objectAt ( animalPosition ) instanceof Animal )) {
                i -= 1; //animal is not created
            }
            else {
                Animal animal = new Animal ( spawnMap, animalPosition, startEnergy, 1 );
                spawnMap.place (animal);
                newAnimals.add (animal);
            }
        }

        return newAnimals;
    }
}
