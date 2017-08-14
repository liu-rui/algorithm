package liurui.sorter;

import java.util.Arrays;

public class QuickSort {
    public int[] sort(int[] data) {
        sort(data, 0, data.length - 1);

        System.out.println(Arrays.toString(data));
        return data;
    }


    private void sort(int[] data, int begin, int end) {
        if (begin >= end) return;
        int key = data[begin];
        int i = begin;
        int j = end;

        while (i < j) {
            while (i < j && data[j] >= key) {
                j--;
            }

            if (i == j) break;
            data[i] = data[j];
            i++;

            while (i < j && data[i] <= key) {
                i++;
            }


            if (i == j) break;
            data[j] = data[i];
        }

        data[i] = key;


        sort(data, begin, i - 1);
        sort(data, i + 1, end);
    }
}
