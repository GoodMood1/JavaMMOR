package pack.structure.specialty;

import pack.structure.base.Hero;

import java.util.Objects;

public abstract class Mage extends Hero {
    protected int mana;

    public Mage(){
        super();
        mana = rd.nextInt(10, 22);
    }

    public Mage(String name, int hp, int attack, int mana) {
        super(name, hp, attack);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public String toString() {
        return String.format("%s, mana=%s",
                super.toString(), mana);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mage)) return false;
        if (!super.equals(o)) return false;
        Mage mage = (Mage) o;
        return getMana() == mage.getMana();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMana());
    }

    @Override
    public int attack() {
        if (mana>0)
        {
            super.setAttack(attack*3/2);
            mana-=rd.nextInt(1,3);
        }
        else
        {
            mana+=rd.nextInt(0,4);
            return 0;
        }
        return super.attack();
    }
}