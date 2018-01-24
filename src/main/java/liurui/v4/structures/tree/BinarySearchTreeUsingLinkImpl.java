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
        if (node == null) return new BinaryTreeNode<>(key, data);

        int compare = node.getKey().compareTo(key);

        switch (compare) {
            case 0:
                node.setData(data);
                break;
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
        if (root == null) {
            return false;
        }
        BinaryTreeNode<K, V> item = root;

        while (item != null) {
            int compare = item.getKey().compareTo(key);

            switch (compare) {
                case 0:
                    return true;
                case 1:
                    item = item.getLeft();
                    break;
                case -1:
                    item = item.getRight();
                    break;
            }
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
                if (node.getLeft() == null) {
                    return node.getRight();
                } else if (node.getRight() == null) {
                    return node.getLeft();
                } else {
                    BinaryTreeNode<K, V> newNode = min(node.getRight());

                    newNode.setRight(deleteMin(node.getRight()));
                    newNode.setLeft(node.getLeft());
                    node = newNode;
                }
                break;
            case 1:
                node.setLeft(remove(node.getLeft(), key));
                break;
            case -1:
                node.setRight(remove(node.getRight(), key));
                break;
        }
        return node;
    }

    private BinaryTreeNode<K, V> min(BinaryTreeNode<K, V> node) {
        if (node.getLeft() == null) return node;
        return min(node.getLeft());
    }

    private BinaryTreeNode<K, V> deleteMin(BinaryTreeNode<K, V> node) {
        if (node.getLeft() == null) {
            return node.getRight();
        }
        node.setLeft(deleteMin(node.getLeft()));
        return node;
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
}
