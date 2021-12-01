package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap{

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) && (position.follows(new Vector2d(0,0)) && position.precedes(new Vector2d(width,height)));
    }

    public String toString(){
        MapVisualizer mapVis = new MapVisualizer(this);
        return mapVis.draw(new Vector2d(0,0),new Vector2d(width,height));
    }

}
