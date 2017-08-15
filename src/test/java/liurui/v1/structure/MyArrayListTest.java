package liurui.v1.structure;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {
    @Test
    public void test() {
        MyArrayList ary = new MyArrayList();

        assertEquals(2, ary.getSize());
        assertEquals(0, ary.getCount());

        ary.add(10);
        assertEquals(2, ary.getSize());
        assertEquals(1, ary.getCount());
        assertEquals(10, ary.get(0));

        ary.remove();
        assertEquals(2, ary.getSize());
        assertEquals(0, ary.getCount());

        ary.add(10);
        ary.add(20);
        ary.add(0,30);
        assertEquals(4, ary.getSize());
        assertEquals(3, ary.getCount());
        assertEquals(30, ary.get(0));
        assertEquals(10, ary.get(1));
        assertEquals(20, ary.get(2));

        ary.remove(1);
        assertEquals(4, ary.getSize());
        assertEquals(2, ary.getCount());
        assertEquals(30, ary.get(0));
        assertEquals(20, ary.get(1));

        ary.remove();
        assertEquals(4, ary.getSize());
        assertEquals(1, ary.getCount());
        assertEquals(30, ary.get(0));


        ary.clear();

        assertEquals(4, ary.getSize());
        assertEquals(0, ary.getCount());
    }
}