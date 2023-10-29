package CalculComplexite;

import Amis.IAmis;

public class CreationMonde {

    public static void creerMonde(IAmis monde, int n) {
        for (int i = 0; i < n; ++i)
            monde.add(i);
    }

    public static void creerAmities(int n, int[][] amis) {
        for (int i = 0; i < n; ++i) {
            int a = (int) Math.floor(Math.random() * (n));
            int b = (int) Math.floor(Math.random() * (n));
            int[] couple = {a, b};
            amis[i] = couple;
        }
    }

    public static void union(IAmis monde, int n, int[][] amis) {
        CreationMonde.creerAmities(n, amis);
        for (int i = 0; i < n; i++) {
            monde.union(amis[i][0], amis[i][1]);
        }
    }
}
