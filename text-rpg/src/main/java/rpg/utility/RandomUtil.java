package rpg.utility;

import java.util.Random;

public class RandomUtil {
    private RandomUtil() {}

    private static Random rand = new Random(16l);

    /**
     * @return a random double between 0 and 1
     */
    public static double smallRandom() {
        return rand.nextDouble(0.0, 1.0);
    }

    public static double randomDouble() {
        return rand.nextDouble();
    }

    public static boolean randomBoolean() {
        return rand.nextBoolean();
    }
}
