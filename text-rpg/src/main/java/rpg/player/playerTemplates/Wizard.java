package rpg.player.playerTemplates;

import java.util.ArrayList;

import rpg.abilities.Attack;
import rpg.abilities.Attacks;
import rpg.abilities.Element;

public class Wizard extends PlayerTemplate {

    public Wizard() {
        this.typeAttacks = new ArrayList<>();
        this.hpMax = 10;
        typeAttacks.add(Attacks.FIREBALL);
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
