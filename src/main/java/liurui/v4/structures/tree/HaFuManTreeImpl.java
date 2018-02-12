package liurui.v4.structures.tree;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Node;
import liurui.defines.structures.tree.HaFuManTree;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 哈夫曼树
 */
public class HaFuManTreeImpl implements HaFuManTree {
    private static class Node implements Comparable<Node> {
        private String key;
        private int value;
        private Node left;
        private Node right;


        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(value, o.value);
        }

        public Node(String key, int value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    HashMap<String, String> hashByKey = new HashMap<>();
    HashMap<String, String> hashByCode = new HashMap<>();

    /**
     * 生成哈夫曼编码
     *
     * @param keys 字母的出现频率
     */
    @Override
    public void generic(HashMap<String, Integer> keys) {
        PriorityQueue<Node> nodes = new PriorityQueue<>();

        keys.forEach((k, v) -> nodes.add(new Node(k, v)));

        while (nodes.size() > 1) {
            Node left = nodes.poll();
            Node right = nodes.poll();

            nodes.add(new Node(left.key + right.key,
                    left.value + right.value,
                    left,
                    right));
        }
        Node root = nodes.poll();
        generic(root);
    }

    private void generic(Node root) {
        generic(root, "");
    }

    private void generic(Node node, String code) {
        if (node.left == null && node.right == null) {
            hashByKey.put(node.key, code);
            hashByCode.put(code, node.key);
        }

        if (node.left != null) {
            generic(node.left, code + "0");
        }

        if (node.right != null) {
            generic(node.right, code + "1");
        }
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
            sb.append(hashByKey.get(String.valueOf(data.charAt(i))));
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

            if(hashByCode.containsKey(code)){
                sb.append(hashByCode.get(code));
                begin = i+1;
            }
        }
        return sb.toString();
    }
}
