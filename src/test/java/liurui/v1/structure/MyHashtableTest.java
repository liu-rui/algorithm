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
        assertEquals(8, hashtable.getSize());
        assertEquals(4, hashtable.getCount());
        assertEquals("e", hashtable.get(10));
        assertEquals("b", hashtable.get(11));
        assertEquals("c", hashtable.get(20));
        assertEquals("d", hashtable.get(30));

        hashtable.set(40,"e");
        hashtable.set(41,"f");
        hashtable.set(42,"g");
        hashtable.set(43,"h");
        hashtable.set(44,"i");
        hashtable.set(45,"j");
        hashtable.set(46,"k");

        assertEquals(16, hashtable.getSize());
        assertEquals(11,hashtable.getCount());
        assertEquals("e", hashtable.get(10));
        assertEquals("b", hashtable.get(11));
        assertEquals("c", hashtable.get(20));
        assertEquals("d", hashtable.get(30));
        assertEquals("e", hashtable.get(40));
        assertEquals("f", hashtable.get(41));
        assertEquals("g", hashtable.get(42));
        assertEquals("h", hashtable.get(43));
        assertEquals("i", hashtable.get(44));
        assertEquals("j", hashtable.get(45));
        assertEquals("k", hashtable.get(46));
    }
}