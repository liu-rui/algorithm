package liurui.v1.structure;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void clear() {
        clear(root);
    }

    public void clear(Node node) {
        if (node == null) {
            return;
        }

        clear(node.getLeftChild());
        clear(node.getRightNode());
        node = null;
    }


    public boolean isEmpty() {
        return root == null;
    }


    /**
     * 获取树的高度
     *
     * @return
     */
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.getLeftChild());
        int rightHeight = getHeight(node.getRightNode());

        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    /**
     * 获取树的节点个数
     *
     * @return
     */
    public int getSize() {
        return getSize(root);
    }

    private int getSize(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + getSize(node.getLeftChild()) + getSize(node.getRightNode());
    }


    public Node getParent(Node node) {
        return root == null || root == node
                ? null
                : getParent(root, node);
    }

    private Node getParent(Node parent, Node node) {
        if (parent == null) {
            return null;
        }

        if (parent.getLeftChild() == node ||
                parent.getRightNode() == node) {
            return parent;
        }

        Node ret;

        if ((ret = getParent(parent.getLeftChild())) != null) {
            return ret;
        } else {
            return getParent(parent.getRightNode(), node);
        }
    }

    public Node getLeftChild(Node node) {
        return node == null ? null : node.getLeftChild();
    }

    public Node getRightChild(Node node) {
        return node == null ? null : node.getRightNode();
    }


    public void insertLeft(Node parent, Node node) {
        parent.setLeftChild(node);
    }

    public void insertRight(Node parent, Node node) {
        parent.setRightNode(node);
    }

    public boolean exists(Node node) {
        return exists(root, node);
    }

    public boolean exists(Node parent, Node node) {
        if (parent == null) {
            return false;
        }
        if (parent == node) {
            return true;
        }

        return exists(parent.getLeftChild(), node) ? true : exists(parent.getRightNode(), node);
    }


    public String print(OrderType orderType) {
        switch (orderType) {
            case Pre_Order:
                return preOrder();
            case In_Order:
                return inOrder();
            case Post_Order:
                return postOrder();
        }

        return null;
    }


    private String preOrder() {
        StringBuilder sb = new StringBuilder();


        preOrder(sb, root);
        return sb.toString();
    }

    private void preOrder(StringBuilder sb, Node node) {
        if (node == null) {
            return;
        }


        sb.append(node.data);
        preOrder(sb, node.getLeftChild());
        preOrder(sb, node.getRightNode());
    }

    private String inOrder() {
        StringBuilder sb = new StringBuilder();


        inOrder(sb, root);
        return sb.toString();
    }

    private void inOrder(StringBuilder sb, Node node) {
        if (node == null) {
            return;
        }

        inOrder(sb, node.getLeftChild());
        sb.append(node.data);
        inOrder(sb, node.getRightNode());
    }


    private String postOrder() {
        StringBuilder sb = new StringBuilder();

        postOrder(sb, root);
        return sb.toString();
    }

    private void postOrder(StringBuilder sb, Node node) {
        if (node == null) {
            return;
        }


        postOrder(sb, node.getLeftChild());
        postOrder(sb, node.getRightNode());
        sb.append(node.data);
    }


    public enum OrderType {
        Pre_Order,
        In_Order,
        Post_Order
    }


    public static class Node {
        private String data;
        private Node leftChild;
        private Node rightNode;

        public Node(String data) {
            this.data = data;
        }

        public Node(String data, Node leftChild, Node rightNode) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightNode = rightNode;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }
    }
}
