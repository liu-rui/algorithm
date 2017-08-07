package liurui;

import junit.framework.TestCase;

public class MyHashMapTest extends TestCase {

    public void test() {
        MyHashMap map = new MyHashMap();
        assertFalse(map.hasKey(3));

        map.add(3, "ren");
        assertTrue(map.hasKey(3));
        assertEquals(1,map.getLen());
        assertEquals("ren" , map.get(3));

        map.add(13,"xss");

        assertTrue(map.hasKey(13));
        assertEquals(2,map.getLen());
        assertEquals("xss" , map.get(13));


        map.remove(13);


        assertFalse(map.hasKey(13));
        assertEquals(1,map.getLen());
    }
}
