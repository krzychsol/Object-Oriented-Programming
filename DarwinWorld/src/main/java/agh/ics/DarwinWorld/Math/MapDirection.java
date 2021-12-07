package agh.ics.DarwinWorld.Math;

public enum MapDirection {
    NORTH,
    NORTHEAST,
    SOUTH,
    SOUTHEAST,
    EAST,
    SOUTHWEST,
    WEST,
    NORTHWEST;

    public String toString() {
        return switch (this) {
            case NORTH -> "Północ";
            case NORTHEAST -> "Północny wschód";
            case SOUTH -> "Południe";
            case SOUTHEAST -> "Południowy wschód";
            case EAST -> "Wschód";
            case SOUTHWEST -> "Południowy zachód";
            case WEST -> "Zachód";
            case NORTHWEST -> "Północny zachód";
        };
    }

    private final Vector2d[] unitVectors = {
            new Vector2d(0,1),
            new Vector2d(1,1),
            new Vector2d(1,0),
            new Vector2d(1,-1),
            new Vector2d(0,-1),
            new Vector2d(-1,-1),
            new Vector2d(-1,0),
            new Vector2d(-1,1),
    };

    public MapDirection next() {
        return MapDirection.values()[(this.ordinal() + 1) % 8];
    }

    public MapDirection previous() {
        int newDirectionID = (this.ordinal() - 1) % 8;
        if (newDirectionID < 0) {
            newDirectionID += 8;
        }
        return MapDirection.values()[newDirectionID];
    }

    public Vector2d toUnitVector() {
        return unitVectors[this.ordinal()];
    }

}
