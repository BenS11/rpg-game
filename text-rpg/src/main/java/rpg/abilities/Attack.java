package rpg.abilities;

public record Attack(String name, int baseDamage, Element element) {

    @Override
    public String toString() {
        return name + ": " + baseDamage + " " + element.name() + " damage";
    }
}