package pack.structure.types;

import pack.structure.specialty.Mage;

public final class Warlock extends Mage {
    protected int spell;

    {spell=0;}

    public Warlock() {
        super();
        hp*=3/4;
    }

    public Warlock(String name, int hp, int attack, int mana) {
        super(name, hp, attack, mana);
        setAttack(attack);
    }

    @Override
    public String toString() {
        return String.format("Warlock[%s, spell=%s]", super.toString(), spell);
    }

    @Override
    public int attack() {
        if (spell==4)
        {
            return (super.attack()+mana)*10;
        }
        else
        {
            spell++;
            mana--;
            return 0;
        }
    }
}
