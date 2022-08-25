package pack.structure.specialty;

import pack.structure.base.Hero;

import java.util.Objects;

public abstract class Warrior extends Hero {
    protected int armor;

    public Warrior(){
        super();
        armor = rd.nextInt(8, 22);
    }
    public Warrior(String name, int hp, int attack, int armor) {
        super(name, hp, attack);
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public String toString() {
        return String.format("%s,\tarmor=%s",
                super.toString(), armor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Warrior)) return false;
        if (!super.equals(o)) return false;
        Warrior warrior = (Warrior) o;
        return getArmor() == warrior.getArmor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getArmor());
    }

    @Override
    public void takeDamage(int attack) {
        super.takeDamage(attack-(armor/2));
        armor -= 4;
    }
}
