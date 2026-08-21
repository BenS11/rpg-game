package rpg.player.playerTemplates;

import java.util.ArrayList;
import java.util.List;

import rpg.abilities.Attack;

public abstract class PlayerTemplate {
    
    protected List<Attack> typeAttacks = new ArrayList<>();
    protected int hpMax;
    protected int startingTreasure = 0;


    public int hpMax() {
        return hpMax;
    }

    public abstract String description();

    public List<Attack> attacks() {
        return typeAttacks;
    }

    public int treasure() {
        return startingTreasure;
    };
}
