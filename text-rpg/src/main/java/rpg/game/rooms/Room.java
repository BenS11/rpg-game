package rpg.game.rooms;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

import rpg.items.Item;
import rpg.npcs.Foes.Enemy;
import rpg.npcs.Shops.Shop;
import rpg.player.Player;
import rpg.utility.IO;

public class Room {
    private List<Enemy> enemies = new ArrayList<>(); 
    private int treasure;
    private Item item;
    private Shop shop;
    private final EnumMap<Direction, Room> exits = new EnumMap<>(Direction.class);
    private boolean bossRoom = false;
    private boolean visited = false;



    public Room() {}

    public Room withEnemies(List<Enemy> enemies) {
        this.enemies.addAll(enemies);
        return this;
    }
    
    public Room withShop(Shop shop) {
        this.shop = shop;
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

    public String visitedString() {
        return visited ? "visited" : "unvisited";
    }

    public void onEnter(Player player) {
        if (!enemies.isEmpty()) {
            IO.println("This room contains:");
            for (Enemy e : enemies) {
                IO.println(e.toString());
            }
            player.fight(enemies);
        }

    }

    public Room onExit(Player player) {
        if (!visited || !enemies.isEmpty()) {
            IO.println("Congrats!");
        }

        removeDeadEnemies();

        if (treasure > 0) {
            IO.println("You gained " + treasure);
            player.addTreasure(treasure);
            treasure = 0;
        } 

        if (item != null) {
            IO.println("You gained a " + item.toString());
            player.addItem(item);
        }

        if (shop != null) {
            player.shopAt(shop);
        }

        visited = true;

        IO.println("Which direction would you like to go?");
        return exits.get(IO.choice((r) -> exits.get(r).visitedString(), exits.keySet().toArray(Direction[]::new)));
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

    /**
     * Connects this room to another room
     * @param direction The direction of the exit that connects this room to the other
     * @param room The room
     * @return The room passed in the argument to chain connections
     */
    public Room connectBiDirectional(Direction direction, Room room) {
        this.connect(direction, room);
        room.connect(direction.opposite(), this);

        return room;
    }

    public boolean hasExit(Direction dir) {
        return exits.containsKey(dir);
    }

    public boolean visited() {
        return visited;
    }

    public void removeDeadEnemies() {
        enemies.removeIf((e) -> !e.isAlive());
    }


}