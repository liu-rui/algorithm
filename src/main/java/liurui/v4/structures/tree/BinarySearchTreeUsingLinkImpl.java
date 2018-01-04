package liurui.v4.structures.tree;

import liurui.defines.structures.tree.BinarySearchTreeUsingLink;
import liurui.defines.structures.tree.BinaryTreeNode;

public class BinarySearchTreeUsingLinkImpl implements BinarySearchTreeUsingLink {
    BinaryTreeNode root;

    @Override
    public void add(int data) {
        if (root == null) {
            root = new BinaryTreeNode(data);
            return;
        }

        add(null, root, data);
    }

    public void add(BinaryTreeNode parent, BinaryTreeNode node, int data) {
        if (node == null) {
            node = new BinaryTreeNode(data);
            if (parent.getData() > data)
                parent.setLeft(node);
            else
                parent.setRight(node);
            return;
        }

        if (node.getData() == data) {
            return;
        } else if (node.getData() > data) {
            add(node, node.getLeft(), data);
        } else {
            add(node, node.getRight(), data);
        }
    }

    @Override
    public boolean contains(int data) {
        return getNode(root, data) != null;
    }

    private BinaryTreeNode getNode(BinaryTreeNode node, int data) {
        if (node == null) return null;

        if (node.getData() == data) {
            return node;
        } else if (node.getData() > data) {
            return getNode(node.getLeft(), data);
        } else {
            return getNode(node.getRight(), data);
        }
    }

    @Override
    public void remove(int data) {
        if (root == null) return;
        BinaryTreeNode[] nodes = getParentAndNode(null, root, data);

        if (nodes == null) return;
        BinaryTreeNode parent = nodes[0];
        BinaryTreeNode node = nodes[1];
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
            BinaryTreeNode newNodeParent = node.getRight();
            BinaryTreeNode newNode = newNodeParent.getLeft();

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


    private BinaryTreeNode[] getParentAndNode(BinaryTreeNode parent, BinaryTreeNode node, int data) {
        if (node == null) return null;
        if (node.getData() == data)
            return new BinaryTreeNode[]{parent, node};
        else if (node.getData() > data) {
            return getParentAndNode(node, node.getLeft(), data);
        } else {
            return getParentAndNode(node, node.getRight(), data);
        }
    }


    @Override
    public String printInOrder() {
        StringBuilder sb = new StringBuilder();

        printInOrder(sb, root);
        return sb.toString();
    }

    private void printInOrder(StringBuilder sb, BinaryTreeNode node) {
        if (node == null) return;

        printInOrder(sb, node.getLeft());
        if (sb.length() != 0) {
            sb.append(",");
        }
        sb.append(node.getData());
        printInOrder(sb, node.getRight());
    }

    @Override
    public String printPostOrder() {
        StringBuilder sb = new StringBuilder();

        printPostOrder(sb, root);
        return sb.toString();
    }

    private void printPostOrder(StringBuilder sb, BinaryTreeNode node) {
        if (node == null) return;

        printPostOrder(sb, node.getLeft());
        printPostOrder(sb, node.getRight());
        if (sb.length() != 0) {
            sb.append(",");
        }
        sb.append(node.getData());
    }
}
