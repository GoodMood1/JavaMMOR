package pack.structure.types;

import pack.structure.specialty.Mage;

public final class Wizard extends Mage {

    public Wizard() {
        super();
    }

    public Wizard(String name, int hp, int attack, int mana) {
        super(name, hp, attack, mana);
        setAttack(attack);
    }

    @Override
    public String toString() {
        return String.format("Wizard[%s]", super.toString());
    }

    @Override
    public int attack() {
        return super.attack()*(mana/10+1);
    }
}
