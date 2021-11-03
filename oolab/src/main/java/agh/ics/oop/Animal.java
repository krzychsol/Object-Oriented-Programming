package agh.ics.oop;

public class Animal {
    private MapDirection currentDirection = MapDirection.NORTH;
    private Vector2d currentPosition = new Vector2d(2, 2);

    public MapDirection curDir(){
        return currentDirection;
    }

    public String toString() {
        return "[" + currentDirection + "," + currentPosition + "]";
    }

    public boolean isAt(Vector2d position) {
        return (position.x == currentPosition.x && position.y == currentPosition.y);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> currentDirection = currentDirection.next();
            case LEFT -> currentDirection = currentDirection.previous();
            case FORWARD -> {
                if (currentPosition.add(currentDirection.toUnitVector()).x <= 4 && currentPosition.add(currentDirection.toUnitVector()).y <= 4 && currentPosition.add(currentDirection.toUnitVector()).x >= 0 && currentPosition.add(currentDirection.toUnitVector()).y >= 0) {
                    currentPosition = currentPosition.add(currentDirection.toUnitVector());
                }
            }
            case BACKWARD -> {
                if (currentPosition.subtract(currentDirection.toUnitVector()).x >= 0 && currentPosition.subtract(currentDirection.toUnitVector()).y >= 0 && currentPosition.subtract(currentDirection.toUnitVector()).x <= 4 && currentPosition.subtract(currentDirection.toUnitVector()).y <= 4){
                    currentPosition = currentPosition.subtract(currentDirection.toUnitVector());
                }
            }
        }
    }
}
