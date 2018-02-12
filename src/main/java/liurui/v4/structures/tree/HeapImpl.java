package liurui.v4.structures.tree;

import liurui.defines.structures.tree.Heap;

import java.util.Arrays;

/**
 * 堆
 */
public class HeapImpl implements Heap {
    private int[] heap;
    private boolean big;


    /**
     * 初始化堆
     *
     * @param big  如果为真创建大顶堆，否则创建小顶堆
     * @param data 数据
     */
    @Override
    public void init(boolean big, int[] data) {
        this.big = big;
        heap = new int[data.length + 1];

        for (int item : data) {
            push(item);
        }
    }

    private void push(int data) {
        heap[0]++;
        int i = heap[0];

        while (i / 2 >= 1 && compare(data, heap[i / 2]) > 0) {
            heap[i] = heap[i / 2];
            i /= 2;
        }
        heap[i] = data;
    }

    private int compare(int a, int b) {
        int ret = Integer.compare(a, b);

        if (!big) {
            ret *= -1;
        }
        return ret;
    }

    /**
     * 弹出最顶的数据
     *
     * @return 数据
     */
    @Override
    public int pop() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException();
        }
        int ret = heap[1];
        int parent = 1;
        int child = 2;
        int item = heap[heap[0]];
        heap[0]--;

        if (heap[0] == 0) {
            return ret;
        }

        while (child <= heap[0]) {
            if (child + 1 <= heap[0] && compare(heap[child + 1], heap[child]) > 0) {
                child++;
            }

            if (compare(item, heap[child]) > 0) {
                break;
            }

            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = item;
        return ret;
    }

    /**
     * 堆成员个数
     *
     * @return 成员个数
     */
    @Override
    public int size() {
        return heap == null || heap.length == 0 ? 0 : heap[0];
    }
}
