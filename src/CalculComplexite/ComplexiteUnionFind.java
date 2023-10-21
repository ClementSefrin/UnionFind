package CalculComplexite;

import Amis.UnionFind;

public class ComplexiteUnionFind {

    public static double complexiteUnion(UnionFind monde, int n, int[][] amis) {
        long d = System.nanoTime();
        for (int i = 0; i < n; i++) {
            monde.union(amis[i][0], amis[i][1]);
        }
        double t = (System.nanoTime() - d) / 1E9;
        return t;
    }

    public static double complexiteFind(UnionFind monde, int n) throws Exception {
        long d = System.nanoTime();
        for (int i = 0; i < n; i++) {
            monde.find(i);
        }
        double t = (System.nanoTime() - d) / 1E9;
        return t;
    }


    public static double complexiteIsoler(UnionFind monde, int n) {
        long d = System.nanoTime();
        for (int i = 0; i < n; i++) {
            monde.isoler(i);
        }
        double t = (System.nanoTime() - d) / 1E9;
        return t;
    }
}
