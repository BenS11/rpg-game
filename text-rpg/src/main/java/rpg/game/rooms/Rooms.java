package rpg.game.rooms;

import java.util.HashMap;
import java.util.HashSet;

import rpg.items.Treasure;
import rpg.npcs.Enemies;
import rpg.utility.Coordinate;

public class Rooms {
    
    private Rooms() {}

    private static HashSet<Coordinate> usedCoordinatesMap = new HashSet<>();

    public static void addUsedCoordinate(int x, int y) {
        usedCoordinatesMap.add(new Coordinate(x, y));
    }

    public static boolean checkUsedCoordinate(int x, int y) {
        return usedCoordinatesMap.contains(new Coordinate(x, y));
    }

    public static Room createStartRoom() {
        return new Room();
    }

    public static Room createTreasureRoom() {
        return new Room().withTreasure(Treasure.LARGE);
    }

    public static Room createSmallEnemyRoom() {
        return new Room().withTreasure(Treasure.randomTreasure()).withEnemies(null);
    }

    public static Room createMediumEnemyRoom() {
        return new Room().withTreasure(Treasure.randomTreasure());
    }

    public static Room createLargeEnemyRoom() {
        return new Room();
    }

    public static Room createBossRoom() {
        return new Room();
    }

    public static Room createRandomRoom(int depth) {
        return new Room();
    }

}

