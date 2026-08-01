package rpg.game.rooms;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import rpg.items.Item;
import rpg.npcs.Enemy;
import rpg.player.Player;
import rpg.utility.Coordinate;
import rpg.utility.InputHandler;

public class Room {
    private List<Enemy> enemies = new ArrayList<>(); 
    private int treasure;
    private Item item;
    private EnumMap<Direction, Room> exits = new EnumMap<>(Direction.class);
    private boolean bossRoom = false;



    public Room() {}

    public Room withEnemies(List<Enemy> enemies) {
        this.enemies.addAll(enemies);
        return this;
    }

    public Room withTreasure(int treasure) {
        this.treasure = treasure;
        return this;
    }

    public Room withItem(Item item) {
        this.item = item;
        return this;
    }

    public Room withBoss(Enemy boss) {
        this.bossRoom = true;
        this.enemies.add(boss);
        return this;
    }

    public void onEnter(Player player) {

    }

    public Room onExit(Player player) {


        return InputHandler.choice()
    }

    public void connect(Direction direction, Room room) {
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
        this.connect(direction, room);
        room.connect(direction.opposite(), this);
    }

    public boolean hasExit(Direction dir) {
        return exits.containsKey(dir);
    }

    /**
     * generates a map and returns starter room
     * @return
     */
    public static Room generateMap() {
        Room start = Rooms.createStartRoom();
        Room right = Rooms.createRandomRoom(1);
        Room left = Rooms.createRandomRoom(1);

        start.connect(Direction.WEST, left);
        start.connect(Direction.EAST, right);



        

        return start;

    }


}