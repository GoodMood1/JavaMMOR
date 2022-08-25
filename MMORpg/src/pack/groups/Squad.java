package pack.groups;

import pack.structure.base.Hero;
import pack.structure.types.*;

import java.util.Random;

import static pack.structure.base.HeroesTypes.*;

public class Squad {
    private Hero[] heroes;
    private int size;
    private Random rd;

    public Squad(int size) {
        heroes = new Hero[size];
        this.size = size;
        rd = new Random();
        fill();
    }

    private final void fill() {
        Hero hero;
        for (int i = 0; i < heroes.length; i++) {
            hero = switch (rd.nextInt(MAX_VALUE)) {
                case PALADIN -> new Paladin(Hero.Names.values()[new Random().nextInt(26)].name(), 130, 15, 30);
                case BERSERKER -> new Berserker(Hero.Names.values()[new Random().nextInt(26)].name(), 110, 15, 5);
                case HUNTER -> new Hunter(Hero.Names.values()[new Random().nextInt(26)].name(), 90, 25, 5);
                case ELF -> new Elf(Hero.Names.values()[new Random().nextInt(26)].name(), 100, 20, 8);
                case WIZARD -> new Wizard(Hero.Names.values()[new Random().nextInt(26)].name(), 100, 15, 18);
                case WARLOCK -> new Warlock(Hero.Names.values()[new Random().nextInt(26)].name(), 100, 20, 15);
                default -> throw new RuntimeException("default value");
            };
            heroes[i] = hero;
        }
    }

    public int Size() { return size; }

    public Hero getByID(int ID) { return heroes[ID]; }

    public boolean aliveContains() {
        for (Hero hero : heroes) {
            if (hero.isAlive())
                return true;
        }
        return false;
    }

    public Hero randomHero() {
        Hero hero;
        do {
            hero = heroes[rd.nextInt(heroes.length)];
        } while (!hero.isAlive());
        return hero;
    }

    @Override
    public String toString() {
        // TODO:
        String str = "Squad{\n";
        for (int i=0; i<size; i++) {str+=heroes[i].toString()+"\n";}
        str+="}";
        return str;
    }
}
