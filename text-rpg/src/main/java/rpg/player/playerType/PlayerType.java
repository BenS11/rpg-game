package rpg.player.playerType;

import java.util.ArrayList;

import rpg.abilities.Attack;

public abstract class PlayerType {
    
    protected ArrayList<Attack> typeAttacks;
    protected int baseHealth;


    public abstract String description();
}
