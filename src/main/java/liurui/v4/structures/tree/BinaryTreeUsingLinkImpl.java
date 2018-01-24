package liurui.v4.structures.tree;

import liurui.defines.practice.MaxTree;
import liurui.defines.structures.tree.BinaryTreeNode;
import liurui.defines.structures.tree.BinaryTreeUsingLink;

import java.util.ArrayDeque;
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
        if (node == null) {
            return 0;
        }
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
        return (currentLevel == level ? 1 : 0) +
                getSize(node.getLeft(), currentLevel + 1, level) +
                getSize(node.getRight(), currentLevel + 1, level);
    }


    @Override
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BinaryTreeNode<K, V> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }

    @Override
    public BinaryTreeNode getParent(BinaryTreeNode<K, V> node) {
        return getParent(node, root);
    }

    private BinaryTreeNode getParent(BinaryTreeNode<K, V> node, BinaryTreeNode<K, V> parent) {
        if (parent == null) {
            return null;
        }

        if (node == parent.getLeft() || node == parent.getRight()) {
            return parent;
        }
        BinaryTreeNode ret = getParent(node, parent.getLeft());

        if (ret != null) {
            return ret;
        }
        return getParent(node, parent.getRight());
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
        parent.setLeft(node);
    }

    @Override
    public void insertRight(BinaryTreeNode<K, V> parent, BinaryTreeNode<K, V> node) {
        parent.setRight(node);
    }

    @Override
    public String printPreOrder() {
        StringBuilder sb = new StringBuilder();

        printPreOrder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void printPreOrder(BinaryTreeNode<K, V> node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.getText());
        sb.append(',');
        printPreOrder(node.getLeft(), sb);
        printPreOrder(node.getRight(), sb);
    }

    @Override
    public String printInOrder() {
        StringBuilder sb = new StringBuilder();

        printInOrder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void printInOrder(BinaryTreeNode<K, V> node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        printInOrder(node.getLeft(), sb);
        sb.append(node.getText());
        sb.append(',');
        printInOrder(node.getRight(), sb);
    }

    @Override
    public String printPostOrder() {
        StringBuilder sb = new StringBuilder();

        printPostOrder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void printPostOrder(BinaryTreeNode<K, V> node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        printPostOrder(node.getLeft(), sb);
        printPostOrder(node.getRight(), sb);
        sb.append(node.getText());
        sb.append(',');
    }

    @Override
    public String printLevelOrder() {
        StringBuilder sb = new StringBuilder();
        LinkedList<BinaryTreeNode<K, V>> queue = new LinkedList<>();

        queue.add(root);
        sb.append(root.getText());
        sb.append(',');

        while (!queue.isEmpty()) {
            BinaryTreeNode<K, V> node = queue.poll();

            if(node.getLeft() != null){
                queue.add(node.getLeft());
                sb.append(node.getLeft().getText());
                sb.append(',');
            }

            if(node.getRight() != null){
                queue.add(node.getRight());
                sb.append(node.getRight().getText());
                sb.append(',');
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
