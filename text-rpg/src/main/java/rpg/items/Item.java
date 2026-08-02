
package rpg.items;

import java.util.ArrayList;
import java.util.Comparator;

public class Item {
    
    public static final Comparator<Item> comparator = Comparator.comparing(Item::isMultiplicative).thenComparing(Item::sumBonus);

    private double magicBonus = 1.0;
    private double physicalBonus = 1.0;
    private boolean multiplicative = false;


    public Item() {

    }

    public Item withMagicBonus(double bonus) {
        magicBonus = bonus;
        return this;
    }

    public Item withPhysicalBonus(double bonus) {
        physicalBonus = bonus;
        return this;
    }

    public Item withMultiplicative(boolean mult) {
        multiplicative = mult;
        return this;
    }

    public boolean isMultiplicative() {
        return multiplicative;
    }

    private double sumBonus() {
        return physicalBonus + magicBonus;
    }

    public double magicBonus() {
        return magicBonus;
    }


}