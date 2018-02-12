package liurui.v4.structures.tree;

import liurui.defines.structures.tree.BlanceBinaryTreeUsingAvl;

/**
 * 平衡二叉树,通过AVL算法实现
 * <p>
 * 插入，删除，查找都是O(logn)
 */
public class BlanceBinaryTreeUsingAvlImpl<K extends Comparable<K>, V> implements BlanceBinaryTreeUsingAvl<K, V> {
    private static class MyNode<K extends Comparable<K>, V> {
        private int height = 0;
        private K key;
        private V data;
        MyNode<K, V> left;
        MyNode<K, V> right;


        public MyNode(K key, V data) {
            this.key = key;
            this.data = data;
        }

        public MyNode(K key, V data, MyNode<K, V> left, MyNode<K, V> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }


        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getData() {
            return data;
        }

        public void setData(V data) {
            this.data = data;
        }

        public MyNode<K, V> getLeft() {
            return left;
        }

        public void setLeft(MyNode<K, V> left) {
            this.left = left;
        }

        public MyNode<K, V> getRight() {
            return right;
        }

        public void setRight(MyNode<K, V> right) {
            this.right = right;
        }

        public String getText() {
            return String.format("[%s:%d]", key, height);
        }
    }

    MyNode<K, V> root;


    @Override
    public void add(K key, V data) {
        root = add(root, key, data);
    }

    private MyNode<K, V> add(MyNode<K, V> node, K key, V data) {
        if (node == null) {
            return new MyNode<>(key, data);
        }

        int compare = node.getKey().compareTo(key);

        switch (compare) {
            case 0:
                node.setData(data);
                return node;
            case 1:
                node.setLeft(add(node.getLeft(), key, data));
                break;
            case -1:
                node.setRight(add(node.getRight(), key, data));
                break;
        }
        node.setHeight(1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight())));
        return balance(node);
    }

    private int getHeight(MyNode<K, V> node) {
        return node == null ? -1 : node.getHeight();
    }

    private MyNode<K, V> getLeftNode(MyNode<K, V> node) {
        if (node.getLeft() == null) {
            return node;
        }
        return getLeftNode(node.getLeft());
    }

    private MyNode<K, V> removeLeftNode(MyNode<K, V> node) {
        if (node.getLeft() == null) {
            return node.getRight();
        }
        node.setLeft(removeLeftNode(node.getLeft()));
        node.setHeight(1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight())));
        return balance(node);
    }

    private MyNode<K, V> balance(MyNode<K, V> node) {
        int factor = getBalanceFactor(node);

        if (factor > 1) {
            if (getBalanceFactor(node.getLeft()) < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            node = rotateRight(node);
        } else if (factor < -1) {
            if (getBalanceFactor(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            node = rotateLeft(node);
        }
        return node;
    }

    private int getBalanceFactor(MyNode<K, V> node) {
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    private MyNode<K, V> rotateLeft(MyNode<K, V> node) {
        MyNode<K, V> ret = node.right;

        node.setRight(ret.getLeft());
        ret.setLeft(node);
        node.setHeight(1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight())));
        ret.setHeight(1 + Math.max(getHeight(ret.getLeft()), getHeight(ret.getRight())));
        return ret;
    }

    private MyNode<K, V> rotateRight(MyNode<K, V> node) {
        MyNode<K, V> ret = node.getLeft();

        node.setLeft(ret.getRight());
        ret.setRight(node);
        node.setHeight(1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight())));
        ret.setHeight(1 + Math.max(getHeight(ret.getLeft()), getHeight(ret.getRight())));
        return ret;
    }


    @Override
    public boolean contains(K key) {
        return contains(root, key);
    }

    private boolean contains(MyNode<K, V> node, K key) {
        if (node == null) {
            return false;
        }

        int compare = node.getKey().compareTo(key);

        switch (compare) {
            case 1:
                return contains(node.getLeft(), key);
            case -1:
                return contains(node.getRight(), key);
            default:
                return true;
        }
    }

    @Override
    public void remove(K key) {
        root = remove(root, key);
    }

    private MyNode<K, V> remove(MyNode<K, V> node, K key) {
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
                    MyNode<K, V> newNode = getLeftNode(node.getRight());

                    newNode.setRight(removeLeftNode(node.getRight()));
                    newNode.setLeft(node.getLeft());
                    node = newNode;
                }
            case 1:
                node.setLeft(remove(node.getLeft(), key));
                break;
            case -1:
                node.setRight(remove(node.getRight(), key));
                break;
        }
        node.setHeight(1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight())));
        return balance(node);
    }

    @Override
    public String printInOrder() {
        StringBuilder sb = new StringBuilder();

        printInOrder(sb, root);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


    private void printInOrder(StringBuilder sb, MyNode<K, V> node) {
        if (node == null) {
            return;
        }

        printInOrder(sb, node.getLeft());
        sb.append(node.getText());
        sb.append(',');
        printInOrder(sb, node.getRight());
    }


    @Override
    public String printPostOrder() {
        StringBuilder sb = new StringBuilder();

        printPostOrder(sb, root);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


    private void printPostOrder(StringBuilder sb, MyNode<K, V> node) {
        if (node == null) {
            return;
        }

        printPostOrder(sb, node.getLeft());
        printPostOrder(sb, node.getRight());
        sb.append(node.getText());
        sb.append(',');
    }
}