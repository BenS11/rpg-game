package rpg.player;

import java.util.ArrayList;
import java.util.List;

import rpg.player.playerTemplates.*;
import rpg.utility.InputHandler;
import rpg.items.Item;

public class Player { 

    private List<Item> items = new ArrayList<>();
    
    private int health;
    private int healthRemaining;
    
    private boolean bossAlive = true;

    public Player() {
        PlayerTemplate basePlayerType = InputHandler.choice(new Barbarian(), new Wizard());

        health = basePlayerType.
    }



    public void addItem(Item i) {
        items.add(i);
    }

    public boolean bossAlive() {
        return bossAlive;
    }

    public boolean playerAlive() {
        return type
    }
    
    
    
}