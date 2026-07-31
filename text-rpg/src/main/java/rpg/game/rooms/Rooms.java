package rpg.game.rooms;

import rpg.items.Treasure;
import rpg.npcs.Enemies;

public class Rooms {
    

    public static Room createTreasureRoom() {
        return new Room(Treasure.randomTreasure(), null, null);
    }

    public static Room createSmallEnemyRoom() {
        return new Room(Enemies.getSmallEnemy(), Items.)
    }
}
