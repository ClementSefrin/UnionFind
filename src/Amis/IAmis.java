package Amis;

public interface IAmis<T extends Comparable<T>> {

    void add(T v);

    T find(T v) throws NullElementException;

    void union(T v1, T v2);

    void isoler(T v);

}
