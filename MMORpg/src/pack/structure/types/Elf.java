package pack.structure.types;

import pack.structure.specialty.Archer;

public final class Elf extends Archer {

    public Elf() {
        super();
    }

    public Elf(String name, int hp, int attack, int arrowCount) {
        super(name, hp, attack, arrowCount);
        setAttack(attack);
    }

    @Override
    public String toString() {
        return String.format("Elf[%s]", super.toString());
    }

    @Override
    public int attack() {
        hp+=attack/4;
        return super.attack();
    }
}