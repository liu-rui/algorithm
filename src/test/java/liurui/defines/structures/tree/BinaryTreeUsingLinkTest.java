package liurui.defines.structures.tree;

import liurui.v4.structures.tree.BinaryTreeUsingLinkImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeUsingLinkTest {

    public void test() {

    }

    @Test
    public void clear() {
        BinaryTree item = new BinaryTreeUsingLinkImpl();
        BinaryTreeNode node = new BinaryTreeNode(1, new BinaryTreeNode(2), null);

        item.setRoot(node);
        assertFalse(item.isEmpty());
        assertEquals(2, item.getSize());

        assertEquals(node, item.getRoot());
        item.clear();
        assertNull(item.getRoot());
        assertTrue(item.isEmpty());
        assertEquals(0, item.getSize());
    }

    @Test
    public void getSize() {
        BinaryTree item = new BinaryTreeUsingLinkImpl();
        BinaryTreeNode a = new BinaryTreeNode(1);
        BinaryTreeNode b = new BinaryTreeNode(2);
        BinaryTreeNode c = new BinaryTreeNode(3);
        BinaryTreeNode d = new BinaryTreeNode(4);
        BinaryTreeNode e = new BinaryTreeNode(5);

        item.insertLeft(a, b);
        item.insertRight(a, c);
        item.insertRight(c, d);
        item.insertRight(d, e);

        item.setRoot(a);
        assertFalse(item.isEmpty());
        assertEquals(5, item.getSize());

        assertEquals(1, item.getSize(1));
        assertEquals(2, item.getSize(2));
        assertEquals(1, item.getSize(3));
        assertEquals(1, item.getSize(4));
        assertEquals(0, item.getSize(5));


        assertEquals(4, item.getHeight());

        assertEquals(d, item.getParent(e));
        assertEquals(a, item.getParent(c));
        assertNull(item.getParent(a));

        assertEquals(b, a.getLeft());
        assertEquals(c, a.getRight());
        assertNull(d.getLeft());
        assertEquals(e, d.getRight());

        assertEquals("1,2,3,4,5", item.printPreOrder());
        assertEquals("2,1,3,4,5", item.printInOrder());
        assertEquals("2,5,4,3,1", item.printPostOrder());
        assertEquals("1,2,3,4,5", item.printLevelOrder());
    }
}
