package rpg.player.playerTemplates;

import rpg.abilities.Attacks;

public class Debug extends PlayerTemplate {


    public Debug() {
        this.hpMax = 1000;
        this.startingTreasure = 1000;
        typeAttacks.add(Attacks.DEBUG_ATTACK);
    }


    @Override
    public String description() {
        return "Debug";
    }

    @Override
    public String toString() {
        return "Debug";
    }
    
}