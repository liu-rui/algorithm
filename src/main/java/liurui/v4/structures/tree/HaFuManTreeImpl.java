package liurui.v4.structures.tree;

import liurui.defines.structures.Item;
import liurui.defines.structures.tree.BinaryTree;
import liurui.defines.structures.tree.BinaryTreeNode;
import liurui.defines.structures.tree.HaFuManTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 哈夫曼树
 */
public class HaFuManTreeImpl implements HaFuManTree {
    private static class Item implements Comparable<Item> {
        private String key;
        private Integer frequency;

        public Item(String key, Integer frequency) {
            this.key = key;
            this.frequency = frequency;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Integer getFrequency() {
            return frequency;
        }

        public void setFrequency(Integer frequency) {
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Item o) {
            return frequency.compareTo(o.frequency);
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key='" + key + '\'' +
                    ", frequency=" + frequency +
                    '}';
        }
    }

    /**
     * 字母为键，编码为值的字典
     */
    private HashMap<String, String> keys = new HashMap<>();

    /**
     * 编码为键，字母为值的字典
     */
    private HashMap<String, String> codes = new HashMap<>();

    /**
     * 生成哈夫曼编码
     *
     * @param keys 字母的出现频率
     */
    @Override
    public void generic(HashMap<String, Integer> keys) {
        LinkedList<Item> items = new LinkedList<>();
        keys.forEach((k, v) -> items.add(new Item(k, v)));
        //按照出现频率升序排列
        sort(items);
        BinaryTreeNode<String, Integer> tree = genericTree(items);
        //生成哈夫曼编码并存入字典中，以备用
        genericCode(tree, "");
    }

    private void sort(LinkedList<Item> items) {
        sort(items, 0, items.size() - 1);
    }

    private void sort(LinkedList<Item> items, int begin, int end) {
        if (begin >= end) return;

        int i = begin;
        int j = end;
        Item item = items.get(i);

        while (i < j) {
            while (i < j && items.get(j).compareTo(item) > 0) {
                j--;
            }

            if (i < j) {
                items.set(i++, items.get(j));
            }

            while (i < j && items.get(i).compareTo(item) <= 0) {
                i++;
            }

            if (i < j) {
                items.set(j--, items.get(i));
            }
        }
        items.set(i, item);
        sort(items, begin, i - 1);
        sort(items, i + 1, end);
    }

    /**
     * 生成哈夫曼树
     * @param items
     * @return
     */
    private BinaryTreeNode genericTree(LinkedList<Item> items) {
        HashMap<String, BinaryTreeNode<String, Integer>> cache = new HashMap<>();
        BinaryTreeNode<String, Integer> node = null;

        Item a, b;

        while (!items.isEmpty()) {
            a = items.poll();

            if (node == null) {
                if (!items.isEmpty()) {
                    b = items.poll();
                    node = new BinaryTreeNode<>("_tmp_" + a.getKey() + b.getKey(), a.getFrequency() + b.getFrequency(),
                            cache.containsKey(a.getKey()) ? cache.get(a.getKey()) : new BinaryTreeNode<>(a.getKey(), a.getFrequency()),
                            cache.containsKey(b.getKey()) ? cache.get(b.getKey()) : new BinaryTreeNode<>(b.getKey(), b.getFrequency()));
                } else {
                    node = cache.containsKey(a.getKey()) ? cache.get(a.getKey()) : new BinaryTreeNode<>(a.getKey(), a.getFrequency());
                }
            } else {
                node = new BinaryTreeNode<>("_tmp_" + node.getKey() + a.getKey(), node.getData() + a.getFrequency(),
                        node,
                        cache.containsKey(a.getKey()) ? cache.get(a.getKey()) : new BinaryTreeNode<>(a.getKey(), a.getFrequency()));
            }

            if (!items.isEmpty()) {
                if (node.getData() > items.peek().getFrequency()) {
                    Item newItem = new Item(node.getKey(), node.getData());

                    int i = 1;

                    while (i < items.size() && items.get(i).getFrequency() < newItem.getFrequency()) {
                        i++;
                    }
                    items.add(i, newItem);
                    cache.put(node.getKey(), node);
                    node = null;
                }
            }
        }
        return node;
    }

    private void genericCode(BinaryTreeNode<String, Integer> node, String path) {
        if (node == null) return;

        if (node.getLeft() == null && node.getRight() == null) {
            keys.put(node.getKey(), path);
            codes.put(path, node.getKey());
            return;
        }
        genericCode(node.getLeft(), path + "0");
        genericCode(node.getRight(), path + "1");
    }

    /**
     * 获取特定字母的哈夫曼编码
     *
     * @param key 字母
     * @return 哈夫曼编码
     */
    @Override
    public String getCode(String key) {
        return keys.get(key);
    }

    /**
     * 运用哈夫曼编码对文本进行编码
     *
     * @param data 文本
     * @return 编码后的文本
     */
    @Override
    public String encode(String data) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            sb.append(keys.get(String.valueOf(data.charAt(i))));
        }
        return sb.toString();
    }

    /**
     * 运用哈夫曼编码对文本进行解码
     *
     * @param data 文本
     * @return 解码后的文本
     */
    @Override
    public String decode(String data) {
        StringBuilder sb = new StringBuilder();
        int begin = 0;

        for (int i = 0; i < data.length(); i++) {
            String code = data.substring(begin, i + 1);


            if (codes.containsKey(code)) {
                sb.append(codes.get(code));
                begin = i + 1;
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
