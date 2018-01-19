package liurui.v4.structures.graph;

import liurui.defines.structures.graph.GraphUsingList;

import java.util.*;

/**
 * 图，使用邻接表表示
 */
public class GraphUsingListImpl implements GraphUsingList {
    private static class Node {
        private int index;
        private int value;
        private Node next;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public Node(int index, int value, Node next) {
            this.index = index;
            this.value = value;
            this.next = next;
        }
    }

    private Node[] list;
    private HashMap<String, Integer> hashByKey;
    private HashMap<Integer, String> hashByIndex;


    /**
     * 使用顶点初始化图
     *
     * @param vertices 顶点列表
     */
    @Override
    public void init(String[] vertices) {
        if (vertices == null || vertices.length == 0)
            throw new IllegalArgumentException();
        list = new Node[vertices.length];
        hashByKey = new HashMap<>();
        hashByIndex = new HashMap<>();

        for (int i = 0; i < vertices.length; i++) {
            hashByKey.put(vertices[i], i);
            hashByIndex.put(i, vertices[i]);
        }
    }

    /**
     * 添加边
     *
     * @param start 起始顶点
     * @param end   终止顶点
     */
    @Override
    public void addEdge(String start, String end) {
        addEdge(start, end, 0);
    }

    /**
     * 添加边
     *
     * @param start 起始顶点
     * @param end   终止顶点
     * @param value 权
     */
    @Override
    public void addEdge(String start, String end, int value) {
        if (!hashByKey.containsKey(start) ||
                !hashByKey.containsKey(end)) {
            throw new IllegalArgumentException();
        }

        int indexBegin = hashByKey.get(start);
        Node node = list[indexBegin];
        int indexEnd = hashByKey.get(end);

        if (node == null) {
            list[indexBegin] = new Node(indexEnd, value);
        } else {
            Node parent = null;
            Node item = node;

            while (item != null) {
                if (item.index == indexEnd) {
                    item.value = value;
                    return;
                } else if (item.index > indexEnd) {
                    break;
                } else {
                    parent = item;
                    item = item.next;
                }
            }

            if (parent == null) {
                list[indexBegin] = new Node(indexEnd, value, list[indexBegin]);
            } else {
                parent.next = new Node(indexEnd, value, parent.next);
            }
        }
    }

    /**
     * 添加边(双向的)
     *
     * @param start 顶点
     * @param end   顶点
     * @param value 权
     */
    @Override
    public void addDoubleEdge(String start, String end, int value) {
        addEdge(start, end, value);
        addEdge(end, start, value);
    }

    /**
     * 删除边
     *
     * @param start 起始顶点
     * @param end   终止顶点
     */
    @Override
    public void removeEdge(String start, String end) {
        if (!hashByKey.containsKey(start) ||
                !hashByKey.containsKey(end)) {
            throw new IllegalArgumentException();
        }

        int indexBegin = hashByKey.get(start);
        int indexEnd = hashByKey.get(end);
        Node node = list[indexBegin];

        if (node == null) return;

        Node parent = null;
        Node item = node;

        while (item != null && item.index != indexEnd) {
            item = item.next;
        }

        if (item != null) {
            if (parent == null) {
                list[indexBegin] = item.next;
            } else {
                parent.next = item.next;
            }
        }
    }

    /**
     * 打印所有的边
     * <p>
     * 打印规则：
     * 1. 边输出规则： A -> B
     * 2. 边的输出按照顶点的顺序输出
     *
     * @return
     */
    @Override
    public String[] printEdges() {
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) continue;

            Node node = list[i];
            String startKey = hashByIndex.get(i);

