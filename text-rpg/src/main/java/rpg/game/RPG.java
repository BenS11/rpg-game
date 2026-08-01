package rpg.game;

import rpg.game.rooms.Room;
import rpg.game.rooms.Rooms;
import rpg.player.Player;

public class RPG {

    
    public static void main(String[] args) {
        
    }
    


    private void startGame() {
        Player player = new Player();

        Room activeRoom = Rooms.createStartRoom();

        while (player.bossAlive() && player.playerAlive()) {
            activeRoom.onEnter(player);
        }
    }
}