package liurui.v4.structures.tree;

import liurui.defines.structures.tree.BlanceBinaryTreeUsingRedBlack;

/**
 * 平衡二叉树,通过红黑树算法实现
 *
 * 插入，删除，查找都是O(logn)
 */
public class BlanceBinaryTreeUsingRedBlackImpl<K extends Comparable<K>, V> implements BlanceBinaryTreeUsingRedBlack<K , V> {

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
