package liurui.v4.structures.tree;

import liurui.defines.structures.Item;
import liurui.defines.structures.tree.HaFuManTree;

import java.util.ArrayList;
import java.util.HashMap;

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
     * 生成哈夫曼编码
     *
     * @param keys 字母的出现频率
     */
    @Override
    public void generic(HashMap<String, Integer> keys) {
        ArrayList<Item> items = new ArrayList<>(keys.size());
        keys.forEach((k, v) -> items.add(new Item(k, v)));
        sort(items);
        items.forEach(System.out::println);
    }

    private void sort(ArrayList<Item> items) {
        sort(items, 0, items.size() - 1);
    }

    private void sort(ArrayList<Item> items, int begin, int end) {
        if (begin >= end) return;

        int i = begin;
        int j = end;
        Item item = items.get(i);

        while (i < j) {
            while (i < j && items.get(j).compareTo(item) >= 0) {
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
     * 获取特定字母的哈夫曼编码
     *
     * @param key 字母
     * @return 哈夫曼编码
     */
    @Override
    public String getCode(String key) {
        return "";
    }

    /**
     * 运用哈夫曼编码对文本进行编码
     *
     * @param data 文本
     * @return 编码后的文本
     */
    @Override
    public String encode(String data) {
        return "";
    }

    /**
     * 运用哈夫曼编码对文本进行解码
     *
     * @param data 文本
     * @return 解码后的文本
     */
    @Override
    public String decode(String data) {
        return "";
    }
}
