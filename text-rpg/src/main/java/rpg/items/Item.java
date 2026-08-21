
package rpg.items;

import java.util.Comparator;

import rpg.abilities.Element;

public class Item {
    
    public static final Comparator<Item> comparator = Comparator.comparing(Item::isMultiplicative).thenComparing(Item::bonus);

    private double bonus = 1.0;
    private Element element = Element.NONE;
    private boolean multiplicative = false;
    private String name;
    private int value = 0;
    private boolean built = false;

    public Item() {

    }

    public Item withName(String s) {
        checkBuilt();
        this.name = s;
         return this;
    }

    public Item withElement(Element e) {
        checkBuilt();
        this.element = e;
        return this;
    }

    public Item withValue(int val) {
        checkBuilt();
        value = val;

        return this;
    } 

    public Item withBonus(double bonus) {
        checkBuilt();
        this.bonus = bonus;
        return this;
    }

    public Item withMultiplicative(boolean mult) {
        checkBuilt();
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

    public int value() {
        return value;
    }

    public String name() {
        return name;
    }

    public Item build() {
        checkBuilt();
        built = true;
        return this;
    }

    private void checkBuilt() {
        if (built) {
        throw new IllegalStateException("Item has already been built");
    }
    }

    @Override
    public String toString() {
        return name + ": " + value;
    }

}