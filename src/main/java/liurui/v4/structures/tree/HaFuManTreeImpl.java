package liurui.v4.structures.tree;

import liurui.defines.structures.tree.HaFuManTree;

import java.lang.reflect.Array;
import java.time.chrono.IsoChronology;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 哈夫曼树
 */
public class HaFuManTreeImpl implements HaFuManTree {
    private static class Node implements Comparable<Node> {
        private String key;
        private int frequency;
        private Node left;
        private Node right;

        public Node(String key, int frequency) {
            this.key = key;
            this.frequency = frequency;
        }

        public Node(String key, int frequency, Node left, Node right) {
            this.key = key;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            int ret = Integer.compare(frequency, o.frequency);
            return ret == 0 ? key.compareTo(o.key) : ret;
        }

        @Override
        public String toString() {
            return String.format("[%s:%d]", key, frequency);
        }
    }

    private static class Heap {
        Node[] list;
        int size = 0;

        public void init(HashMap<String, Integer> keys) {
            if (keys == null || keys.size() == 0) {
                throw new IllegalArgumentException();
            }
            list = new Node[keys.size()];

            for (Map.Entry<String, Integer> entry : keys.entrySet()) {
                Node item = new Node(entry.getKey(), entry.getValue());

                push(item);
            }
        }

        private void push(Node node) {
            size++;
            int i = size - 1;

            while (i >= 1 && i / 2 >= 0 && list[i / 2].compareTo(node) > 0) {
                list[i] = list[i / 2];
                i /= 2;
            }
            list[i] = node;
        }

        private Node pop() {
            if (size == 0) throw new IndexOutOfBoundsException();
            Node ret = list[0];

            size--;

            if (size != 0) {
                Node item = list[size];
                int parent = 0;
                int child = 1;

                while (child < size) {
                    if (child + 1 < size && list[child].compareTo(list[child + 1]) > 0) {
                        child++;
                    }

                    if (list[child].compareTo(item) > 0) {
                        break;
                    } else {
                        list[parent] = list[child];
                        parent = child;
                        child *= 2;
                    }
                }
                list[parent] = item;
            }
            return ret;
        }

        private int size() {
            return size;
        }
    }

    private Node root;
    private HashMap<String, String> hashByKey = new HashMap<>();
    private HashMap<String, String> hashByCode = new HashMap<>();

    /**
     * 生成哈夫曼编码
     *
     * @param keys 字母的出现频率
     */
    @Override
    public void generic(HashMap<String, Integer> keys) {
        Heap heap = new Heap();
        heap.init(keys);

        while (heap.size() > 1) {
            Node left = heap.pop();
            Node right = heap.pop();
            heap.push(new Node(left.key + right.key,
                    left.frequency + right.frequency,
                    left,
                    right));
        }
        root = heap.pop();
        generic(root, "");
    }

    private void generic(Node node, String code) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            hashByKey.put(node.key, code);
            hashByCode.put(code, node.key);
            return;
        }
        generic(node.left, code + "0");
        generic(node.right, code + "1");
    }


    /**
     * 获取特定字母的哈夫曼编码
     *
     * @param key 字母
     * @return 哈夫曼编码
     */
    @Override
    public String getCode(String key) {
        return hashByKey.get(key);
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
            sb.append(hashByKey.get(String.valueOf(  data.charAt(i))));
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

        for(int i = 0;i<data.length();i++){
            String code = data.substring(begin, i + 1);

            if(hashByCode.containsKey(code)){
                sb.append(hashByCode.get(code));
                begin = i+1;
            }
        }
        return  sb.toString();
    }
}
