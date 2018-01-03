package liurui.answers.sorts;

import liurui.defines.sorts.HeapSort;

public class HeapSortImpl implements HeapSort {
    @Override
    public int[] sort(int[] data) {
        int[] heap = buildHeap(data);


        while (heap[0] != 0) {
            data[heap[0] - 1] = heap[1];
            heap[1] = heap[heap[0]];
            heap[0]--;

            int tmp = heap[1];
            int i = 1;

            while (i * 2 <= heap[0]) {
                if (i * 2 + 1 <= heap[0] && heap[i * 2 + 1] > heap[i * 2] &&  heap[i * 2 + 1] > tmp){
                    heap[i] = heap[i * 2 + 1];
                    i = i * 2 + 1;
                } else if (heap[i * 2] > tmp) {
                    heap[i] = heap[i * 2];
                    i = i * 2;
                } else {
                    break;
                }
            }
            heap[i] = tmp;
        }
        return data;
    }

    private int[] buildHeap(int[] data) {
        int[] heap = new int[data.length + 1];

        for (int datum : data) {
            heap[0]++;
            int i = heap[0];

            while (i / 2 > 0 && heap[i / 2] < datum) {
                heap[i] = heap[i / 2];
                i /= 2;
            }

            heap[i] = datum;

        }

        return heap;
    }
}
