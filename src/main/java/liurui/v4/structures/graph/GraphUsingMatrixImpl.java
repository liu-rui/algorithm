package liurui.v4.structures.graph;

import liurui.defines.sorts.MergeSort;
import liurui.defines.structures.graph.GraphUsingMatrix;

import java.util.*;

/**
 * 图，使用邻接矩阵表示
 */
public class GraphUsingMatrixImpl implements GraphUsingMatrix {
    int[][] matrix;
    HashMap<String, Integer> hashByKey = new HashMap<>();
    HashMap<Integer, String> hashByIndex = new HashMap<>();


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
        matrix = new int[vertices.length][vertices.length];

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
        matrix[hashByKey.get(start)][hashByKey.get(end)] = value;
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
        matrix[hashByKey.get(start)][hashByKey.get(end)] = 0;
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

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] > 0) {
                    ret.add(String.format("%s -> %s", hashByIndex.get(i), hashByIndex.get(j)));
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
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        HashSet<Integer> visibled = new HashSet<>();

        stack.push(0);
        visibled.add(0);
        sb.append(hashByIndex.get(0));
        sb.append(',');

        while (!stack.isEmpty()) {
            Integer index = stack.peek();
            boolean found = false;

            for (int i = 0; i < matrix.length; i++) {
                if (!visibled.contains(i) && matrix[index][i] > 0) {
                    stack.push(i);
                    visibled.add(i);
                    sb.append(hashByIndex.get(i));
                    sb.append(',');
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
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        HashSet<Integer> visibled = new HashSet<>();

        queue.add(0);
        visibled.add(0);
        sb.append(hashByIndex.get(0));
        sb.append(',');

        while (!queue.isEmpty()) {
            Integer index = queue.poll();

            for (int i = 0; i < matrix.length; i++) {
                if (!visibled.contains(i) && matrix[index][i] > 0) {
                    queue.add(i);
                    visibled.add(i);
                    sb.append(hashByIndex.get(i));
                    sb.append(',');
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
        int[][] map = genericMap();
        HashSet<Integer> visibled = new HashSet<>();
        ArrayList<String> ret = new ArrayList<>();

        visibled.add(0);

        for (int i = 1; i < map.length; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int j = 0; j < map.length; j++) {
                if (!visibled.contains(j) && map[0][j] != 0 && map[0][j] < minDistance) {
                    minDistance = map[0][j];
                    minIndex = j;
                }
            }

            if (minIndex == -1) {
                break;
            }
            visibled.add(minIndex);
            ret.add(String.format("%s -> %s %d", hashByIndex.get(0), hashByIndex.get(minIndex), minDistance));

            for (int j = 0; j < map.length; j++) {
                if (!visibled.contains(j) && map[minIndex][j] != 0 && (map[0][j] == 0 || map[minIndex][j] + minDistance < map[0][j])) {
                    map[0][j] = map[minIndex][j] + minDistance;
                }
            }
        }
        return ret.toArray(new String[0]);
    }

    private int[][] genericMap() {
        int[][] map = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                map[i][j] = matrix[i][j];
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
                            ? map[i][j]
                            : (map[i][j] == 0 || map[i][k] + map[k][j] < map[i][j] ? map[i][k] + map[k][j] : map[i][j]);
                }
            }
        }

        PriorityQueue<Item> queue = new PriorityQueue<>();
        for (int i = 1; i < map.length; i++) {
            queue.add(new Item(i, map[0][i]));
        }

        String[] ret = new String[queue.size()];

        for (int i = 0; i < ret.length; i++) {
            Item item = queue.poll();
            ret[i] = String.format("%s -> %s %d", hashByIndex.get(0), hashByIndex.get(item.index), item.distance);
        }
        return ret;
    }

    private static class Item implements Comparable<Item> {
        private int index;
        private int distance;

        public Item(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Item o) {
            return Integer.compare(distance, o.distance);
        }
    }
}
