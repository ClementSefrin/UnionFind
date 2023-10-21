package Amis;

import Amis.NullElementException;
import Amis.Observer;

import java.util.HashMap;

public class AmisHashMap<T extends Comparable<T>> implements IAmis<T> {
    private HashMap<T, T> mondeParfait;
    private Observer obs;


    public AmisHashMap() {
        mondeParfait = new HashMap<>();
        obs = new Observer();
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
        obs.countAffect();
        if (r == null)
            return null;
        while (r.compareTo(mondeParfait.get(r)) != 0) {
            r = mondeParfait.get(r);
            obs.countAffect();
        }
        return r;
    }

    public void union(T v1, T v2) {
        try {
            T r1, r2;
            r1 = find(v1);
            obs.countAffect();
            r2 = find(v2);
            obs.countAffect();
            if (r1 == null && r2 == null) {
                mondeParfait.put(v1, v1);
                obs.countAffect();
                mondeParfait.put(v2, v1);
                obs.countAffect();
            } else if (r1 == null) {
                mondeParfait.put(v1, r2);
                obs.countAffect();
            } else if (r2 == null) {
                mondeParfait.put(v2, r1);
                obs.countAffect();
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
        obs.countAffect();
        if (r == null)
            return;
        T temp;
        mondeParfait.put(v, null);

        boolean repTrouve = true;
        if (r.compareTo(v) == 0) {
            repTrouve = false;
            obs.countAffect();
        }

        for (T k : mondeParfait.keySet()) {
            temp = mondeParfait.get(k);
            if (temp != null && temp.compareTo(v) == 0) {
                if (!repTrouve) {
                    repTrouve = true;
                    obs.countAffect();
                    r = k;
                    obs.countAffect();
                }
                mondeParfait.put(k, r);
                obs.countAffect();
            }
        }
    }

    public Observer getObs() {
        return obs;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T k : mondeParfait.keySet())
            sb.append(k).append(" : ").append(mondeParfait.get(k)).append("\n");

        return sb.toString();
    }
}
