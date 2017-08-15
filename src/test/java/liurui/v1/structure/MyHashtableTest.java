package liurui.v1.structure;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashtableTest {

    @Test
    public void test() {
        MyHashtable hashtable = new MyHashtable();

        assertEquals(0, hashtable.getCount());

        hashtable.set(10, "a");
        assertEquals(1, hashtable.getCount());

        hashtable.remove(10);
        assertEquals(0, hashtable.getCount());
        assertNull(hashtable.get(10));

        hashtable.set(10,"a");
        hashtable.set(11,"b");
        hashtable.set(20,"c");
        hashtable.set(30,"d");
        hashtable.set(10,"e");
        assertEquals(4, hashtable.getCount());
        assertEquals("e", hashtable.get(10));
        assertEquals("b", hashtable.get(11));
        assertEquals("c", hashtable.get(20));
        assertEquals("d", hashtable.get(30));
    }
}