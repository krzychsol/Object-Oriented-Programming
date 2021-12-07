package agh.ics.DarwinWorld.Simulation;
import agh.ics.DarwinWorld.IEngine;
import agh.ics.DarwinWorld.Map.RectangularMap;
import agh.ics.DarwinWorld.Objects.Animal;
import agh.ics.DarwinWorld.Setup.WorldSettings;

import java.util.ArrayList;

public class SimulationEngine implements IEngine {

    private ArrayList<Animal> animals;

    public SimulationEngine( WorldSettings args, RectangularMap map){
        animals = AnimalsGenerator.generateAnimals(args.numOfAnimals,args.startEnergy,map);

    }

    @Override
    public void run() {

    }
}
