package liurui.v4.structures.tree;

import liurui.defines.structures.tree.BinarySearchTreeUsingLink;
import liurui.defines.structures.tree.BinaryTreeNode;

public class BinarySearchTreeUsingLinkImpl<K extends Comparable<K>, V> implements BinarySearchTreeUsingLink<K, V> {
    BinaryTreeNode root;

    @Override
    public void add(K key, V data) {
        if (root == null) {
            root = new BinaryTreeNode(key, data);
            return;
        }

        add(null, root, key, data);
    }

    private void add(BinaryTreeNode<K,V> parent, BinaryTreeNode node, K key, V data) {
        if (node == null) {
            node = new BinaryTreeNode(key, data);
            if (parent.compareTo(node) > 0)
                parent.setLeft(node);
            else
                parent.setRight(node);
            return;
        }

        if (node.getData() == data) {
            return;
        } else if (node.getKey().compareTo(key) > 0) {
            add(node, node.getLeft(), key, data);
        } else {
            add(node, node.getRight(), key, data);
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    private BinaryTreeNode getNode(BinaryTreeNode<K,V> node, K key) {
        if (node == null) return null;

        if (node.getKey().compareTo(key) == 0) {
            return node;
        } else if (node.getKey().compareTo(key) > 0) {
            return getNode(node.getLeft(), key);
        } else {
            return getNode(node.getRight(), key);
        }
    }

    @Override
    public void remove(K key) {
        if (root == null) return;
        BinaryTreeNode<K,V>[] nodes = getParentAndNode(null, root, key);

        if (nodes == null) return;
        BinaryTreeNode<K,V> parent = nodes[0];
        BinaryTreeNode<K,V> node = nodes[1];
        boolean isLeft = parent == null || node.equals(parent.getLeft());


        if (node.getLeft() == null && node.getRight() == null) {
            if (parent == null) {
                root = null;
            } else {
                if (isLeft) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            }
        } else if (node.getLeft() != null && node.getRight() == null) {
            if (parent == null) {
                root = node.getLeft();
            } else {
                if (isLeft) {
                    parent.setLeft(node.getLeft());
                } else {
                    parent.setRight(node.getLeft());
                }
            }
        } else if (node.getLeft() == null && node.getRight() != null) {
            if (parent == null) {
                root = node.getRight();
            } else {
                if (isLeft) {
                    parent.setLeft(node.getRight());
                } else {
                    parent.setRight(node.getRight());
                }
            }
        } else {
            BinaryTreeNode<K,V> newNodeParent = node.getRight();
            BinaryTreeNode<K,V> newNode = newNodeParent.getLeft();

            while (newNode != null && newNode.getLeft() != null) {
                newNodeParent = newNode;
                newNode = newNode.getLeft();
            }

            if (newNode == null) {
                newNodeParent.setLeft(node.getLeft());
                node.setLeft(null);
                node.setRight(null);

                if (parent == null) {
                    root = newNodeParent;
                } else {
                    if (isLeft) {
                        parent.setLeft(newNodeParent);
                    } else {
                        parent.setRight(newNodeParent);
                    }
                }
            } else {
                newNodeParent.setLeft(newNode.getRight());
                newNode.setLeft(node.getLeft());
                newNode.setRight(node.getRight());
                node.setLeft(null);
                node.setRight(null);

                if (parent == null) {
                    root = newNode;
                } else {
                    if (isLeft) {
                        parent.setLeft(newNode);
                    } else {
                        parent.setRight(newNode);
                    }
                }
            }
        }
    }


    private BinaryTreeNode<K,V>[] getParentAndNode(BinaryTreeNode<K,V> parent, BinaryTreeNode<K,V> node, K key) {
        if (node == null) return null;
        if (node.getKey().compareTo(key) == 0)
            return new BinaryTreeNode[]{parent, node};
        else if (node.getKey().compareTo(key) > 0) {
            return getParentAndNode(node, node.getLeft(), key);
        } else {
            return getParentAndNode(node, node.getRight(), key);
        }
    }

    @Override
    public String printInOrder() {
        StringBuilder sb = new StringBuilder();

        printInOrder(sb, root);
        return sb.toString();
    }

    private void printInOrder(StringBuilder sb, BinaryTreeNode<K,V> node) {
        if (node == null) return;

        printInOrder(sb, node.getLeft());
        if (sb.length() != 0) {
            sb.append(",");
        }
        sb.append(node.getText());
        printInOrder(sb, node.getRight());
    }

    @Override
    public String printPostOrder() {
        StringBuilder sb = new StringBuilder();

        printPostOrder(sb, root);
        return sb.toString();
    }

    private void printPostOrder(StringBuilder sb, BinaryTreeNode<K,V> node) {
        if (node == null) return;

        printPostOrder(sb, node.getLeft());
        printPostOrder(sb, node.getRight());
        if (sb.length() != 0) {
            sb.append(",");
        }
        sb.append(node.getText());
    }
}
