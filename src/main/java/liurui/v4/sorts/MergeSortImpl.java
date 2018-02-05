package liurui.v4.sorts;

import liurui.defines.sorts.MergeSort;

/**
 * 归并排序
 */
public class MergeSortImpl implements MergeSort {
    int[] tmp;

    @Override
    public int[] sort(int[] data) {
        tmp = new int[data.length];
        sort(data, 0, data.length - 1);
        return data;
    }


    private void sort(int[] data, int begin, int end) {
        if (begin >= end) return;
        int mid = begin + (end - begin) / 2;

        sort(data, begin, mid);
        sort(data, mid + 1, end);
        merge(data, begin, mid, end);
    }

    private void merge(int[] data, int begin, int mid, int end) {
        int i = begin;
        int j = mid + 1;
        int k = begin;


        while (i <= mid && j <= end) {
            int compare = Integer.compare(data[i], data[j]);

            switch (compare) {
                case 0:
                    tmp[k++] = data[i++];
                    tmp[k++] = data[j++];
                    break;
                case 1:
                    tmp[k++] = data[j++];
                    break;
                case -1:
                    tmp[k++] = data[i++];
                    break;
            }
        }

        while (i <= mid) {
            tmp[k++] = data[i++];
        }

        while (j <= end) {
            tmp[k++] = data[j++];
        }

        k = begin;

        for (; k <= end; k++) {
            data[k] = tmp[k];
        }
    }
}
