package rpg.npcs.Foes;

import rpg.game.ProgressTracker;

public class Boss extends Enemy {
    
    public Boss(int health) {
        super(health);
    }

    @Override
    public void onDeath() {
        ProgressTracker.bossAlive = false;
    }
}
