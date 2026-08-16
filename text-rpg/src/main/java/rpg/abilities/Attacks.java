package rpg.abilities;

public class Attacks {
    private Attacks() {}

    public static final Attack FIREBALL = new Attack("Fireball", 40, Element.FIRE);
    public static final Attack AIRCUTTER = new Attack("Air Cutter", 7, Element.AIR);
    public static final Attack EARTHRUPTURE = new Attack("Earthen Rupture", 8, Element.EARTH);
    public static final Attack WATERBLADE = new Attack("Water Blade", 6, Element.WATER);
    
    
    public static final Attack STAB = new Attack("STAB", 6, Element.PIERCING);
    public static final Attack SLASH = new Attack("SLASH", 4, Element.SLASHING);

    public static final Attack HEAL = new Attack("HEAL", -10, Element.HEAL);
}
