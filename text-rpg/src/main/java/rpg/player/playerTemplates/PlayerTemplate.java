package rpg.player.playerTemplates;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import rpg.abilities.Attack;

public abstract class PlayerTemplate {
    
    protected ArrayList<Attack> typeAttacks;
    protected int hpMax;

    public int hpMax() {
        return hpMax;
    }

    public abstract String description();

    public List<Attack> attacks() {
        return typeAttacks;
    };
}
