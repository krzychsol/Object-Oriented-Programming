package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap{

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public String toString(){
        MapVisualizer mapVis = new MapVisualizer(this);
        return mapVis.draw(new Vector2d(0,0),new Vector2d(width,height));
    }
}
