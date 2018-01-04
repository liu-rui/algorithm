package liurui.defines.structures.tree;

import liurui.v4.structures.tree.BinarySearchTreeUsingLinkImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeUsingLinkTest {
    BinarySearchTree item;


    @Before
    public void aa() {
        item = new BinarySearchTreeUsingLinkImpl();
        item.add(42);
        item.add(14);
        item.add(65);
        item.add(9);
        item.add(23);
        item.add(55);
        item.add(72);
        item.add(1);
        item.add(68);
        item.add(88);
        item.add(70);
    }

    @Test
    public void testContains() {
        assertTrue(item.contains(72));
        assertFalse(item.contains(100));

        assertEquals("1,9,14,23,42,55,65,68,70,72,88", item.printInOrder());
        assertEquals("1,9,23,14,55,70,68,88,72,65,42" , item.printPostOrder());
    }

    @Test
    public void testRemove1() {
        item.remove(23);
        assertFalse(item.contains(23));
        assertEquals("1,9,14,42,55,65,68,70,72,88", item.printInOrder());
        assertEquals("1,9,14,55,70,68,88,72,65,42", item.printPostOrder());
    }

    @Test
    public  void  testRemove2(){
        item.remove(9);
        assertFalse(item.contains(9));
        assertEquals("1,14,23,42,55,65,68,70,72,88", item.printInOrder());
        assertEquals("1,23,14,55,70,68,88,72,65,42", item.printPostOrder());
    }


    @Test
    public void testRemove3() {
        item.remove(68);
        assertFalse(item.contains(68));

        assertEquals("1,9,14,23,42,55,65,70,72,88", item.printInOrder());
        assertEquals("1,9,23,14,55,70,88,72,65,42" , item.printPostOrder());
    }


    @Test
    public void testRemove4() {
        item.remove(65);
        assertFalse(item.contains(65));

        assertEquals("1,9,14,23,42,55,68,70,72,88", item.printInOrder());
        assertEquals("1,9,23,14,55,70,88,72,68,42" , item.printPostOrder());
    }

    @Test
    public void testRemove5() {
        item.remove(42);
        assertFalse(item.contains(42));

        assertEquals("1,9,14,23,55,65,68,70,72,88", item.printInOrder());
        assertEquals("1,9,23,14,70,68,88,72,65,55" , item.printPostOrder());
    }
}
