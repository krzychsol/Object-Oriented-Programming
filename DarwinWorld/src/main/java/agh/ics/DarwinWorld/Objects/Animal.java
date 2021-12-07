package agh.ics.DarwinWorld.Objects;

import agh.ics.DarwinWorld.Simulation.IAnimalDeathObserver;
import agh.ics.DarwinWorld.Map.IEnergyChangeObserver;
import agh.ics.DarwinWorld.Map.IPositionChangeObserver;
import agh.ics.DarwinWorld.Map.RectangularMap;
import agh.ics.DarwinWorld.Math.MapDirection;
import agh.ics.DarwinWorld.Math.Vector2d;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Animal implements IMapElement{

    private int energy;
    private final int birthday;
    private boolean isAlive = true;
    private int deathday;
    private Genotype gen;

    private MapDirection currentDirection;
    private Vector2d currentPosition;
    private final RectangularMap map;
    private IPositionChangeObserver positionObservers;
    private IEnergyChangeObserver energyObservers;
    private ArrayList<IAnimalDeathObserver> deathObservers = new ArrayList<>();

    private final ArrayList<Animal> parents = new ArrayList<>();
    private final HashSet<Animal> children = new HashSet<>();
    private final static Random generator = new Random ();

    //ANIMAL CONSTRUCTOR
    public Animal(RectangularMap map, Vector2d initialPosition, int energy, int birthday){

        this.currentPosition = initialPosition;
        this.map = map;
        this.birthday = birthday;
        this.currentDirection = MapDirection.values()[generator.nextInt(8)];
        this.gen = new Genotype();
        this.energy = energy;
    }

    //ANIMAL CONSTRUCTOR BASED ON PARENTS
    public Animal(RectangularMap map, Vector2d initialPosition, int birthday, Animal strongerParent, Animal weakerParent){

        this.currentPosition = initialPosition;
        this.map = map;
        this.birthday = birthday;
        this.currentDirection = MapDirection.values()[generator.nextInt(8)];
        this.gen = new Genotype(strongerParent.gen, weakerParent.gen);
        this.energy = (int)(strongerParent.energy*0.25 + weakerParent.energy*0.25);
        strongerParent.changeEnergy(-strongerParent.energy * 0.25);
        weakerParent.changeEnergy(-weakerParent.energy * 0.25);

        // creating family bonds
        this.parents.add(strongerParent);
        this.parents.add(weakerParent);
        strongerParent.children.add(this);
        weakerParent.children.add(this);

    }

    public void makeMove(){
        currentDirection = MapDirection.values()[(currentDirection.ordinal() + gen.getRandomGene())%8];
        Vector2d oldPosition = currentPosition;
        currentPosition = currentPosition.add(currentDirection.toUnitVector());
        currentPosition = currentPosition.standardizeToMap(map.getWidth(), map.getHeight());
        this.positionChanged(oldPosition, currentPosition);
    }

    public void kill(int day){
        map.removeAnimal(this);
        removeEnergyChangeObserver();
        removePositionChangeObserver();
        isAlive = false;
        this.deathday = day;
        removeFamilyBonds();
        for (IAnimalDeathObserver observer: deathObservers){
            observer.animalDied(this);
        }

    }

    private void removeFamilyBonds() {
        for (Animal parent: parents)
            parent.children.remove(this);
        for (Animal child: children)
            child.parents.remove(this);
    }



    public void changeEnergy(double energy){
        this.energy += energy;
        energyChanged();
    }

    /// GETTERS

    public double getEnergy() {
        return energy;
    }

    public int getLifeTime() {
        return deathday - birthday;
    }

    @Override
    public Vector2d getPosition() {
        return this.currentPosition;
    }

    public Genotype getGenotype() {
        return gen;
    }

    public boolean isAlive() {
        return isAlive;

    }
    public int getChildrenNumber() {
        return children.size();
    }

    public int getDeathDay() {
        return deathday;
    }

    ///

    /// OBSERVERS RELATED FUNCTIONS

    public void addPositionObserver(IPositionChangeObserver observer) {
        positionObservers = observer;
    }

    public void addEnergyObserver(IEnergyChangeObserver observer) {
        energyObservers = observer;
    }

    public void addDeathObserver(IAnimalDeathObserver observer) {
        deathObservers.add(observer);
    }

    public void removePositionChangeObserver(){
        positionObservers = null;
    }

    public void removeEnergyChangeObserver(){
        energyObservers = null;
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        if (positionObservers != null)
            positionObservers.positionChanged(oldPosition, newPosition, this);
    }

    public void energyChanged(){
        if (energyObservers != null)
            energyObservers.energyChanged(this);
    }

    ///

}
