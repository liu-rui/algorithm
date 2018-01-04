package liurui.defines.structures.tree;

/**
 * 二叉查找树(BST)
 *
 *特点：
 *  1. 左子树小于根节点，右子树大于根节点
 *  2. 所有子树都满足第一条规则
 */
public interface BinarySearchTree {
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

    /**
     * 打印后序遍历结果
     *
     * @return 值列表
     */
    String printPostOrder();
}
