package Test;

import Amis.AmisArrayList;
import Amis.NullElementException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAmisArrayList {
    public static void generate(AmisArrayList a) {
        for (int i = 0; i < 10; ++i)
            a.add(i);

        a.union(0, 1);
        a.union(1, 5);
        a.union(1, 3);
        a.union(3, 4);
        a.union(2, 7);
        a.union(2, 9);
        a.union(9, 8);
    }

    @Test
    void testAdd() {
        AmisArrayList<Integer> a = new AmisArrayList<Integer>();
        for (int i = 0; i < 500; ++i)
            a.add(i);
        for (int i = 0; i < 500; ++i)
            assertTrue(a.getElement(i) == null);
    }

    @Test
    void testUnion() {
        AmisArrayList<Integer> a = new AmisArrayList<Integer>();
        TestAmisArrayList.generate(a);
        try {
            assertTrue(a.find(0) == 0);
            assertTrue(a.find(1) == 0);
            assertTrue(a.find(3) == 0);
            assertTrue(a.find(4) == 0);
            assertTrue(a.find(5) == 0);
            assertTrue(a.find(6) == null);
            assertTrue(a.find(2) == 2);
            assertTrue(a.find(7) == 2);
            assertTrue(a.find(8) == 2);
            assertTrue(a.find(9) == 2);

            a.union(1, 2);
            assertTrue(a.find(2) == 0);
            assertTrue(a.find(7) == 0);
            assertTrue(a.find(8) == 0);
            assertTrue(a.find(9) == 0);

        } catch (NullElementException e) {
        }
    }

    @Test
    void testIsoler() {
        AmisArrayList<Integer> a = new AmisArrayList<Integer>();
        TestAmisArrayList.generate(a);
        try {
            a.isoler(1);
            assertTrue(a.find(0) == 0);
            assertTrue(a.find(1) == null);
            assertTrue(a.find(3) == 0);
            assertTrue(a.find(4) == 0);
            assertTrue(a.find(5) == 0);
            a.isoler(2);
            assertTrue(a.find(2) == null);
            assertTrue(a.find(7) == 7);
            assertTrue(a.find(8) == 7);
            assertTrue(a.find(9) == 7);
        } catch (NullElementException e) {
        }
    }
}
