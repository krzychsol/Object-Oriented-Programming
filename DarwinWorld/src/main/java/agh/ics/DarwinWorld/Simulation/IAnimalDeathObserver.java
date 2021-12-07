package agh.ics.DarwinWorld.Simulation;

import agh.ics.DarwinWorld.Objects.Animal;

public interface IAnimalDeathObserver {
    void animalDied( Animal animal);
}
