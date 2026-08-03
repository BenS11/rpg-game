package rpg.npcs;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.management.RuntimeErrorException;

import rpg.abilities.Element;
import rpg.utility.RandomUtil;
import rpg.utility.Tuple;
import rpg.abilities.Attack;
import rpg.abilities.DamageBundle;

public class Enemy {
    private int health;
    private int damage;
    private String name = "Enemy";
    private EnumSet<Element> strengths = EnumSet.noneOf(Element.class);
    private EnumSet<Element> weaknesses = EnumSet.noneOf(Element.class);

    private ArrayList<Attack> attacks = new ArrayList<>();



    public Enemy(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    public Enemy withName(String name) {
        this.name = name;
        return this;
    }


    public Enemy withStrengths(List<Element> strengths) {
        this.strengths.addAll(strengths);
        return this;
    }

    public Enemy withWeaknesses(List<Element> weaknesses) {
        this.weaknesses.addAll(weaknesses);
        return this;
    }

    public Enemy withAttacks(List<Attack> attacks) {
        this.attacks.addAll(attacks);
        return this;
    }

    public Attack chooseAttack() {
        if (attacks.size() == 0) {
            throw new RuntimeException("No attacks in the enemies array");
        }
        return RandomUtil.randomChoice(attacks);
    }

    public DamageBundle attack() {
        Attack attack = chooseAttack();
        int damage = attack.baseDamage();

        if (strengths.contains(attack.element())) {
            damage *= 1.5;
        }

        return new DamageBundle(damage, attack.element());
    }

    public void takeDamage(DamageBundle attack) {
        int baseDamage = attack.damage();

        if (strengths.contains(attack.element())) {
            baseDamage /= 2;
        } 
        
        if (weaknesses.contains(attack.element())) {
            baseDamage *= 2;
        }

        health -= baseDamage;
        if (isAlive()) {
            System.out.println(name + " is now at " + health + " hp");
        } else {
            System.out.println("Defeated " + name + "!");
        }
    }


    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return name;
    }
    


}