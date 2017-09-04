package liurui.v1.structure;

import java.util.HashMap;

public class Graph {
    HashMap<Integer, Integer> mapping = new HashMap<>();
    int[][] matrix;

    public Graph(int[] vertices) {
        matrix = new int[vertices.length][vertices.length];

        for (int i = 0; i < vertices.length; i++) {
            mapping.put(vertices[i], i);
        }
    }

    public void addEdge(int start, int end) {

        if(!mapping.containsKey(start) || !mapping.containsKey(end))
            throw new IllegalArgumentException();

        matrix[mapping.get(start)][mapping.get(end)] = 1;
    }

    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(String.format("%5s", matrix[i][j]));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(new int[]{0, 1, 2, 3});

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 2);
        graph.print();

    }
}
