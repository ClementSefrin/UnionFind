package CalculComplexite;

import Amis.IAmis;

public class Complexite {

    public static double complexiteUnion(IAmis monde, int n, int[][] amis) {
        double totalTime = 0;
        for (int i = 0; i < n; i++) {
            long d = System.nanoTime();
            monde.union(amis[i][0], amis[i][1]);
            totalTime += (System.nanoTime() - d) / 1E6;
        }
        return totalTime / n;
    }

    public static double complexiteFind(IAmis monde, int n) throws Exception {
        double totalTime = 0;
        for (int i = 0; i < n; i++) {
            long d = System.nanoTime();
            monde.find(i);
            totalTime += (System.nanoTime() - d) / 1E6;
        }

        return totalTime / n;
    }


    public static double complexiteIsoler(IAmis monde, int n) {
        double totalTime = 0;
        for (int i = 0; i < n; i++) {
            long d = System.nanoTime();
            monde.isoler(i);
            totalTime += (System.nanoTime() - d) / 1E6;
        }
        return totalTime / n;
    }
}
