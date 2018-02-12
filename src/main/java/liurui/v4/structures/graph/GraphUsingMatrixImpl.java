package liurui.v4.structures.graph;

import liurui.defines.structures.graph.GraphUsingMatrix;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 图，使用邻接矩阵表示
 */
public class GraphUsingMatrixImpl implements GraphUsingMatrix {
    int[][] matric;
    HashMap<String, Integer> hashMapByKey = new HashMap<>();
    HashMap<Integer, String> hashMapByIndex = new HashMap<>();

    /**
     * 使用顶点初始化图
     *
     * @param vertices 顶点列表
     */
    @Override
    public void init(String[] vertices) {
        matric = new int[vertices.length][vertices.length];

        for (int i = 0; i < vertices.length; i++) {
            hashMapByKey.put(vertices[i], i);
            hashMapByIndex.put(i, vertices[i]);
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
        if (!hashMapByKey.containsKey(start) || !hashMapByKey.containsKey(end)) {
            throw new IllegalArgumentException();
        }

        matric[hashMapByKey.get(start)][hashMapByKey.get(end)] = value;
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
        if (!hashMapByKey.containsKey(start) || !hashMapByKey.containsKey(end)) {
            throw new IllegalArgumentException();
        }

        matric[hashMapByKey.get(start)][hashMapByKey.get(end)] = 0;
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

        for (int i = 0; i < hashMapByKey.size(); i++) {
            for (int j = 0; j < hashMapByKey.size(); j++) {
                if (matric[i][j] == 0) {
                    continue;
                }
                ret.add(String.format("%s -> %s", hashMapByIndex.get(i), hashMapByIndex.get(j)));
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
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[hashMapByKey.size()];

        stack.push(0);
        visited[0] = true;
        sb.append(hashMapByIndex.get(0));
        sb.append(',');

        while (!stack.isEmpty()) {
            Integer curIndex = stack.peek();
            boolean found = false;

            for (int i = 0; i < hashMapByIndex.size(); i++) {
                if (curIndex != i && !visited[i] && matric[curIndex][i] != 0) {
                    stack.push(i);
                    visited[i] = true;
                    sb.append(hashMapByIndex.get(i));
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
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[hashMapByKey.size()];

        queue.add(0);
        visited[0] = true;
        sb.append(hashMapByIndex.get(0));
        sb.append(',');

        while (!queue.isEmpty()) {
            Integer curIndex = queue.poll();

            for (int i = 0; i < hashMapByIndex.size(); i++) {
                if (curIndex != i && !visited[i] && matric[curIndex][i] != 0) {
                    queue.add(i);
                    visited[i] = true;
                    sb.append(hashMapByIndex.get(i));
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
        int[][] map = copyMatric();
        ArrayList<String> ret = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();

        visited.add(0);

        for (int i = 1; i < map.length; i++) {
            int curIndex = -1;
            int minValue = Integer.MAX_VALUE;


            for (int j = 1; j < map.length; j++) {
                if (map[0][j] > 0 && !visited.contains(j) && map[0][j] < minValue) {
                    curIndex = j;
                    minValue = map[0][j];
                }
            }

            if (curIndex == -1) {
                break;
            }

            visited.add(curIndex);
            ret.add(String.format("%s -> %s %d", hashMapByIndex.get(0), hashMapByIndex.get(curIndex), minValue));


            for (int j = 1; j < map.length; j++) {
                if (!visited.contains(j) && map[curIndex][j] > 0 && (map[0][j] <= 0 || minValue + map[curIndex][j] < map[0][j])) {
                    map[0][j] = minValue + map[curIndex][j];
                }
            }
        }
        return ret.toArray(new String[ret.size()]);
    }

    private int[][] copyMatric() {
        int[][] ret = new int[matric.length][matric.length];

        for (int i = 0; i < matric.length; i++) {
            for (int j = 0; j < matric.length; j++) {
                ret[i][j] = matric[i][j];
            }
        }
        return ret;
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
        int[][] map = copyMatric();

        for (int k = 0; k < map.length; k++) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    map[i][j] = map[i][k] == 0 || map[k][j] == 0
                            ? map[i][j]
                            : (map[i][j] == 0 || map[i][k] + map[k][j] < map[i][j]) ? map[i][k] + map[k][j] : map[i][j];
                }
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();

        for (int i = 1; i < map.length; i++) {
            queue.add(new Node(i, map[0][i]));
        }
        ArrayList<String> ret = new ArrayList<>();
        int i = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            ret.add(String.format("%s -> %s %d", hashMapByIndex.get(0), hashMapByIndex.get(node.index), node.height));
        }
        return ret.toArray(new String[ret.size()]);
    }

    private static class Node implements Comparable<Node> {
        private int index;
        private int height;

        public Node(int index, int height) {
            this.index = index;
            this.height = height;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(height, o.height);
        }
    }
}
