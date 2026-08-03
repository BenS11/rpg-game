package rpg.abilities;

public record Attack(String name, int baseDamage, Element element) {
    public String toString() {
        return name + ": " + baseDamage + " " + element.name() + " damage";
    }
}