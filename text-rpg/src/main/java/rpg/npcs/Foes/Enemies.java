package rpg.npcs.Foes;

import java.util.List;

import rpg.abilities.Element;

public class Enemies {
    
    private Enemies() {}

    public static Enemy getSmallGoblin() {
        return new Enemy(8)
            .withName("Gobling")
            .withAttacks(List.of(EnemyAttacks.SMALL_SLASH))
            .withWeaknesses(List.of(Element.EARTH, Element.AIR));
    }

    public static Enemy getMediumGoblin() {
        return new Enemy(14)
            .withName("Goblin Soldier")
            .withAttacks(List.of(EnemyAttacks.LARGE_SLASH, EnemyAttacks.SLAM))
            .withWeaknesses(List.of(Element.WATER, Element.FIRE));
    }

    public static Enemy getLargeGoblin() {
        return new Enemy(25)
            .withName("Goblin Brute")
            .withAttacks(List.of(EnemyAttacks.LARGE_SLASH, EnemyAttacks.SLAM))
            .withWeaknesses(List.of(Element.EARTH, Element.PIERCING))
            .withStrengths(List.of(Element.FIRE));
    }

    public static Enemy getBoss() {
        return new Enemy(50)
            .withName("Goblin Chief")
            .withAttacks(List.of(EnemyAttacks.LARGE_SLASH, EnemyAttacks.SLAM, EnemyAttacks.SMALL_SLASH)) 
            .withWeaknesses(List.of(Element.FIRE))
            .withStrengths(List.of(Element.EARTH, Element.AIR, Element.WATER));
    }


}
