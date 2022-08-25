package pack.structure.specialty;

import pack.structure.base.Hero;

import java.util.Objects;

public abstract class Archer extends Hero {
    protected int arrowCount;
    protected int atkBoost;
    public Archer(){
        super();
        arrowCount = rd.nextInt(4, 10);
        atkBoost = attack * 3;
    }

    public Archer(String name, int hp, int attack, int arrowCount) {
        super(name, hp, attack);
        this.arrowCount = arrowCount;
        atkBoost = attack * 3;
    }

    public void setArrowCount(int arrowCount) {
        this.arrowCount = arrowCount;
    }

    public int getArrowCount() {
        return arrowCount;
    }

    @Override
    public String toString() {
        return String.format("%s,\tarrows=%s",
                super.toString(), arrowCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Archer)) return false;
        if (!super.equals(o)) return false;
        Archer archer = (Archer) o;
        return getArrowCount() == archer.getArrowCount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getArrowCount());
    }

    @Override
    public int attack() {
        if (arrowCount>0){
            super.setAttack(atkBoost);
            arrowCount--;
        }else{
            super.setAttack(0);
        }
        return super.attack();
    }
}
