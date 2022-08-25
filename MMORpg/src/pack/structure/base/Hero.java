package pack.structure.base;

import java.util.Objects;
import java.util.Random;

public abstract class Hero {
    public enum Names {
        Askil, Baglar, Ciamina, Daria, Eugene,
        Farat, Gafa, H, Irma, Jabir, Kanski,
        Lamiela, Mafarida, Nikolay, Oz, Pir,
        Quara, Rago, Stif, Tiria, Urana, Vladimir,
        Wado, Xandra, Ymir, Zip
    }
    protected final Random rd;
    protected String name;
    protected int hp;
    protected int attack;
    protected boolean alive;

    {
        alive = true;
        rd = new Random();
    }

    public Hero()
    {
        Names[] allNames = Names.values();
        name = Names.values()[rd.nextInt(Names.values().length)].name();
        hp = rd.nextInt(75, 125);
        attack = rd.nextInt(1, 10);
    }
    public Hero(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }
    public final void autoSetName() { this.name = Names.values()[rd.nextInt(Names.values().length)].name(); }

    public final int getHp() {
        return hp;
    }

    public final void setHp(int hp) {
        this.hp = hp;
    }

    public final int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public final boolean isAlive() {
        return alive;
    }

    public final void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        String name = this.name+",";
        /*for (int i = 0; i < 11; i++)
        {
            if (name.length()<i) name+=" ";
            else if (i==name.length()&&name.charAt(i-1)!=',') name+=",";
        }*/
        return String.format("name=%-11shp=%s,\tattack=%s,\talive=%s",
                name, hp, attack, alive);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero)) return false;
        Hero hero = (Hero) o;
        return getHp() == hero.getHp() && getAttack() == hero.getAttack() && isAlive() == hero.isAlive() && getName().equals(hero.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHp(), getAttack(), isAlive());
    }

    public void takeDamage(int attack) {
        if (!alive) return;
        hp -= attack;
        if (hp <= 0) {
            hp = 0;
            alive = false;
        }
    }

    public int attack() {
        return rd.nextInt(attack-3, attack+3);
    }
}
