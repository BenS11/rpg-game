package rpg.game.rooms;

import rpg.utility.Tuple;

public enum Direction {
    NORTH(0, 1),
    SOUTH(0, -1),
    EAST(1, 0),
    WEST(-1, 0);

    private final int dx;
    private final int dy;

    private Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction opposite() {
        return switch (this) {
            case NORTH -> SOUTH;
            case SOUTH -> NORTH;
            case EAST  -> WEST;
            case WEST  -> EAST;
        };
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
    
    public Direction fromInput(String input) {
        return switch (input.toLowerCase()) {
            case "n", "north" -> Direction.NORTH;
            case "s", "south" -> Direction.SOUTH;
            case "e", "east" -> Direction.EAST;
            case "w", "west" -> Direction.WEST;
            default -> null;
        };
    }
}