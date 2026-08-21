package rpg.game.rooms;

import java.util.HashSet;
import java.util.List;

import rpg.items.Treasure;
import rpg.npcs.Foes.Enemies;
import rpg.npcs.Shops.Shop;
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
        return new Room().withTreasure(Treasure.randomTreasure()).withEnemies(
            List.of(Enemies.getSmallEnemy(), Enemies.getSmallEnemy()));
    }

    public static Room createMediumEnemyRoom() {
        return new Room()
            .withTreasure(Treasure.randomTreasure())
            .withEnemies(List.of(Enemies.getMediumEnemy(), Enemies.getMediumEnemy()));
    }

    public static Room createLargeEnemyRoom() {
        return new Room()
            .withEnemies(List.of(Enemies.getLargeEnemy()))
            .withTreasure(Treasure.LARGE);
    }

    public static Room createBossRoom() {
        return new Room()
            .withEnemies(List.of(Enemies.getBoss()))
            .withTreasure(Treasure.BOSS_REWARD);
    }

    public static Room createRandomRoom(int depth) {
        return new Room();
    }

    public static Room createSmallTestMap() {
        Room startRoom = createStartRoom();

        startRoom.connectBiDirectional(Direction.NORTH, createSmallEnemyRoom()).connectBiDirectional(Direction.EAST, createMediumEnemyRoom()).connectBiDirectional(Direction.NORTH, createLargeEnemyRoom());

        startRoom.connectBiDirectional(Direction.SOUTH, createSmallEnemyRoom().withShop(new Shop())).connectBiDirectional(Direction.WEST, createMediumEnemyRoom()).connect(Direction.WEST, createBossRoom());

        return startRoom;
    }

}

