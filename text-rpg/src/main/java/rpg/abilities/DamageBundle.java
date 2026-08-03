package rpg.abilities;

public class DamageBundle {
    
    private Element e;
    private int damage;

    public DamageBundle(int damage, Element e) {
        this.e = e;
        this.damage = damage;
    }

    public Element element() {
        return e;
    }

    public int damage() {
        return damage;
    }

}
