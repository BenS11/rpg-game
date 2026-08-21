package rpg.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rpg.abilities.Attack;
import rpg.abilities.DamageBundle;
import rpg.items.Item;
import rpg.npcs.Foes.Enemy;
import rpg.npcs.Shops.Shop;
import rpg.player.playerTemplates.Barbarian;
import rpg.player.playerTemplates.Debug;
import rpg.player.playerTemplates.PlayerTemplate;
import rpg.player.playerTemplates.Wizard;
import rpg.utility.InputHandler;
import rpg.utility.OutputHandler;

public final class Player { 

    private List<Item> items = new ArrayList<>();
    private List<Attack> attacks = new ArrayList<>();
    private final List<Attack> activeAttacks = Arrays.asList(new Attack[5]);
    
    private final int health;
    private int healthRemaining;

    private int treasure;
    
    public boolean bossAlive = true;

    public Player() {
        PlayerTemplate basePlayerType = InputHandler.choice(new Barbarian(), new Wizard(), new Debug());

        health = basePlayerType.hpMax();
        treasure = basePlayerType.treasure();
        healthRemaining = health;

        withAttacks(basePlayerType.attacks());

        // selectActiveAttacks();
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
        
        if (attacks.isEmpty()) {
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

        while (activeAttacks.size() < 5) {

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

    public void shopAt(Shop shop) {
        boolean hadItems = shop.hasItems();
        if (!shop.visited() && hadItems) OutputHandler.println("Shopkeeper: Welcome to my shop!");
        
        while (shop.hasItems()) {
            OutputHandler.println("This is what I have:");
            shop.displayInventory();
            OutputHandler.println("Or type 4 to finish");
            int num = InputHandler.playerNum(1, 4);

            if (num == 4) break;

            if (shop.canBuy(num - 1, treasure)) {
                Item i = shop.buy(num - 1);
                treasure -= i.value();
                items.add(i);
            } else {
                OutputHandler.println("You do not have enough treasure to buy this ):");
            }

        }
        if (!shop.visited() || hadItems) {
            OutputHandler.println("Thank you for shopping!");
            OutputHandler.println("Please come again soon");
        }

        shop.visit();
    }
    
    
    
}