package pack.groups;

import pack.structure.base.Hero;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class BattleField {
    private final Squad s1;
    private final Squad s2;

    public BattleField(int squadSize) {
        s1 = new Squad(squadSize);
        s2 = new Squad(squadSize);
    }

    private void sleep() {
        try {
            System.out.println("press Enter to continue");
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        }
        catch (Exception ignored) {
        }
    }

    public void fight() {
        System.out.println(s1);
        System.out.println(s2);
        sleep();

        while (s1.aliveContains() && s2.aliveContains()) {
            Random r = new Random();
            boolean flag = true;
            while (flag)
            {
                int rBuffer = r.nextInt(s1.Size());
                int rBufferBuffer = rBuffer;
                if (s1.getByID(rBuffer).isAlive()){
                    rBufferBuffer = rBuffer;
                    rBuffer = r.nextInt(s1.Size());
                    if (s2.getByID(rBuffer).isAlive()){
                        System.out.println(s2.getByID(rBuffer).getName() + " attacks " + s1.getByID(rBufferBuffer).getName());
                        int attack = s2.getByID(rBuffer).attack();
                        s1.getByID(rBufferBuffer).takeDamage(attack<0? 0 : attack);
                        flag=false;
                    }
                }
            }
            flag = true;
            //1
            System.out.println("Squad 2 attacks");
            System.out.println(s1);
            System.out.println(s2);
            sleep();
            if (s1.aliveContains() && s2.aliveContains()) {
                while (flag)
                {
                    int rBuffer = r.nextInt(s1.Size());
                    int rBufferBuffer = rBuffer;
                    if (s1.getByID(rBuffer).isAlive()){
                        rBufferBuffer = rBuffer;
                        rBuffer = r.nextInt(s1.Size());
                        if (s2.getByID(rBuffer).isAlive()){
                            System.out.println(s1.getByID(rBufferBuffer).getName() + " attacks " + s2.getByID(rBuffer).getName());
                            int attack = s1.getByID(rBufferBuffer).attack();
                            s2.getByID(rBuffer).takeDamage(attack<0? 0 : attack);
                            flag=false;
                        }
                    }
                }
                flag = true;
                //2
                System.out.println("Squad 1 attacks");
                System.out.println(s1);
                System.out.println(s2);
                sleep();
            }
        }
        if (s1.aliveContains()) {System.out.println("Squad 1 are winners:\n"+s1);}
        else if (s2.aliveContains()) {System.out.println("Squad 2 are winners:\n"+s2);}
        else {System.out.println("DRAW");}
    }
}
