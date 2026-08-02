package rpg.game;

import java.util.List;

import rpg.game.rooms.Direction;
import rpg.game.rooms.Room;
import rpg.game.rooms.Rooms;
import rpg.npcs.Enemy;
import rpg.player.Player;
import rpg.utility.InputHandler;

public class RPG {

    
    public static void main(String[] args) {
        new RPG().startGame();
    }
    


    private void startGame() {
        Player player = new Player();

        Room activeRoom = Rooms.createStartRoom();
        activeRoom.connectBiDirectional(Direction.NORTH, new Room());

        while (player.bossAlive() && player.playerAlive()) {
            activeRoom.onEnter(player);

            if (player.playerAlive()) {
                activeRoom = activeRoom.onExit(player);
            }
        }
    }
}