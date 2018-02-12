package liurui.v4.structures.tree;

import liurui.defines.structures.tree.BinaryTreeNode;
import liurui.defines.structures.tree.BinaryTreeUsingLink;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTreeUsingLinkImpl<K extends Comparable<K>, V> implements BinaryTreeUsingLink<K, V> {
    private BinaryTreeNode<K, V> root;


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

    private int getSize(BinaryTreeNode<K, V> node, int curLevel, int level) {
        if (node == null || curLevel > level) {
            return 0;
        }

        return (curLevel == level ? 1 : 0) +
                getSize(node.getLeft(), curLevel + 1, level) +
                getSize(node.getRight(), curLevel + 1, level);
    }

    @Override
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BinaryTreeNode<K, V> node) {
        if (node == null) return 0;

        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }

    @Override
    public BinaryTreeNode getParent(BinaryTreeNode<K, V> node) {

        return getParent(node, null, root);
    }

    BinaryTreeNode getParent(BinaryTreeNode<K, V> node, BinaryTreeNode<K, V> parent, BinaryTreeNode<K, V> curNode) {
        if (curNode == null) {
            return null;
        }

        if (curNode.getKey().equals(node.getKey())) {
            return parent;
        }
        BinaryTreeNode<K, V> ret = getParent(node, curNode, curNode.getLeft());

        if (ret != null) {
            return ret;
        }
        return getParent(node, curNode, curNode.getRight());
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

        printPreOrder(sb, root);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void printPreOrder(StringBuilder container, BinaryTreeNode<K, V> node) {
        if (node == null) {
            return;
        }
        container.append(node.getText());
        container.append(',');
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
        if (node == null) {
            return;
        }
        printInOrder(container, node.getLeft());
        container.append(node.getText());
        container.append(',');
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
        if (node == null) {
            return;
        }
        printPostOrder(container, node.getLeft());
        printPostOrder(container, node.getRight());
        container.append(node.getText());
        container.append(',');
    }

    @Override
    public String printLevelOrder() {
        StringBuilder sb = new StringBuilder();
        Deque<BinaryTreeNode<K, V>> queue = new ArrayDeque<>();

        queue.add(root);
        sb.append(root.getText());
        sb.append(',');

        while (!queue.isEmpty()){
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
