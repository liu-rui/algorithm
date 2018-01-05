package liurui.v4.structures.tree;

import liurui.defines.structures.tree.BlanceBinaryTreeUsingAvl;

/**
 * 平衡二叉树,通过AVL算法实现
 * <p>
 * 插入，删除，查找都是O(logn)
 */
public class BlanceBinaryTreeUsingAvlImpl<K extends Comparable<K>, V> implements BlanceBinaryTreeUsingAvl<K, V> {

    @Override
    public void add(K key, V data) {

    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public void remove(K key) {

    }

    @Override
    public String printInOrder() {
        return null;
    }

    @Override
    public String printPostOrder() {
        return null;
    }
}