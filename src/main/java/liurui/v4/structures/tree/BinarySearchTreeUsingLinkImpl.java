package liurui.v4.structures.tree;

import liurui.defines.structures.tree.BinarySearchTreeUsingLink;
import liurui.defines.structures.tree.BinaryTreeNode;

public class BinarySearchTreeUsingLinkImpl<K extends Comparable<K>, V> implements BinarySearchTreeUsingLink<K, V> {
    BinaryTreeNode<K, V> root;


    @Override
    public void add(K key, V data) {
        root = add(root, key, data);
    }

    private BinaryTreeNode<K, V> add(BinaryTreeNode<K, V> node, K key, V data) {
        if (node == null) {
            return new BinaryTreeNode<>(key, data);
        }

        int compare = node.getKey().compareTo(key);

        switch (compare) {
            case 1:
                node.setLeft(add(node.getLeft(), key, data));
                break;
            case -1:
                node.setRight(add(node.getRight(), key, data));
                break;
        }
        return node;
    }

    @Override
    public boolean contains(K key) {
        return contains(root, key);
    }

    private boolean contains(BinaryTreeNode<K, V> node, K key) {
        if (node == null) {
            return false;
        }

        int compare = node.getKey().compareTo(key);

        switch (compare) {
            case 0:
                return true;
            case 1:
                return contains(node.getLeft(), key);
            case -1:
                return contains(node.getRight(), key);
        }
        return false;
    }


    @Override
    public void remove(K key) {
        root = remove(root, key);
    }

    private BinaryTreeNode<K, V> remove(BinaryTreeNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }

        int compare = node.getKey().compareTo(key);

        switch (compare) {
            case 0:
                if (node.getLeft() == null && node.getRight() == null) {
                    return null;
                } else if (node.getLeft() != null && node.getRight() == null) {
                    return node.getLeft();
                } else if (node.getLeft() == null && node.getRight() != null) {
                    return node.getRight();
                } else {
                    BinaryTreeNode<K, V> firstNode = getLeftNode(node.getRight());

                    firstNode.setRight(removeLeftNode(node.getRight()));
                    firstNode.setLeft(node.getLeft());
                    node = firstNode;
                }
            case 1:
                node.setLeft(remove(node.getLeft(), key));
                break;
            case -1:
                node.setRight(remove(node.getRight(), key));
                break;
        }

        return node;
    }

    private BinaryTreeNode<K, V> getLeftNode(BinaryTreeNode<K, V> node) {
        if (node.getLeft() == null) {
            return node;
        }
        return getLeftNode(node.getLeft());
    }

    private BinaryTreeNode<K, V> removeLeftNode(BinaryTreeNode<K, V> node) {
        if (node.getLeft() == null) {
            return node.getRight();
        }
        node.setLeft(removeLeftNode(node.getLeft()));
        return node;
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
}
