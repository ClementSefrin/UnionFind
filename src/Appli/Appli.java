package Appli;

import Amis.AmisArrayList;
import Amis.AmisHashMap;
import Amis.UnionFind;
import CalculComplexite.ComplexiteArrayList;
import CalculComplexite.ComplexiteHashMap;
import CalculComplexite.ComplexiteUnionFind;
import CalculComplexite.CreationMonde;

public class Appli {

    private static final int MAX = 100_000;
    private static final int PAS = 10_000;

    public static void main(String[] args) throws Exception {
        comparaisonComplexite();
    }

    public static void comparaisonComplexite() throws Exception {
        AmisHashMap<Integer> a;
        AmisArrayList<Integer> b;
        UnionFind<Integer> c;


        System.out.println("Union");
        for (int i = PAS; i <= MAX; i += PAS) {
            int[][] amis = new int[i][2];
            CreationMonde.creerAmities(i, amis);

            a = new AmisHashMap<>();
            CreationMonde.creerMonde(a, i);
            double cUnion1 = ComplexiteHashMap.complexiteUnion(a, i, amis);

            b = new AmisArrayList<>();
            CreationMonde.creerMonde(b, i);
            double cUnion2 = ComplexiteArrayList.complexiteUnion(b, i, amis);

            c = new UnionFind<>();
            CreationMonde.creerMonde(c, i);
            double cUnion3 = ComplexiteUnionFind.complexiteUnion(c, i, amis);

            System.out.println(i + "\t" + cUnion1 + "\t" + cUnion2 + "\t" + cUnion3);
        }
        System.out.println();

        System.out.println("Find");
        for (int i = PAS; i <= MAX; i += PAS) {
            int[][] amis = new int[i][2];
            CreationMonde.creerAmities(i, amis);

            a = new AmisHashMap<>();
            CreationMonde.creerMonde(a, i);
            CreationMonde.union(a, i, amis);
            double cFind1 = ComplexiteHashMap.complexiteFind(a, i);

            b = new AmisArrayList<>();
            CreationMonde.creerMonde(b, i);
            CreationMonde.union(b, i, amis);
            double cFind2 = ComplexiteArrayList.complexiteFind(b, i);

            c = new UnionFind<>();
            CreationMonde.creerMonde(c, i);
            CreationMonde.union(c, i, amis);
            double cFind3 = ComplexiteUnionFind.complexiteFind(c, i);

            System.out.println(i + "\t" + cFind1 + "\t" + cFind2 + "\t" + cFind3);
        }
        System.out.println();


        System.out.println("Isoler");
        for (int i = PAS; i <= MAX; i += PAS) {
            int[][] amis = new int[i][2];
            CreationMonde.creerAmities(i, amis);

            a = new AmisHashMap<>();
            CreationMonde.creerMonde(a, i);
            CreationMonde.union(a, i, amis);
            double cIsoler1 = ComplexiteHashMap.complexiteIsoler(a, i);

            b = new AmisArrayList<>();
            CreationMonde.creerMonde(b, i);
            CreationMonde.union(b, i, amis);
            double cIsoler2 = ComplexiteArrayList.complexiteIsoler(b, i);


            c = new UnionFind<>();
            CreationMonde.creerMonde(c, i);
            CreationMonde.union(c, i, amis);
            double cIsoler3 = ComplexiteUnionFind.complexiteIsoler(c, i);


            System.out.println(i + "\t" + cIsoler1 + "\t" + cIsoler2 + "\t" + cIsoler3);
        }
        System.out.println();
    }
}
