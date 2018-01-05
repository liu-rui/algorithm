package liurui.v4.structures.graph;

import liurui.defines.structures.graph.GraphUsingList;

import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 图，使用邻接表表示
 */
public class GraphUsingListImpl implements GraphUsingList {
    private static class Node {
        private int index;
        private Node next;

        public Node(int index) {
            this.index = index;
        }

        public Node(int index, Node next) {
            this.index = index;
            this.next = next;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    Node[] list;
    HashMap<String, Integer> verticesByName = new HashMap<>();
    HashMap<Integer, String> verticesByIndex = new HashMap<>();

    @Override
    public void init(String[] vertices) {
        if (vertices == null || vertices.length == 0) throw new IllegalArgumentException();
        list = new Node[vertices.length];

        for (int i = 0; i < vertices.length; i++) {
            this.verticesByName.put(vertices[i], i);
            verticesByIndex.put(i, vertices[i]);
        }
    }

    @Override
    public void addEdge(String start, String end) {
        if (!verticesByName.containsKey(start) || !verticesByName.containsKey(end))
            throw new IllegalArgumentException();
        int beginIndex = verticesByName.get(start);
        int endIndex = verticesByName.get(end);

        if (list[beginIndex] == null) {
            list[beginIndex] = new Node(endIndex);
        } else {
            Node parent = null;
            Node item = list[beginIndex];

            while (item != null && item.getIndex() < endIndex) {
                parent = item;
                item = item.getNext();
            }

            if (item != null) {
                if (item.getIndex() == endIndex) {
                    return;
                } else {
                    Node newItem = new Node(endIndex, item);

                    if (parent == null) {
                        list[beginIndex] = newItem;
                    } else {
                        parent.setNext(newItem);
                    }
                }
            } else {
                parent.setNext(new Node(endIndex));
            }
        }
    }

    @Override
    public void removeEdge(String start, String end) {
        if (!verticesByName.containsKey(start) || !verticesByName.containsKey(end))
            throw new IllegalArgumentException();
        int beginIndex = verticesByName.get(start);
        int endIndex = verticesByName.get(end);

        if (list[beginIndex] == null) return;

        Node parent = null;
        Node item = list[beginIndex];

        while (item != null && item.getIndex() < endIndex) {
            parent = item;
            item = item.getNext();
        }

        if (item != null && item.getIndex() == endIndex) {
            if (parent == null) {
                list[beginIndex] = item.getNext();
            } else {
                parent.setNext(item.getNext());
            }
        }
    }

    @Override
    public String[] printEdges() {
        ArrayList<String> ret = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) continue;
            String begin = verticesByIndex.get(i);
            Node node = list[i];

            while (node != null) {
                ret.add(String.format("%s -> %s", begin, verticesByIndex.get(node.getIndex())));
                node = node.getNext();
            }
        }
        return ret.toArray(new String[0]);
    }
}
