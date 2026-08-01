package rpg.utility;

import rpg.game.rooms.Direction;

public record Coordinate(int x, int y) {
    public Coordinate plus(Coordinate c) {
        return new Coordinate(c.x + this.x, c.y + this.y);
    }

    public Coordinate plus(Direction d) {
        return new Coordinate(d.dx() + this.x, d.dy() + this.y);
    }
}
