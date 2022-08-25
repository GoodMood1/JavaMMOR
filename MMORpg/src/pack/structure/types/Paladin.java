package pack.structure.types;

import pack.structure.specialty.Warrior;

public final class Paladin extends Warrior {
    public Paladin(){
        super();
        setArmor(armor);
    }
    public Paladin(String name, int hp, int attack, int armor) {
        super(name, hp, attack, armor);
        setArmor(armor);
    }

    @Override
    public void setArmor(int armor) {
        super.setArmor((int) (armor * 1.5));
    }

    @Override
    public String toString() {
        return String.format("Paladin[%s]", super.toString());
    }

    @Override
    public void takeDamage(int attack) {
        super.takeDamage(attack - armor*3/4);
    }
}
