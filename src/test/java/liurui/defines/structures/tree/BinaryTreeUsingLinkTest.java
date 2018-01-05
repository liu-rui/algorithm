package liurui.defines.structures.tree;

import liurui.v4.structures.tree.BinaryTreeUsingLinkImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeUsingLinkTest {

    public void test() {

    }

    @Test
    public void clear() {
        BinaryTree<Integer , Integer> item = new BinaryTreeUsingLinkImpl<>();
        BinaryTreeNode node = new BinaryTreeNode(1, 1,new BinaryTreeNode(2,2), null);

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
        BinaryTree<String,Integer> item = new BinaryTreeUsingLinkImpl<>();
        BinaryTreeNode a = new BinaryTreeNode("a",1);
        BinaryTreeNode b = new BinaryTreeNode("b",2);
        BinaryTreeNode c = new BinaryTreeNode("c",3);
        BinaryTreeNode d = new BinaryTreeNode("d",4);
        BinaryTreeNode e = new BinaryTreeNode("e",5);

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

        assertEquals("[a:1],[b:2],[c:3],[d:4],[e:5]", item.printPreOrder());
        assertEquals("[b:2],[a:1],[c:3],[d:4],[e:5]", item.printInOrder());
        assertEquals("[b:2],[e:5],[d:4],[c:3],[a:1]", item.printPostOrder());
        assertEquals("[a:1],[b:2],[c:3],[d:4],[e:5]", item.printLevelOrder());
    }
}
