package rpg.game.rooms;

import java.util.HashSet;
import java.util.Set;

public class MapTracer {
    
    public static void traceGraph(Room start) {
        Set<Room> visited = new HashSet<>();
        traceGraphRecursive(start, visited);
    }


    private static void traceGraphRecursive(Room r, Set<Room> visited) {
        if (!visited.add(r)) {
            return;
        }

        System.out.println("Room:" + r.id);

        for (Direction d : Direction.values()) {
            if (r.hasExit(d)) {
                Room next = r.getExit(d);

                System.out.println("\t " + d + " -> " + next.getIdString());

            }
        }
        
        for (Direction d: Direction.values()) {
            if (r.hasExit(d)) {
                traceGraphRecursive(r.getExit(d), visited);
            }
        }
    }




}
