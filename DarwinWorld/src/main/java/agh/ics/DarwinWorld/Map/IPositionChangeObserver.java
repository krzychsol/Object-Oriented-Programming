package agh.ics.DarwinWorld.Map;

import agh.ics.DarwinWorld.Objects.Animal;
import agh.ics.DarwinWorld.Math.Vector2d;

public interface IPositionChangeObserver {
    void positionChanged( Vector2d oldPosition, Vector2d newPosition, Animal animal);
}
