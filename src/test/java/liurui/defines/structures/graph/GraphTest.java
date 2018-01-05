package liurui.defines.structures.graph;

import static org.junit.Assert.*;


public class GraphTest {

    public void test(Graph graph) {
        graph.init(new String[]{"A", "B", "C", "D"});

        graph.addEdge("A", "C"); //故意在A->B之前设置
        graph.addEdge("A", "B");
        graph.addEdge("A", "D");
        graph.addEdge("B", "C");
        graph.addEdge("B", "C"); //故意重复设置
        graph.addEdge("D", "C");
        assertArrayEquals(new String[]{
                        "A -> B",
                        "A -> C",
                        "A -> D",
                        "B -> C",
                        "D -> C"}
                , graph.printEdges());
    }
}
