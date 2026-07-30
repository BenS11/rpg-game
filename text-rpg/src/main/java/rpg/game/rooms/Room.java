import java.util.HashMap;
import java.util.Objects;

public class Room {
    private int treasure;
    private Item item;
    private int startDist = 0;
    private boolean createdBossRoom;
    private HashMap<Direction, Room> exits = new HashMap<>();



    public Room() {

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

    }

    public void connectBiDirectional(Direction direction, Room room) {
        this.addExit(direction, room);
        room.addExit(direction.opposite(), this);
    }

    public boolean hasExit(Direction dir) {
        return exits.containsKey(dir);
    }


}