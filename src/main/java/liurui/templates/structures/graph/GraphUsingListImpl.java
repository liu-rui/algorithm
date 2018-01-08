package liurui.templates.structures.graph;

import liurui.defines.structures.graph.GraphUsingList;

/**
 * 图，使用邻接表表示
 */
public class GraphUsingListImpl implements GraphUsingList {
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
    public void addDoubleEdge(String start, String end, int value) {

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
