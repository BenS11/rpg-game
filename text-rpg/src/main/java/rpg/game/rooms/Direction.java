public enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public Direction opposite() {
        return switch (this) {
            case NORTH -> SOUTH;
            case SOUTH -> NORTH;
            case EAST  -> WEST;
            case WEST  -> EAST;
        };
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