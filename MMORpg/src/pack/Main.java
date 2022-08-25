package pack;

import pack.groups.BattleField;
import pack.structure.specialty.Warrior;
import pack.structure.types.Paladin;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*Random rd = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(rd.nextInt(MAX_VALUE));
        }*/
        System.out.print("Enter the size of squads - ");
        Reader inputStreamReader = new InputStreamReader(System.in);
        int squadSize = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        new BattleField(squadSize).fight();
        /*Warrior[] ps = new Paladin[10];
        for (int i = 0; i<10; i++)
        {
            ps[i] = new Paladin();
            System.out.println(ps[i]);
        }*/
    }
}
