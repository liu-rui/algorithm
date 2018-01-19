package liurui.v4.structures.tree;

import liurui.defines.structures.string.Contains;
import liurui.defines.structures.tree.BinaryTreeNode;
import liurui.defines.structures.tree.BinaryTreeUsingLink;

import java.util.LinkedList;

public class BinaryTreeUsingLinkImpl<K extends Comparable<K>, V> implements BinaryTreeUsingLink<K, V> {
    BinaryTreeNode<K, V> root;

    @Override
    public void setRoot(BinaryTreeNode<K, V> root) {
        this.root = root;
    }

    @Override
    public BinaryTreeNode<K, V> getRoot() {
        return root;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int getSize() {
        return getSize(root);
    }

    private int getSize(BinaryTreeNode<K, V> node) {
        if (node == null) return 0;
        return 1 + getSize(node.getLeft()) + getSize(node.getRight());
    }


    @Override
    public int getSize(int level) {
        return getSize(root, 1, level);
    }

    private int getSize(BinaryTreeNode<K, V> node, int currentLevel, int level) {
        if (node == null || currentLevel > level) {
            return 0;
        }
        return (currentLevel == level ? 1 : 0) + getSize(node.getLeft(), currentLevel + 1, level) +
                getSize(node.getRight(), currentLevel + 1, level);
    }

    @Override
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BinaryTreeNode<K, V> node) {
        if (node == null) return 0;

        return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
    }

    @Override
    public BinaryTreeNode getParent(BinaryTreeNode<K, V> node) {
        if (root == null) return null;
        return getParent(root, node);
    }

    private BinaryTreeNode getParent(BinaryTreeNode<K, V> parent, BinaryTreeNode<K, V> node) {
        if (parent == null) return null;
        if (node == parent.getLeft() || node == parent.getRight()) return parent;

        BinaryTreeNode ret = getParent(parent.getLeft(), node);

        if (ret != null) {
            return ret;
        }
        return getParent(parent.getRight(), node);
    }


    @Override
    public BinaryTreeNode<K, V> getLeftNode(BinaryTreeNode<K, V> node) {
        return node.getLeft();
    }

    @Override
    public BinaryTreeNode<K, V> getRightNode(BinaryTreeNode<K, V> node) {
        return node.getRight();
    }

    @Override
    public void insertLeft(BinaryTreeNode<K, V> parent, BinaryTreeNode<K, V> node) {
        if (parent == null) throw new IllegalArgumentException();
        parent.setLeft(node);
    }

    @Override
    public void insertRight(BinaryTreeNode<K, V> parent, BinaryTreeNode<K, V> node) {
        if (parent == null) throw new IllegalArgumentException();
        parent.setRight(node);
    }

    @Override
    public String printPreOrder() {
        StringBuilder sb = new StringBuilder();

        printPreOrder(sb, root);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void printPreOrder(StringBuilder container, BinaryTreeNode<K, V> node) {
        if (node == null) return;
        container.append(String.format("%s,", node.getText()));
        printPreOrder(container, node.getLeft());
        printPreOrder(container, node.getRight());
    }

    @Override
    public String printInOrder() {
        StringBuilder sb = new StringBuilder();

        printInOrder(sb, root);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void printInOrder(StringBuilder container, BinaryTreeNode<K, V> node) {
        if (node == null) return;
        printInOrder(container, node.getLeft());
        container.append(String.format("%s,", node.getText()));
        printInOrder(container, node.getRight());
    }

    @Override
    public String printPostOrder() {
        StringBuilder sb = new StringBuilder();

        printPostOrder(sb, root);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void printPostOrder(StringBuilder container, BinaryTreeNode<K, V> node) {
        if (node == null) return;
        printPostOrder(container, node.getLeft());
        printPostOrder(container, node.getRight());
        container.append(String.format("%s,", node.getText()));
    }

    @Override
    public String printLevelOrder() {
        StringBuilder sb = new StringBuilder();
        LinkedList<BinaryTreeNode<K, V>> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<K, V> node = queue.poll();

            sb.append(String.format("%s,", node.getText()));

            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }

            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
