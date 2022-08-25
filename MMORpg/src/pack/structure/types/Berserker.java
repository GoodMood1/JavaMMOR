package pack.structure.types;

import pack.structure.specialty.Warrior;

public final class Berserker extends Warrior {
    private int fury;

    {fury=0;}

    public Berserker() {super();}

    public Berserker(String name, int hp, int attack, int armor) {
        super(name, hp, attack, armor);
        setAttack(attack);
    }

    @Override
    public void setAttack(int attack) {
        super.setAttack(attack * 2);
    }

    @Override
    public String toString() {
        return String.format("Berserker[%s, fury=%s]", super.toString(), fury);
    }

    @Override
    public int attack() {
        fury++;
        if (fury >= 4) {
            fury = 0;
            return super.attack() * 2;
        }
        return super.attack();
    }
}
