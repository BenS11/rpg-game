package rpg.player.playerType;

import java.util.ArrayList;

import rpg.abilities.Attack;
import rpg.abilities.Attacks;
import rpg.abilities.Element;

public class Wizard extends PlayerType {

    public Wizard() {
        this.typeAttacks = new ArrayList<>();
        typeAttacks.add(Attacks.FIREBALL);
    }


    @Override
    public String description() {
        return "A powerful but squishy magic user";
    }
    
}
