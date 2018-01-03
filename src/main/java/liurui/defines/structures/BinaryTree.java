package liurui.defines.structures;

public interface BinaryTree {
    /**
     * 设置根节点
     *
     * @param root 根节点
     */
    void setRoot(BinaryTreeNode root);

    /**
     * 获取根节点
     *
     * @return 根节点
     */
    BinaryTreeNode getRoot();

    /**
     * 清空树
     */
    void clear();

    /**
     * 判断是否是空树
     *
     * @return 是否是空树
     */
    boolean isEmpty();

    /**
     * 获取节点个数
     *
     * @return 节点个数
     */
    int getSize();

    /**
     * 获取特定层次的节点个数
     *
     * @param level 层次
     * @return 节点个数
     */
    int getSize(int level);

    /**
     * 获取树的高度
     *
     * @return 树的高度
     */
    int getHeight();

    /**
     * 获取特定节点的双亲节点
     *
     * @param node 节点
     * @return 双亲节点
     */
    BinaryTreeNode getParent(BinaryTreeNode node);

    /**
     * 获取特定节点的左子树
     *
     * @param node 节点
     * @return 左子树
     */
    BinaryTreeNode getLeftNode(BinaryTreeNode node);

    /**
     * 获取特定节点的右子树
     *
     * @param node 节点
     * @return 右子树
     */
    BinaryTreeNode getRightNode(BinaryTreeNode node);

    /**
     * 插入左子树
     *
     * @param parent 双亲节点
     * @param node   子树
     */
    void insertLeft(BinaryTreeNode parent, BinaryTreeNode node);

    /**
     * 插入右子树
     *
     * @param parent 双亲节点
     * @param node   子树
     */
    void insertRight(BinaryTreeNode parent, BinaryTreeNode node);

    /**
     * 前序遍历
     *
     * @return 值列表
     */
    String PrintPreOrder();

    /**
     * 中序遍历
     *
     * @return 值列表
     */
    String PrintInOrder();

    /**
     * 后序遍历
     *
     * @return 值列表
     */
    String PrintPostOrder();

    /**
     * 层次遍历
     *
     * @return 值列表
     */
    String PrintLevelOrder();


    /**
     * 判断一棵树是否是平衡二叉树
     *
     * @param binaryTree 二叉树
     * @return 是否是平衡二叉树
     */
    boolean isBlanceBinaryTree(BinaryTree binaryTree);

    /**
     * 判断一棵树是否是完全二叉树
     *
     * @param binaryTree 二叉树
     * @return 是否是完全二叉树
     */
    boolean isCompleteTree(BinaryTree binaryTree);

    /**
     * 克隆一个二叉树
     * @return 新的二叉树
     */
    BinaryTree clone();

    /**
     * 判断2颗树是否相同
     * @param another 另一个是
     * @return
     */
    boolean isSame(BinaryTree another);

    /**
     * 创建一个镜像二叉树
     * @return 镜像二叉树
     */
    boolean createMirrorTree();

    /**
     * 二叉树是否互为镜像
     * @param another 镜像二叉树
     * @return 二叉树是否互为镜像
     */
    boolean isMirror(BinaryTree another);
}
