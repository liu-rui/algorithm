package liurui.defines.structures;

/**
 * 平衡二叉树
 * 满足一下2个条件：
 * 1. 左右子树都是高度平衡的二叉树
 * 2. 且左右子树高度之差绝对值不大于1
 *
 *
 * 平衡二叉树的常用实现方法有红黑树、AVL、替罪羊树、Treap、伸展树
 *
 */
public interface BlanceBinaryTree {

    /**
     * 添加数据
     *
     * @param data 数据
     */
    void add(int data);

    /**
     * 查找是否存在特定的数据
     *
     * @param data 特定的数据
     * @return 是否存在
     */
    boolean contains(int data);

    /**
     * 删除数据
     *
     * @param data 数据
     */
    void remove(int data);

    /**
     * 打印中序遍历结果
     *
     * @return 值列表
     */
    String printInOrder();
}
