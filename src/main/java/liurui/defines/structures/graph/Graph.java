package liurui.defines.structures.graph;

/**
 * 图
 */
public interface Graph {

    /**
     * 使用顶点初始化图
     *
     * @param vertices 顶点列表
     */
    void init(String[] vertices);

    /**
     * 添加边
     *
     * @param start 起始顶点
     * @param end   终止顶点
     */
    void addEdge(String start, String end);

    /**
     * 删除边
     *
     * @param start 起始顶点
     * @param end   终止顶点
     */
    void removeEdge(String start, String end);

    /**
     * 打印所有的边
     *
     * @return
     */
    String[] printEdges();
}
