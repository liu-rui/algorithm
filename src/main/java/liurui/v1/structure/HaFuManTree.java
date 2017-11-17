package liurui.v1.structure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class HaFuManTree {
    ArrayList<Item> ary = new ArrayList<>();
    Map<String, String> key2codeMap = new HashMap<>();
    Map<String, String> code2keyMap = new HashMap<>();


    public void set(String key, int data) {
        ary.add(new Item(key, data));
    }

    public void generic() {
        ary.sort(Item.ItemComparator);


        int i = 1;
        Node right, tmp;
        Node root = new Node(ary.get(0));


        while (i < ary.size()) {
            if (root.item.compareTo(ary.get(i)) == 1) {
                tmp = root;
                root = new Node(ary.get(i));
                right = tmp;
            } else {
                right = new Node(ary.get(i));
            }


            root = new Node(new Item("", root.item.data + right.item.data), root, right);
            i++;
        }

        order(root);

        ary.forEach(w -> {
            key2codeMap.put(w.key, w.code);
            code2keyMap.put(w.code, w.key);
        });
    }

    private void order(Node node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            node.left.item.code = node.item.code + "0";
        }

        if (node.right != null) {
            node.right.item.code = node.item.code + "1";
        }


        order(node.left);
        order(node.right);
    }


    public String get(String key) {
        return key2codeMap.get(key);
    }

    public String encode(String data) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            sb.append(key2codeMap.get(String.valueOf(data.charAt(i))));
        }

        return sb.toString();
    }


    public String decode(String data) {
        StringBuilder sb = new StringBuilder();
        int begin = 0;
        String key;

        for (int i = 0; i < data.length(); i++) {
            key = data.substring(begin, i + 1);
            if (code2keyMap.containsKey(key)) {
                sb.append(code2keyMap.get(key));
                begin = i + 1;
            }
        }
        return sb.toString();
    }

    private static class Item implements Comparator<Item>, Comparable<Item> {
        public final static Item ItemComparator = new Item();


        private String key;
        private int data;
        private String code = "";

        public Item() {
        }

        public Item(String key, int data) {
            this.key = key;
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Item item = (Item) o;

            return data == item.data;
        }

        @Override
        public int hashCode() {
            return data;
        }

        @Override
        public int compare(Item o1, Item o2) {
            return o1.compareTo(o2);
        }

        @Override
        public int compareTo(Item o) {
            return data > o.data ? 1 : (data == o.data ? 0 : -1);
        }
    }

    private static class Node {
        private Item item;
        private Node left;
        private Node right;

        public Node(Item item) {
            this.item = item;
        }

        public Node(Item item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }
}
