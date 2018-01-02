package liurui.v3.questions;

import liurui.sorts.Sortable;

public class OddEvenSort implements Sortable {
    @Override
    public int[] sort(int[] data) {
        int begin = 0;
        int end = data.length - 1;

        while (begin < end) {
            while (begin < end && data[begin] % 2 == 1) {
                begin++;
            }

            while (begin < end && data[end] % 2 == 0) {
                end--;
            }

            if (begin < end) {
                int tmp = data[begin];
                data[begin] = data[end];
                data[end] = tmp;
                begin++;
                end--;
            }
        }
        return data;
    }
}
