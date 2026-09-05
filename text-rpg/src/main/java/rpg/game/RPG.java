package rpg.game;

import rpg.game.rooms.MapTracer;
import rpg.game.rooms.Room;
import rpg.game.rooms.Rooms;
import rpg.player.Player;
import rpg.player.playerTemplates.Debug;
import rpg.utility.IO;

public class RPG {


    public void startGame() {
        Player player = new Player();

        Room activeRoom = Rooms.createMap();
        if (player.basePlayerType instanceof Debug) {
            MapTracer.traceGraph(activeRoom);
        }

        while (ProgressTracker.bossAlive && player.isAlive()) {
            activeRoom.onEnter(player);

            if (player.isAlive() && ProgressTracker.bossAlive) {
                activeRoom = activeRoom.onExit(player);
            } else if (!player.isAlive()) {
                IO.println("You died! ):");
                break;
            } else {
                IO.println("You win!!!");
                IO.println("You scored " + player.treasure());
            }
        }
    }
}