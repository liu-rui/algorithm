package liurui.v4.structures.graph;

import liurui.defines.structures.graph.GraphUsingMatrix;

import java.util.*;

/**
 * 图，使用邻接矩阵表示
 */
public class GraphUsingMatrixImpl implements GraphUsingMatrix {
    private int[][] metrix;
    private HashMap<String, Integer> hashByKey;
    private HashMap<Integer, String> hashByIndex;

    /**
     * 使用顶点初始化图
     *
     * @param vertices 顶点列表
     */
    @Override
    public void init(String[] vertices) {
        if (vertices == null || vertices.length == 0) {
            throw new IllegalArgumentException();
        }
        metrix = new int[vertices.length][vertices.length];
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
        addEdge(start, end, 1);
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
        if (!hashByKey.containsKey(start) || !hashByKey.containsKey(end)) {
            throw new IllegalArgumentException();
        }
        metrix[hashByKey.get(start)][hashByKey.get(end)] = value;
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
        if (!hashByKey.containsKey(start) || !hashByKey.containsKey(end)) {
            throw new IllegalArgumentException();
        }
        metrix[hashByKey.get(start)][hashByKey.get(end)] = 0;
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

        for (int i = 0; i < metrix.length; i++) {
            String keyBegin = hashByIndex.get(i);
            for (int j = 0; j < metrix.length; j++) {
                if (metrix[i][j] != 0) {
                    ret.add(String.format("%s -> %s", keyBegin, hashByIndex.get(j)));
                }
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
        int[] listVisibled = new int[metrix.length];

        stack.add(0);
        listVisibled[0] = 1;
        sb.append(String.format("%s,", hashByIndex.get(0)));

        while (!stack.isEmpty()) {
            Integer index = stack.peek();
            boolean found = false;

            for (int i = 0; i < metrix.length; i++) {
                if (listVisibled[i] == 0 && metrix[index][i] != 0) {
                    stack.add(i);
                    listVisibled[i] = 1;
                    sb.append(String.format("%s,", hashByIndex.get(i)));
                    found = true;
                    break;
                }
            }

            if (!found) {
                stack.pop();
            }
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
        int[] listVisibled = new int[metrix.length];

        queue.add(0);
        listVisibled[0] = 1;
        sb.append(String.format("%s,", hashByIndex.get(0)));

        while (!queue.isEmpty()) {
            Integer index = queue.poll();

            for (int i = 0; i < metrix.length; i++) {
                if (listVisibled[i] == 0 && metrix[index][i] != 0) {
                    queue.add(i);
                    listVisibled[i] = 1;
                    sb.append(String.format("%s,", hashByIndex.get(i)));
                }
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
        int[] listVisibled = new int[metrix.length];

        listVisibled[0] = 1;

        for (int i = 1; i < metrix.length; i++) {
            int minDistance = Integer.MAX_VALUE;
            int indexMin = -1;

            for (int j = 0; j < metrix.length; j++) {
                if (listVisibled[j] == 0 && map[0][j] != 0 && map[0][j] < minDistance) {
                    minDistance = map[0][j];
                    indexMin = j;
                }
            }

            if (indexMin == -1) {
                break;
            }

            listVisibled[indexMin] = 1;
            ret.add(String.format("%s -> %s %d", keyBegin, hashByIndex.get(indexMin), map[0][indexMin]));

            for (int j = 0; j < metrix.length; j++) {
                if (listVisibled[j] == 0 && map[indexMin][j] != 0 && (minDistance + map[indexMin][j] < map[0][j] || map[0][j] == 0)) {
                    map[0][j] = minDistance + map[indexMin][j];
                }
            }
        }
        return ret.toArray(new String[0]);
    }

    private int[][] genericMap() {
        int[][] map = new int[metrix.length][metrix.length];

        for (int i = 0; i < metrix.length; i++) {
            for (int j = 0; j < metrix.length; j++) {
                map[i][j] = metrix[i][j];
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


        for (int k = 0; k < map.length; k++) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    map[i][j] = map[i][k] == 0 || map[k][j] == 0
                            ? (map[i][j] == 0 ? 0 : map[i][j])
                            : (map[i][j] == 0 || map[i][k] + map[k][j] < map[i][j] ? map[i][k] + map[k][j] : map[i][j]);
                }
            }
        }

        PriorityQueue<Item> queue = new PriorityQueue<>();
        for (int i = 1; i < map.length; i++) {
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
