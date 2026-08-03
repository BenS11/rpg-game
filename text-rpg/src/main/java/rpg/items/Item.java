
package rpg.items;

import java.util.ArrayList;
import java.util.Comparator;

import rpg.abilities.Element;

public class Item {
    
    public static final Comparator<Item> comparator = Comparator.comparing(Item::isMultiplicative).thenComparing(Item::bonus);

    private double bonus = 1.0;
    private Element element = Element.NONE;
    private boolean multiplicative = false;


    public Item() {

    }

    public Item withElement(Element e) {
        this.element = e;
        return this;
    }

    public Item withBonus(double bonus) {
        this.bonus = bonus;
        return this;
    }

    public Item withMultiplicative(boolean mult) {
        multiplicative = mult;
        return this;
    }

    public boolean isMultiplicative() {
        return multiplicative;
    }

    public boolean isAdditive() {
        return !multiplicative;
    }

    public Element element() {
        return element;
    }

    public double bonus() {
        return bonus;
    }

}