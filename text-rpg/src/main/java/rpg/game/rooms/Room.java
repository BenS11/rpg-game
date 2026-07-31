package rpg.game.rooms;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import rpg.items.Item;
import rpg.npcs.Enemy;

public class Room {
    private List<Enemy> enemies; 
    private int treasure;
    private Item item;
    private HashMap<Direction, Room> exits = new HashMap<>();

    private static int roomsCreated = 0;



    public Room(int treasure, Item item, List<Enemy> enemies) {
        roomsCreated++;
        this.treasure = treasure;
        this.item = item;
        this.enemies = enemies;
    }

    public void addExit(Direction direction, Room room) {
        Objects.requireNonNull(direction);
        Objects.requireNonNull(room);

        if (room == this) {
            throw new IllegalArgumentException("A room cannot connect to itself.");
        } 

        if (this.hasExit(direction)) {
            throw new IllegalStateException("Exit " + direction + " already exists.");
        }

        exits.put(direction, room);

    }

    public void connectBiDirectional(Direction direction, Room room) {
        this.addExit(direction, room);
        room.addExit(direction.opposite(), this);
    }

    public boolean hasExit(Direction dir) {
        return exits.containsKey(dir);
    }

    public void generateMap() {

    }


}