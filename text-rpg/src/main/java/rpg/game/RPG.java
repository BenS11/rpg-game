package rpg.game;

import rpg.game.rooms.Room;
import rpg.game.rooms.Rooms;
import rpg.player.Player;
import rpg.utility.OutputHandler;

public class RPG {

    
    public static void main(String[] args) {
        new RPG().startGame();
    }
    


    private void startGame() {
        Player player = new Player();

        Room activeRoom = Rooms.createSmallTestMap();

        while (player.bossAlive() && player.isAlive()) {
            activeRoom.onEnter(player);

            if (player.isAlive()) {
                activeRoom = activeRoom.onExit(player);
            } else {
                OutputHandler.println("You died! ):");
                break;
            }
        }
    }
}