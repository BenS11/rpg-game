package rpg.npcs.Foes;

import rpg.abilities.Attack;
import rpg.abilities.Element;

public class EnemyAttacks {
    
    private EnemyAttacks() {}

        public static final Attack SMALL_SLASH = new Attack("Small Slash", 2, Element.SLASHING);
        public static final Attack LARGE_SLASH =  new Attack("large slash", 3, Element.SLASHING);
        public static final Attack SLAM =  new Attack("slam", 4, Element.MELEE);
        public static final Attack FIREBALL = new Attack("fireball", 7, Element.FIRE);
}
