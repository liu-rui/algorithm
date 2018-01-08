package liurui.v4.structures.graph;

import liurui.defines.structures.graph.GraphUsingMatrix;

import java.nio.file.Path;
import java.util.*;

/**
 * 图，使用邻接矩阵表示
 */
public class GraphUsingMatrixImpl implements GraphUsingMatrix {
    int[][] matrix;
    HashMap<String, Integer> verticesByName = new HashMap<>();
    HashMap<Integer, String> verticesByIndex = new HashMap<>();

    @Override
    public void init(String[] vertices) {
        if (vertices == null || vertices.length == 0) throw new IllegalArgumentException();

        matrix = new int[vertices.length][vertices.length];

        for (int i = 0; i < vertices.length; i++) {
            this.verticesByName.put(vertices[i], i);
            verticesByIndex.put(i, vertices[i]);
        }
    }

    @Override
    public void addEdge(String start, String end) {
        addEdge(start, end, 1);
    }

    @Override
    public void addEdge(String start, String end, int value) {
        if (!verticesByName.containsKey(start) || !verticesByName.containsKey(end))
            throw new IllegalArgumentException();
        matrix[verticesByName.get(start)][verticesByName.get(end)] = value;
    }

    @Override
    public void removeEdge(String start, String end) {
        if (!verticesByName.containsKey(start) || !verticesByName.containsKey(end))
            throw new IllegalArgumentException();
        matrix[verticesByName.get(start)][verticesByName.get(end)] = 0;
    }

    @Override
    public String[] printEdges() {
        ArrayList<String> edges = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] > 0) {
                    edges.add(String.format("%s -> %s", verticesByIndex.get(i), verticesByIndex.get(j)));
                }
            }
        }
        return edges.toArray(new String[0]);
    }

    @Override
    public String printDepthFirstSearch() {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();

        stack.add(0);
        visited.add(0);
        sb.append(verticesByIndex.get(0) + ",");

        while (!stack.empty()) {
            Integer currentNode = stack.peek();
            boolean hadNotVisitNode = false;

            for (int i = 0; i < matrix.length; i++) {
                if (matrix[currentNode][i] == 0 || visited.contains(i)) continue;
                stack.add(i);
                visited.add(i);
                sb.append(verticesByIndex.get(i) + ",");
                hadNotVisitNode = true;
                break;
            }

            if (!hadNotVisitNode) {
                stack.pop();
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override
    public String printBreadthFirstSearch() {
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        queue.add(0);
        visited.add(0);
        sb.append(verticesByIndex.get(0) + ",");

        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();

            for (int i = 0; i < matrix.length; i++) {
                if (matrix[currentNode][i] > 0 && !visited.contains(i)) {
                    queue.add(i);
                    visited.add(i);
                    sb.append(verticesByIndex.get(i) + ",");
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override
    public String[] printShortestPathUsingDijkstra() {
        return new String[0];
    }

    @Override
    public String[] printShortestPathUsingFloyd() {
        return new String[0];
    }
}
