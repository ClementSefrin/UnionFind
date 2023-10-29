package Appli;

import Amis.AmisArrayList;
import Amis.AmisHashMap;
import CalculComplexite.Complexite;
import CalculComplexite.CreationMonde;

public class Appli {

    private static final int MAX = 30_000;
    private static final int PAS = 1_000;

    public static void main(String[] args) throws Exception {
        comparaisonComplexite();
    }

    public static void comparaisonComplexite() throws Exception {
        AmisHashMap<Integer> a;
        AmisArrayList<Integer> b;

        System.out.println("n" + "\t" + "HashMap" + "\t" + "ArrayList");
        for (int i = PAS; i <= MAX; i += PAS) {
            int[][] amis = new int[i][2];
            CreationMonde.creerAmities(i, amis);

            a = new AmisHashMap<>();
            CreationMonde.creerMonde(a, i);
            double cUnion1 = Complexite.complexiteUnion(a, i, amis);

            b = new AmisArrayList<>();
            CreationMonde.creerMonde(b, i);
            double cUnion2 = Complexite.complexiteUnion(b, i, amis);

            System.out.println(i + "\t" + cUnion1 + "\t" + cUnion2);
        }
        System.out.println();


        System.out.println("n" + "\t" + "HashMap" + "\t" + "ArrayList");
        for (int i = PAS; i <= MAX; i += PAS) {
            int[][] amis = new int[i][2];
            CreationMonde.creerAmities(i, amis);

            a = new AmisHashMap<>();
            CreationMonde.creerMonde(a, i);
            CreationMonde.union(a, i, amis);
            double cFind1 = Complexite.complexiteFind(a, i);

            b = new AmisArrayList<>();
            CreationMonde.creerMonde(b, i);
            CreationMonde.union(b, i, amis);
            double cFind2 = Complexite.complexiteFind(b, i);

            System.out.println(i + "\t" + cFind1 + "\t" + cFind2);
        }
        System.out.println();

        System.out.println("n" + "\t" + "HashMap" + "\t" + "ArrayList");
        for (int i = PAS; i <= MAX; i += PAS) {
            int[][] amis = new int[i][2];
            CreationMonde.creerAmities(i, amis);

            a = new AmisHashMap<>();
            CreationMonde.creerMonde(a, i);
            CreationMonde.union(a, i, amis);
            double cIsoler1 = Complexite.complexiteIsoler(a, i);

            b = new AmisArrayList<>();
            CreationMonde.creerMonde(b, i);
            CreationMonde.union(b, i, amis);
            double cIsoler2 = Complexite.complexiteIsoler(b, i);

            System.out.println(i + "\t" + cIsoler1 + "\t" + cIsoler2);
        }
        System.out.println();
    }
}
