package liurui.v4.structures.graph;

import liurui.defines.structures.graph.GraphUsingMatrix;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 图，使用邻接矩阵表示
 */
public class GraphUsingMatrixImpl implements GraphUsingMatrix {
    int[][] matrix;
    HashMap<String, Integer> verticesByName = new HashMap<>();
    HashMap<Integer,String> verticesByIndex = new HashMap<>();

    @Override
    public void init(String[] vertices) {
        if (vertices == null || vertices.length == 0) throw new IllegalArgumentException();

        matrix = new int[vertices.length][vertices.length];

        for (int i = 0; i < vertices.length; i++) {
            this.verticesByName.put(vertices[i], i);
            verticesByIndex.put(i , vertices[i]);
        }
    }

    @Override
    public void addEdge(String start, String end) {
        if (!verticesByName.containsKey(start) || !verticesByName.containsKey(end)) throw new IllegalArgumentException();
        matrix[verticesByName.get(start)][verticesByName.get(end)] = 1;
    }

    @Override
    public void removeEdge(String start, String end) {
        if (!verticesByName.containsKey(start) || !verticesByName.containsKey(end)) throw new IllegalArgumentException();
        matrix[verticesByName.get(start)][verticesByName.get(end)] = 0;
    }

    @Override
    public String[] printEdges() {
        ArrayList<String>  edges = new ArrayList<>();

        for (int i = 0; i< matrix.length;i++){
            for (int j = 0;j< matrix.length;j++){
                if(matrix[i][j] == 1){
                    edges.add(String.format("%s -> %s", verticesByIndex.get(i) , verticesByIndex.get(j)));
                }
            }
        }
        return edges.toArray(new String[0]);
    }
}
