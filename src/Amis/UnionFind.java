package Amis;

import java.util.ArrayList;
import java.util.List;

public class UnionFind<T extends Comparable<T>> implements IAmis<T> {
    private List<T> elements; // Liste des �l�ments
    private List<T> parent;   // Liste des parents de chaque �l�ment
    private List<Integer> size; // Liste des tailles des composantes

    public UnionFind() {
        elements = new ArrayList<>();
        parent = new ArrayList<>();
        size = new ArrayList<>();
    }

    // Ajoute un nouvel �l�ment � la structure Union-Find
    public void add(T element) {
        elements.add(element);
        parent.add(element); // Chaque �l�ment est initialement son propre parent
        size.add(1); // Chaque �l�ment est initialement dans une composante de taille 1
    }

    // Recherche le repr�sentant (la racine) de la composante � laquelle l'�l�ment x appartient
    public T find(T v) {
        int index = elements.indexOf(v);

        // Compression de chemin : mise � jour des parents sur le chemin pour optimiser les futures recherches
        if (!v.equals(parent.get(index))) {
            parent.set(index, find(parent.get(index)));
        }

        return parent.get(index);
    }

    // Effectue l'union de deux composantes contenant les �l�ments x et y
    public void union(T v1, T v2) {
        int rep1 = elements.indexOf(find(v1)); // Repr�sentant de la composante contenant x
        int rep2 = elements.indexOf(find(v2)); // Repr�sentant de la composante contenant y

        if (rep1 == rep2) {
            return; // Les �l�ments sont d�j� dans la m�me composante.
        }

        // Heuristique de poids : attache la plus petite composante � la plus grande
        if (size.get(rep1) > size.get(rep2)) {
            parent.set(rep2, elements.get(rep1));
            size.set(rep1, size.get(rep1) + size.get(rep2));
        } else {
            parent.set(rep1, elements.get(rep2));
            size.set(rep2, size.get(rep2) + size.get(rep1));
        }
    }

    // Isole l'�l�ment x en le rendant parent de lui-m�me
    public void isoler(T x) {
        int index = elements.indexOf(x);
        int rootX = elements.indexOf(find(x));

        size.set(rootX, size.get(rootX) - 1); // R�duire la taille de la composante
        parent.set(index, elements.get(index)); // Isoler x en le rendant parent de lui-m�me
    }

    // Affiche l'�tat actuel de la structure Union-Find
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Elements: ");
        for (T element : elements) {
            sb.append(element).append(" ");
        }
        sb.append("\nParents: ");
        for (T p : parent) {
            sb.append(p).append(" ");
        }
        sb.append("\nSizes: ");
        for (Integer s : size) {
            sb.append(s).append(" ");
        }
        return sb.toString();
    }
}
