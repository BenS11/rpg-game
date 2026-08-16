package rpg.npcs;

import rpg.abilities.Attack;
import rpg.abilities.Element;

public class EnemyAttacks {
    
    private EnemyAttacks() {}


    public static Attack smallSlash() {
        return new Attack("Small Slash", 2, Element.SLASHING);
    }

    public static Attack largeSlash() {
        return new Attack("large slash", 3, Element.SLASHING);
    }

    public static Attack slam() {
        return new Attack("slam", 4, Element.MELEE);
    }
}
