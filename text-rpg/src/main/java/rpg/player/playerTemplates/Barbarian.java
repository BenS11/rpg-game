package rpg.player.playerTemplates;

import java.util.ArrayList;

import rpg.abilities.Attack;
import rpg.abilities.Attacks;
import rpg.abilities.Element;

public class Barbarian extends PlayerTemplate {


    public Barbarian() {
        this.hpMax = 20;
        typeAttacks.add(Attacks.STAB);
        typeAttacks.add(Attacks.SLASH);
    }


    @Override
    public String description() {
        return "Low damage output but high durability fighter";
    }

    @Override
    public String toString() {
        return "Barbarian";
    }
    
}
