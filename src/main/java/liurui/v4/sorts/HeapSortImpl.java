package liurui.v4.sorts;


import liurui.defines.sorts.HeapSort;

/**
 * 堆排序
 */
public class HeapSortImpl implements HeapSort {
    @Override
    public int[] sort(int[] data) {
        int[] heap = new int[data.length + 1];


        for (int item : data) {
            heap[0]++;

            int i = heap[0];

            while (i / 2 > 0 && heap[i / 2] > item) {
                heap[i] = heap[i / 2];
                i /= 2;
            }
            heap[i] = item;
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = heap[1];

            int item = heap[heap[0]];
            int parent =  1;
            int child = 2;

            heap[0]--;

            if(heap[0] == 0){
                break;
            }

            while (child<= heap[0]){
                if(child+ 1 <= heap[0] &&   heap[child]> heap[child+1]){
                    child++;
                }

                if(heap[child]> item){
                    break;
                }
                heap[parent] = heap[child];
                parent= child;
                child *=2;
            }
            heap[parent] = item;
        }
        return data;
    }
}
