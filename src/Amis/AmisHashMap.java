package Amis;

import java.util.HashMap;

public class AmisHashMap<T extends Comparable<T>> implements IAmis<T> {
    private HashMap<T, T> mondeParfait;

    public AmisHashMap() {
        mondeParfait = new HashMap<>();
    }

    public T getElement(T v) {
        return mondeParfait.get(v);
    }

    public void add(T v) {
        mondeParfait.put(v, null);
    }

    public T find(T v) throws NullElementException {
        if (!mondeParfait.containsKey(v)) throw new NullElementException();
        T r = mondeParfait.get(v);
        if (r == null)
            return null;
        while (r.compareTo(mondeParfait.get(r)) != 0) {
            r = mondeParfait.get(r);
        }
        return r;
    }

    public void union(T v1, T v2) {
        try {
            T r1, r2;
            r1 = find(v1);
            r2 = find(v2);
            if (r1 == null && r2 == null) {
                mondeParfait.put(v1, v1);
                mondeParfait.put(v2, v1);
            } else if (r1 == null) {
                mondeParfait.put(v1, r2);
            } else if (r2 == null) {
                mondeParfait.put(v2, r1);
            } else if (r1.compareTo(r2) == 0) {
                return;
            } else
                mondeParfait.put(r2, r1);
        } catch (NullElementException e) {
            StringBuilder sb = new StringBuilder().append(v1).append(" ou ").append(v2).append(" n'existe pas.");
            System.out.println(sb);
        }
    }

    public void isoler(T v) {
        T r = mondeParfait.get(v);
        if (r == null)
            return;
        T temp;
        mondeParfait.put(v, null);

        boolean repTrouve = true;
        if (r.compareTo(v) == 0) {
            repTrouve = false;
        }

        for (T k : mondeParfait.keySet()) {
            temp = mondeParfait.get(k);
            if (temp != null && temp.compareTo(v) == 0) {
                if (!repTrouve) {
                    repTrouve = true;
                    r = k;
                }
                mondeParfait.put(k, r);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T k : mondeParfait.keySet())
            sb.append(k).append(" : ").append(mondeParfait.get(k)).append("\n");

        return sb.toString();
    }
}
