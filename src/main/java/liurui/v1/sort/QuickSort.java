package liurui.v1.sort;

import liurui.sorts.Sortable;

/***
 * 快速排序
 */
public class QuickSort implements Sortable {
    @Override
    public int[] sort(int[] data) {
        sort(data, 0, data.length - 1);
        return data;
    }


    private void sort(int[] data, int begin, int end) {
        if (begin >= end) return;
        int key = data[begin];
        int i = begin;
        int j = end;


        while (i < j) {
            while (i < j && data[j] > key) {
                j--;
            }

            if (i < j)
                data[i++] = data[j];

            while (i < j && data[i] <= key) {
                i++;
            }

            if (i < j)
                data[j--] = data[i];
        }
        data[i] = key;
        sort(data, 0, i -1);
        sort(data, i + 1, end);
    }
}
