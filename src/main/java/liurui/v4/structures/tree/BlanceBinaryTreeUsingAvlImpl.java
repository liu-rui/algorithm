package liurui.v4.structures.tree;

import jdk.internal.org.objectweb.asm.signature.SignatureWriter;
import liurui.defines.structures.tree.BinaryTreeNode;
import liurui.defines.structures.tree.BlanceBinaryTreeUsingAvl;

/**
 * 平衡二叉树,通过AVL算法实现
 * <p>
 * 插入，删除，查找都是O(logn)
 */
public class BlanceBinaryTreeUsingAvlImpl<K extends Comparable<K>, V> implements BlanceBinaryTreeUsingAvl<K, V> {
    private static class Node<K extends Comparable<K>, V> {
        private K key;
        private V data;
        private int height;
        private Node<K, V> left, right;

        public Node(K key, V data) {
            this.key = key;
            this.data = data;
        }

        public Node(K key, V data, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "[" + key + ":" + height + "]";
        }
    }

    Node<K, V> root;

    @Override
    public void add(K key, V data) {
        root = add(root, key, data);
    }

    private Node<K, V> add(Node<K, V> node, K key, V data) {
        if (node == null) {
            return new Node<>(key, data);
        }
        int compare = node.key.compareTo(key);

        switch (compare) {
            case 0:
                node.data = data;
                return node;
            case 1:
                node.left = add(node.left, key, data);
                break;
            case -1:
                node.right = add(node.right, key, data);
                break;
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
    }

    private Node<K, V> balance(Node<K, V> node) {
        //LeftX
        if (balanceFactor(node) > 1) {
            //LeftRight
            if (balanceFactor(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            node = rotateRight(node);
        } else if (balanceFactor(node) < -1) {//RightX
            //RightLeft
            if (balanceFactor(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            node = rotateLeft(node);
        }
        return node;
    }

    private Node<K, V> rotateLeft(Node<K, V> node) {
        Node<K, V> newNode = node.right;

        node.right = newNode.left;
        newNode.left = node;
        node.height = 1 + Math.max(height(node.left), height(node.right));
        newNode.height = 1 + Math.max(height(newNode.left), height(newNode.right));
        return newNode;
    }


    private Node<K, V> rotateRight(Node<K, V> node) {
        Node<K, V> newNode = node.left;

        node.left = newNode.right;
        newNode.right = node;
        node.height = 1 + Math.max(height(node.left), height(node.right));
        newNode.height = 1 + Math.max(height(newNode.left), height(newNode.right));
        return newNode;
    }

    private int balanceFactor(Node<K, V> node) {
        return height(node.left) - height(node.right);
    }

    private int height(Node<K, V> node) {
        return node == null ? -1 : node.height;
    }

    @Override
    public boolean contains(K key) {
        return contains(root, key);
    }

    private boolean contains(Node<K, V> node, K key) {
        if (node == null) {
            return false;
        }

        int compare = node.key.compareTo(key);

        switch (compare) {
            case 0:
                return true;
            case 1:
                return contains(node.left, key);
            case -1:
                return contains(node.right, key);
        }
        return false;
    }

    @Override
    public void remove(K key) {
        if (!contains(key)) return;
        root = remove(root, key);
    }

    private Node<K, V> remove(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }

        int compare = node.key.compareTo(key);

        switch (compare) {
            case 0:
                if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                } else {
                    Node<K, V> newNode = min(node.right);
                    newNode.right = deleteMin(node.right);
                    newNode.left = node.left;
                    node = newNode;
                }
                break;
            case 1:
                node.left = remove(node.left, key);
                break;
            case -1:
                node.right = remove(node.right, key);
                break;
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
    }

    private Node<K, V> min(Node<K, V> node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    private Node<K, V> deleteMin(Node<K, V> node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
    }

    @Override
    public String printInOrder() {
        StringBuilder sb = new StringBuilder();

        printInOrder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void printInOrder(Node<K, V> node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        printInOrder(node.left, sb);
        sb.append(node.toString());
        sb.append(',');
        printInOrder(node.right, sb);
    }

    @Override
    public String printPostOrder() {
        StringBuilder sb = new StringBuilder();

        printPostOrder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void printPostOrder(Node<K, V> node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        printPostOrder(node.left, sb);
        printPostOrder(node.right, sb);
        sb.append(node.toString());
        sb.append(',');
    }
}