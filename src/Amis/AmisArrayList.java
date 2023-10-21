package Amis;

import java.util.ArrayList;

public class AmisArrayList<T extends Comparable<T>> implements IAmis<T> {


    private ArrayList<T> elements;
    private ArrayList<T> representants;

    public AmisArrayList() {
        elements = new ArrayList<>();
        representants = new ArrayList<>();
    }

    public T getElement(T v) {
        return representants.get(getIndexElement(v));
    }

    public int getIndexElement(T v) {
        return elements.indexOf(v);
    }

    @Override
    public void add(T v) {
        elements.add(v);
        representants.add(null);
    }

    @Override
    public T find(T v) throws NullElementException {
        int idx = getIndexElement(v);
        if (idx == -1) throw new NullElementException();
        T r = representants.get(idx);
        if (r == null)
            return null;
        while (r.compareTo(elements.get(idx)) != 0) {
            idx = getIndexElement(r);
            r = representants.get(idx);
        }
        return r;
    }

    @Override
    public void union(T v1, T v2) {
        try {
            T r1, r2;
            int idx1 = getIndexElement(v1), idx2 = getIndexElement(v2);
            r1 = find(v1);
            r2 = find(v2);
            if (r1 == null && r2 == null) {
                representants.set(idx1, v1);
                representants.set(idx2, v1);
            } else if (r1 == null) {
                representants.set(idx1, r2);
            } else if (r2 == null) {
                representants.set(idx2, r1);
            } else if (r1.compareTo(r2) == 0) {
                return;
            } else {
                idx2 = getIndexElement(r2);
                representants.set(idx2, r1);
            }

        } catch (NullElementException e) {
            StringBuilder sb = new StringBuilder().append(v1).append(" ou ").append(v2).append(" n'existe pas.");
            System.out.println(sb);
        }
    }

    @Override
    public void isoler(T v) {
        int idx = getIndexElement(v);
        if (idx == -1) return;
        T r = representants.get(idx);
        if (r == null) return;
        representants.set(idx, null);

        boolean repTrouve = true;
        if (r.compareTo(v) == 0) {
            repTrouve = false;
        }

        T temp;
        for (int i = 0; i < elements.size(); i++) {
            temp = representants.get(i);
            if (temp != null && temp.compareTo(v) == 0) {
                if (!repTrouve) {
                    repTrouve = true;
                    r = elements.get(i);
                }
                representants.set(i, r);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < elements.size(); ++i) {
            sb.append(elements.get(i)).append(" : ").append(representants.get(i)).append("\n");
        }
        return sb.toString();
    }
}
