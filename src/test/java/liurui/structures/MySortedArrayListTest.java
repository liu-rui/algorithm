package liurui.structures;

import org.junit.Test;

import static org.junit.Assert.*;

public class MySortedArrayListTest {
    @Test
    public void test() {
        MyArrayList ary = new MySortedArrayList(2);

        assertEquals(2, ary.capacity());
        assertEquals(0, ary.getSize());

        ary.add(5);
        ary.add(3);
        ary.add(4);
        ary.add(2);
        ary.add(1);

        assertEquals(1, ary.get(0));
        assertEquals(2, ary.get(1));
        assertEquals(3, ary.get(2));
        assertEquals(4, ary.get(3));
        assertEquals(5, ary.get(4));

        assertTrue(ary.contains(4));
        assertFalse(ary.contains(40));
    }
}