package rpg.player;

import java.util.ArrayList;
import java.util.List;

import rpg.player.playerTemplates.*;
import rpg.utility.InputHandler;
import rpg.abilities.Attack;
import rpg.items.Item;
import rpg.npcs.Enemy;

public class Player { 

    private List<Item> items = new ArrayList<>();
    private List<Attack> attacks = new ArrayList<>();
    
    private int health;
    private int healthRemaining;

    private int treasure;
    
    public boolean bossAlive = true;

    public Player() {
        PlayerTemplate basePlayerType = InputHandler.choice(new Barbarian(), new Wizard());

        health = basePlayerType.hpMax();
        healthRemaining = health;

        attacks.addAll(basePlayerType.attacks());
    }



    public void addItem(Item i) {
        items.add(i);
    }

    public void addTreasure(int treasure) {
        this.treasure += treasure;
    }

    public boolean bossAlive() {
        return bossAlive;
    }

    public boolean playerAlive() {
        return healthRemaining > 0;
    }



    public void fight(List<Enemy> enemies) {
        for (Enemy e: enemies) {

        }

    }
    
    
    
}