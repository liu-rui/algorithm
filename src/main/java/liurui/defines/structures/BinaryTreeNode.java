package liurui.defines.structures;

public class BinaryTreeNode {
    private int data;
    private BinaryTreeNode left;
    private BinaryTree right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }
}
