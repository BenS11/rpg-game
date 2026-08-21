package rpg.npcs.Foes;

import java.util.List;

import rpg.abilities.Element;

public class Enemies {
    
    private Enemies() {}

    public static Enemy getSmallEnemy() {
        return new Enemy(8)
            .withName("Gobling")
            .withAttacks(List.of(EnemyAttacks.smallSlash()))
            .withWeaknesses(List.of(Element.EARTH, Element.AIR));
    }

    public static Enemy getMediumEnemy() {
        return new Enemy(14)
            .withName("Goblin Soldier")
            .withAttacks(List.of(EnemyAttacks.largeSlash(), EnemyAttacks.slam()))
            .withWeaknesses(List.of(Element.WATER, Element.FIRE));
    }

    public static Enemy getLargeEnemy() {
        return new Enemy(25)
            .withName("Goblin Brute")
            .withAttacks(List.of(EnemyAttacks.largeSlash(), EnemyAttacks.slam()))
            .withWeaknesses(List.of(Element.EARTH, Element.PIERCING))
            .withStrengths(List.of(Element.FIRE));
    }

    public static Enemy getBoss() {
        return new Enemy(50)
            .withName("Goblin Chief")
            .withAttacks(List.of(EnemyAttacks.largeSlash(), EnemyAttacks.slam(), EnemyAttacks.smallSlash())) 
            .withWeaknesses(List.of(Element.FIRE))
            .withStrengths(List.of(Element.EARTH, Element.AIR, Element.WATER));
    }


}
