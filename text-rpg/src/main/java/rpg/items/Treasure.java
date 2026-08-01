package rpg.items;

import rpg.utility.RandomUtil;

public class Treasure {

    public static final int SMALL = 1;
    public static final int MED = 5;
    public static final int LARGE = 10;
    public static final int BOSS_REWARD = 25;

    private Treasure() {}

    public static int randomTreasure() {
        double chance = RandomUtil.randomDouble();

        if (chance < 0.4) {
            return 0;
        } else if (chance < 0.7) { 
            return SMALL;
        } else if (chance < 0.9) {
            return MED;
        } else {
            return LARGE;
        }
    }
    
}
