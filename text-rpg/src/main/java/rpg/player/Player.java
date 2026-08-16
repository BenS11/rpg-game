package rpg.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import rpg.player.playerTemplates.*;
import rpg.utility.InputHandler;
import rpg.utility.OutputHandler;
import rpg.utility.Tuple;
import rpg.abilities.Attack;
import rpg.abilities.DamageBundle;
import rpg.abilities.Element;
import rpg.items.Item;
import rpg.npcs.Enemy;

public class Player { 

    private List<Item> items = new ArrayList<>();
    private List<Attack> attacks = new ArrayList<>();
    private List<Attack> activeAttacks = Arrays.asList(new Attack[5]);
    
    private int health;
    private int healthRemaining;

    private int treasure;
    
    public boolean bossAlive = true;

    public Player() {
        PlayerTemplate basePlayerType = InputHandler.choice(new Barbarian(), new Wizard());

        health = basePlayerType.hpMax();
        healthRemaining = health;

        withAttacks(basePlayerType.attacks());

        selectActiveAttacks();
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

    public void selectActiveAttacks() {
        OutputHandler.println("Select active attacks:");
        
        if (attacks.size() == 0) {
            OutputHandler.println("No equipable attacks");
            return;
        }

        boolean cont = true;
        while (cont) {
            OutputHandler.printNumberedList(attacks);
            OutputHandler.println("Select an attack to equip");
            int num = InputHandler.playerNum(1, attacks.size());

            OutputHandler.printNumberedList(activeAttacks);
            OutputHandler.println("Select a slot to equip");
            int act = InputHandler.playerNum(1, 5);

            activeAttacks.set(act - 1, attacks.get(num));
            
            cont = InputHandler.playerYesNo("Continue?");
        }
    }

    public Player withAttacks(List<Attack> list) {
        attacks.addAll(list);

        int act = 0;
        for (int i = 0; i < activeAttacks.size(); i++) {
            if (activeAttacks.get(i) == null) {
                act = i;
                break;
            }
        }
        int i = 0;
        while (act < 5 && act < attacks.size()) {
            Attack potentialAttack = attacks.get(i);
            if (!activeAttacks.contains(potentialAttack)) {
                activeAttacks.set(act, potentialAttack);
                act++;
            } 
            i++;
        }
        

        return this;
    }

    public void takeDamage(DamageBundle attack) {

        healthRemaining -= attack.damage();
        OutputHandler.println("You took " + attack.damage() + " damage");
        if (isAlive()) {
            OutputHandler.println("You are now at " + healthRemaining + " hp");
        } else {
            OutputHandler.println("You died!");
        }
    }

    public DamageBundle dealDamage(Attack attack) {
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
                e.takeDamage(dealDamage(attack));
                
                if (e.isAlive()) {
                    OutputHandler.println(e.toString() + " attacks");
                    takeDamage(e.attack());
                }
            }
            
        }

    }
    
    
    
}