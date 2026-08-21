package rpg.player.playerTemplates;

import rpg.abilities.Attacks;

public class Barbarian extends PlayerTemplate {


    public Barbarian() {
        this.hpMax = 20;
        this.startingTreasure = 3;
        typeAttacks.add(Attacks.STAB);
        typeAttacks.add(Attacks.SLASH);
    }


    @Override
    public String description() {
        return "Low damage output but high durability fighter";
    }

    @Override
    public String toString() {
        return "Barbarian";
    }
    
}
