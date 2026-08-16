package rpg.player.playerTemplates;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import rpg.abilities.Attack;

public abstract class PlayerTemplate {
    
    protected List<Attack> typeAttacks = new ArrayList<>();
    protected int hpMax;

    public int hpMax() {
        return hpMax;
    }

    public abstract String description();

    public List<Attack> attacks() {
        return typeAttacks;
    };
}
