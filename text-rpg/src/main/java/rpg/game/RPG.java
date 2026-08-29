package rpg.game;

import rpg.game.rooms.Room;
import rpg.game.rooms.Rooms;
import rpg.player.Player;
import rpg.utility.IO;

public class RPG {

    
    public static void main(String[] args) {
        new RPG().startGame();
    }
    


    private void startGame() {
        Player player = new Player();

        Room activeRoom = Rooms.createSmallTestMap();

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