            while (node != null) {
                ret.add(String.format("%s -> %s", startKey, hashByIndex.get(node.index)));
                node = node.next;
            }
        }
        return ret.toArray(new String[0]);
    }

    /**
     * 打印深度优先搜索(DFS)结果
     *
     * @return 深度优先遍历结果，用","隔开
     */
    @Override
    public String printDepthFirstSearch() {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> listVisibled = new HashSet<>();

        stack.add(0);
        listVisibled.add(0);
        sb.append(String.format("%s,", hashByIndex.get(0)));

        while (!stack.empty()) {
            Integer index = stack.peek();

            if (list[index] != null) {
                Node node = list[index];

                while (node != null && listVisibled.contains(node.index)) {
                    node = node.next;
                }

                if (node != null) {
                    stack.add(node.index);
                    listVisibled.add(node.index);
                    sb.append(String.format("%s,", hashByIndex.get(node.index)));
                    continue;
                }
            }
            stack.pop();
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * 打印深度优先搜索(DFS)结果
     *
     * @return 深度优先遍历结果，用","隔开
     */
    @Override
    public String printBreadthFirstSearch() {
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> queue = new LinkedList<>();
        HashSet<Integer> listVisibled = new HashSet<>();

        queue.add(0);
        listVisibled.add(0);
        sb.append(String.format("%s,", hashByIndex.get(0)));

        while (!queue.isEmpty()) {
            Integer index = queue.poll();

            Node node = list[index];

            while (node != null) {
                if (!listVisibled.contains(node.index)) {
                    queue.add(node.index);
                    listVisibled.add(node.index);
                    sb.append(String.format("%s,", hashByIndex.get(node.index)));
                }
                node = node.next;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * 使用迪杰斯特拉算法打印最短路径,结果按照距离升序排列
     * <p>
     * 最短路径格式为
     * 顶点 -> 顶点 距离
     * 例如：A -> B 12
     *
     * @return 最短路径
     */
    @Override
    public String[] printShortestPathUsingDijkstra() {
        ArrayList<String> ret = new ArrayList<>();
        int[][] map = genericMap();
        String keyBegin = hashByIndex.get(0);
        int[] listVisible = new int[list.length];

        listVisible[0] = 1;

        for (int i = 1; i < list.length; i++) {
            int minDistance = Integer.MAX_VALUE;
            int indexMin = -1;

            for (int j = 1; j < list.length; j++) {
                if (listVisible[j] != 1 && map[0][j] != 0 && map[0][j] < minDistance) {
                    minDistance = map[0][j];
                    indexMin = j;
                }
            }

            if (indexMin == -1) {
                break;
            }
            listVisible[indexMin] = 1;
            ret.add(String.format("%s -> %s %d", keyBegin, hashByIndex.get(indexMin), minDistance));

            for (int j = 1; j < list.length; j++) {
                if (listVisible[j] != 1 && map[indexMin][j] != 0 && (map[0][j] == 0 || map[0][indexMin] + map[indexMin][j] < map[0][j])) {
                    map[0][j] = map[0][indexMin] + map[indexMin][j];
                }
            }
        }
        return ret.toArray(new String[0]);
    }

    private int[][] genericMap() {
        int[][] map = new int[list.length][list.length];

        for (int i = 0; i < list.length; i++) {
            Node node = list[i];

            while (node != null) {
                map[i][node.index] = node.value;
                node = node.next;
            }
        }
        return map;
    }

    /**
     * 使用弗洛伊德算法打印最短路径,结果按照距离升序排列
     * <p>
     * 最短路径格式为
     * 顶点 -> 顶点 距离
     * 例如：A -> B 12
     *
     * @return 最短路径
     */
    @Override
    public String[] printShortestPathUsingFloyd() {
        int[][] map = genericMap();
        for (int k = 0; k < list.length; k++) {
            for (int i = 0; i < list.length; i++) {
                for (int j = 0; j < list.length; j++) {
                    int tmp = map[i][k] == 0 || map[k][j] == 0
                            ? (map[i][j] == 0 ? 0 : map[i][j])
                            : (map[i][j] == 0 || map[i][k] + map[k][j] < map[i][j] ? map[i][k] + map[k][j] : map[i][j]);
                    map[i][j] = tmp;
                }
            }
        }
        PriorityQueue<Item> queue = new PriorityQueue<>();

        for (int i = 1; i < list.length; i++) {
            queue.add(new Item(i, map[0][i]));
        }
        String keyBegin = hashByIndex.get(0);
        String[] ret = new String[queue.size()];
        int i = 0;

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            ret[i++] = String.format("%s -> %s %d", keyBegin, hashByIndex.get(item.index), item.value);
        }
        return ret;
    }

    private static class Item implements Comparable<Item> {
        private int index;
        private int value;

        public Item(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Item o) {
            return Integer.compare(value, o.value);
        }
    }
}
