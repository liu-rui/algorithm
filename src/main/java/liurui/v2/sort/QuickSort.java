package liurui.v2.sort;

import liurui.v1.sort.Sortable;

import java.util.Arrays;

public class QuickSort implements Sortable {
    @Override
    public int[] sort(int[] data) {
        sort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
        return data;
    }

    private void sort(int[] data, int begin, int end) {
        if (begin >= end) return;

        int i = begin;
        int j = end;
        int tmp = data[i];


        while (i < j) {
            while (i < j && data[j] >= tmp) {
                j--;
            }

            if (i < j) {
                data[i++] = data[j];
            }

            while (i < j && data[i] < tmp) {
                i++;
            }

            if (i < j) {
                data[j--] = data[i];
            }
        }

        data[i] = tmp;
        sort(data, begin, i - 1);
        sort(data, i + 1, end);
    }
}
