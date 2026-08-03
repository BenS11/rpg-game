package rpg.player.playerTemplates;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import rpg.abilities.Attack;
import rpg.abilities.Attacks;
import rpg.abilities.Element;

public class Wizard extends PlayerTemplate {

    public Wizard() {
        this.hpMax = 10;
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
