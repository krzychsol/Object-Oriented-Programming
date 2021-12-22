package agh.ics.oop;

public class Grass implements IMapElement{
    private final Vector2d grassPosition;

    public Grass(Vector2d grassPosition){
        this.grassPosition = grassPosition;
    }

    public Vector2d getPosition(){
        return grassPosition;
    }

    public String toString(){
        return "*";
    }

    @Override
    public String getUpIconPath() {
        return "src/main/resources/up.png";
    }

    @Override
    public String getDownIconPath() {
        return "src/main/resources/down.png";
    }

    @Override
    public String getLeftIconPath() {
        return "src/main/resources/left.png";
    }

    @Override
    public String getRightIconPath() {
        return "src/main/resources/right.png";
    }

    @Override
    public String getGrassIconPath() {
        return "src/main/resources/grass.png";
    }

}
