package rpg.game;

import java.util.List;

import rpg.game.rooms.Direction;
import rpg.game.rooms.Room;
import rpg.game.rooms.Rooms;
import rpg.npcs.Enemies;
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
        Room r1 = Rooms.createSmallEnemyRoom();
        Room r2 = Rooms.createMediumEnemyRoom();
        Room r3 = Rooms.createBossRoom();

        activeRoom.connectBiDirectional(Direction.NORTH, r1);
        r1.connectBiDirectional(Direction.NORTH, r2);
        r2.connectBiDirectional(Direction.NORTH, r3);

        while (player.bossAlive() && player.isAlive()) {
            activeRoom.onEnter(player);

            if (player.isAlive()) {
                activeRoom = activeRoom.onExit(player);
            } else {
                System.out.println("You died! ):");
                break;
            }
        }
    }
}