package rpg.game.rooms;

import java.util.HashSet;
import java.util.List;

import rpg.game.ProgressTracker;
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
            List.of(Enemies.getSmallGoblin(), Enemies.getSmallGoblin()));
    }

    public static Room createMediumEnemyRoom() {
        return new Room()
            .withTreasure(Treasure.randomTreasure())
            .withEnemies(List.of(Enemies.getMediumGoblin(), Enemies.getMediumGoblin()));
    }

    public static Room createLargeEnemyRoom() {
        return new Room()
            .withEnemies(List.of(Enemies.getLargeGoblin()))
            .withTreasure(Treasure.LARGE);
    }

    public static Room createBossRoom() {
        System.out.println("created boss room");
        return new Room()
            .withBoss(Enemies.getBoss())
            .withTreasure(Treasure.BOSS_REWARD);
    }

    public static Room createShopRoom() {
        return new Room()
            .withShop(new Shop());
    }

    public static Room createRandomRoom(int depth) {
        double rand = Math.random();

        switch (depth) {
            case 0 -> {
                return createSmallEnemyRoom();
            }
            case 1 -> {
                if (rand > 0.33) {
                    return createMediumEnemyRoom();
                } else {
                    return createShopRoom();
                }
            }
            case 2 -> {
                if (rand > 0.8) {
                    return createShopRoom();
                } else if (rand > 0.3) {
                    return createLargeEnemyRoom();
                }   else {
                    return createMediumEnemyRoom();
                }
            }
            case 3 -> {
                if (rand < 0.05) {
                    return createTreasureRoom();
                } else if (rand < 0.8) {
                    return createMediumEnemyRoom();
                            } else {
                    return createLargeEnemyRoom();
                }
            }
            case 4 -> {
                if (rand > 0.75) {
                    return createShopRoom();
                } else if (rand > 0.65) {
                    return createTreasureRoom();
                } else {
                    return createLargeEnemyRoom();
                }
            }
            default -> {
                if (!ProgressTracker.bossExists && rand < 0.25) {
                    return createBossRoom();
                } else {
                    return createLargeEnemyRoom();
                }
            }
        }
    }

    public static Room createSmallTestMap() {
        Room startRoom = createStartRoom();

        startRoom.connectBiDirectional(Direction.NORTH, createSmallEnemyRoom()).connectBiDirectional(Direction.EAST, createMediumEnemyRoom()).connectBiDirectional(Direction.NORTH, createLargeEnemyRoom());

        startRoom.connectBiDirectional(Direction.SOUTH, createSmallEnemyRoom().withShop(new Shop())).connectBiDirectional(Direction.WEST, createMediumEnemyRoom()).connect(Direction.WEST, createBossRoom());

        return startRoom;
    }

    public static Room createMap() {
        Room startRoom = createStartRoom();

        Room cur = startRoom;

        createRoomRecursive(cur, Direction.EAST, 0);
        createRoomRecursive(cur, Direction.WEST, 0);
        createRoomRecursive(cur, Direction.NORTH, 0);
        createRoomRecursive(cur, Direction.SOUTH, 0);

        


        return startRoom;

    }

    /**
     * Recursive creates rooms until certain base cases are hit. Builds a section of the map
     * @param cur current room
     * @param fromDirection direction of the exit from last room to this room, eg adding an exit west of the last room makes this west
     * @param roomCount the distance from the starting room
     * @return a room
     */
    public static Room createRoomRecursive(Room cur, Direction fromDirection, int roomCount) {
        


        // if deep, create the boss room and cut off the recursion
        if (roomCount > 3 && !ProgressTracker.bossExists && (roomCount > 6 || Math.random() > 0.75)) {
            cur.connectBiDirectional(fromDirection, createBossRoom());
            return cur;
            // should prob develop a good statistical method but for now
        } else if (roomCount > 2 && roomCount != 0 &&  Math.random() > 2.0 / roomCount) {
            return cur;
        }
        
        if (!cur.hasExit(fromDirection) && Math.random() > roomCount / 8.0) {
            cur.connectBiDirectional(fromDirection, createRoomRecursive(createRandomRoom(roomCount), fromDirection, roomCount + 1));
        }
        
        for (Direction d : Direction.values()) {
            
            if (d.equals(fromDirection) || d.equals(fromDirection.opposite())) continue;

            if (!cur.hasExit(d) && Math.random() > 0.7) {
                Room next = createRandomRoom(roomCount + 1);

                cur.connectBiDirectional(d, next);

                createRoomRecursive(next, d, roomCount + 1);
            }
        }

        return cur;
    }

}

