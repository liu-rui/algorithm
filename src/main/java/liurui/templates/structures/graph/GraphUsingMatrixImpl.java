package liurui.templates.structures.graph;

import liurui.defines.structures.graph.GraphUsingMatrix;

/**
 * 图，使用邻接矩阵表示
 */
public class GraphUsingMatrixImpl  implements GraphUsingMatrix {
    @Override
    public void init(String[] vertices) {

    }

    @Override
    public void addEdge(String start, String end) {

    }

    @Override
    public void addEdge(String start, String end, int value) {

    }

    @Override
    public void removeEdge(String start, String end) {

    }

    @Override
    public String[] printEdges() {
        return new String[0];
    }

    @Override
    public String printDepthFirstSearch() {
        return null;
    }

    @Override
    public String printBreadthFirstSearch() {
        return null;
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