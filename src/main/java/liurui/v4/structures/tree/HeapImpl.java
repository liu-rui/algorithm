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
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException();
        }
        this.big = big;
        heap = new int[data.length + 1];

        for (int item : data) {
            heap[0]++;
            int i = heap[0];

            for (; i / 2 >= 1 && compare(item, heap[i / 2]); i /= 2) {
                heap[i] = heap[i / 2];
            }
            heap[i] = item;
        }
    }

    private boolean compare(int a, int b) {
        boolean ret = a > b;

        if (!big) {
            ret = !ret;
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
        if (heap == null || heap[0] == 0) {
            throw new IndexOutOfBoundsException();
        }
        int ret = heap[1];
        int item = heap[heap[0]];

        heap[0]--;
        int parent = 1;
        int child = 2;

        while (child <= heap[0]) {
            if (child + 1 <= heap[0] && compare(heap[child + 1], heap[child])) {
                child++;
            }

            if(compare(item, heap[child])){
                break;
            }else {
                heap[parent] = heap[child];
                parent=  child;
                child *=2;
            }
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
        return heap[0];
    }
}
