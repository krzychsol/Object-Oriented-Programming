package agh.ics.oop;

public class RectangularMap implements IWorldMap{

    private final int width;
    private final int height;
    private final Animal[][] animalAtPos;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.animalAtPos = new Animal[height][width];
        for(int i = 0; i < height; ++i)
            for(int j = 0; j < width; ++j)
                animalAtPos[i][j] = null;
    }

    public String toString(){
        MapVisualizer mapVisual = new MapVisualizer(this);
        return mapVisual.draw(new Vector2d(0,0),new Vector2d(width,height));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return animalAtPos[position.x][position.y] == null;
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d initPosition = animal.curPos();
        if (animalAtPos[initPosition.x][initPosition.y] != null){
            return true;
        }
        else{
            animalAtPos[initPosition.x][initPosition.y] = animal;
            return false;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animalAtPos[position.x][position.y] != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animalAtPos[position.x][position.y];
    }
}
