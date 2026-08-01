package rpg.player.playerTemplates;

import java.util.ArrayList;

import rpg.abilities.Attack;

public abstract class PlayerTemplate {
    
    protected ArrayList<Attack> typeAttacks;
    protected int hpMax;

    public abstract String description();
}
