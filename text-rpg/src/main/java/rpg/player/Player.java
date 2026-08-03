package rpg.player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import rpg.player.playerTemplates.*;
import rpg.utility.InputHandler;
import rpg.utility.Tuple;
import rpg.abilities.Attack;
import rpg.abilities.DamageBundle;
import rpg.abilities.Element;
import rpg.items.Item;
import rpg.npcs.Enemy;

public class Player { 

    private List<Item> items = new ArrayList<>();
    private Set<Attack> attacks = new HashSet<>();
    
    private int health;
    private int healthRemaining;

    private int treasure;
    
    public boolean bossAlive = true;

    public Player() {
        PlayerTemplate basePlayerType = InputHandler.choice(new Barbarian(), new Wizard());

        health = basePlayerType.hpMax();
        healthRemaining = health;

        addAttacks(basePlayerType.attacks());
    }



    public void addItem(Item i) {
        items.add(i);
        items.sort(Item.comparator);
    }

    public void addTreasure(int treasure) {
        this.treasure += treasure;
    }

    public boolean bossAlive() {
        return bossAlive;
    }

    public boolean isAlive() {
        return healthRemaining > 0;
    }

    public void addAttacks(Set<Attack> list) {
        attacks.addAll(list);
    }

    public void takeDamage(DamageBundle attack) {

        healthRemaining -= attack.damage();
        if (isAlive()) {
            System.out.println("You are now at " + healthRemaining + " hp");
        } else {
            System.out.println("You died!");
        }
    }

    public DamageBundle calculateDamage(Attack attack) {
        int additive = attack.baseDamage();
        int multiplicative = 1;

        for (Item item: items) {
            if (item.element() == attack.element()) {
                if (item.isAdditive()) {
                    additive += item.bonus();
                } else {
                    multiplicative *= item.bonus();
                }
            }
        }


        return new DamageBundle(additive * multiplicative, attack.element());
    } 


    public void fight(List<Enemy> enemies) {
        for (Enemy e: enemies) {
            while (e.isAlive() && isAlive()) {
                Attack attack = (Attack) InputHandler.choice(attacks.toArray());
                e.takeDamage(calculateDamage(attack));

                if (e.isAlive()) {
                    takeDamage(e.attack());
                }
            }
            
        }

    }
    
    
    
}