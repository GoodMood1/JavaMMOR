package pack.structure.types;

import pack.structure.specialty.Archer;

public final class Hunter extends Archer {

    public Hunter() {
        super();
    }

    public Hunter(String name, int hp, int attack, int arrowCount) {
        super(name, hp, attack, arrowCount);
        setAttack(attack);
    }

    @Override
    public String toString() {
        return String.format("Hunter[%s]", super.toString());
    }

    @Override
    public int attack() {
        if (arrowCount==0)
        {
            arrowCount++;
            return 0;
        }
        return super.attack();
    }
}
