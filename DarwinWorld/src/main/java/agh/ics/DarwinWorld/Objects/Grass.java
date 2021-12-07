package agh.ics.DarwinWorld.Objects;

import agh.ics.DarwinWorld.Math.Vector2d;

public class Grass implements IMapElement{
    private final Vector2d grassPosition;
    private final double energy;

    public Grass(Vector2d grassPosition, double energy){
        this.grassPosition = grassPosition;
        this.energy = energy;
    }

    public Vector2d getPosition(){
        return grassPosition;
    }

    public String toString(){
        return "*";
    }

    public double getEnergy () {
        return energy;
    }
}
