package rpg.player.playerTemplates;

import rpg.abilities.Attacks;

public class Wizard extends PlayerTemplate {

    public Wizard() {
        this.hpMax = 10;
        this.startingTreasure = 3;
        typeAttacks.add(Attacks.FIREBALL);
        typeAttacks.add(Attacks.AIRCUTTER);
        typeAttacks.add(Attacks.WATERBLADE);
        typeAttacks.add(Attacks.EARTHRUPTURE);
    }


    @Override
    public String description() {
        return "A powerful but squishy magic user";
    }
    
    @Override
    public String toString() {
        return "Wizard";
    }
}
