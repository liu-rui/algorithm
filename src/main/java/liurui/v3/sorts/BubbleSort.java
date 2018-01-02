package liurui.v3.sorts;

import liurui.sorts.Sortable;

public class BubbleSort implements Sortable {
    @Override
    public int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int max = 0;
            for (int j = 1; j < data.length - i; j++) {
                if (data[j] > data[max]) {
                    max = j;
                }
            }

            if (max != data.length - i - 1) {
                int tmp = data[max];
                data[max] = data[data.length - i - 1];
                data[data.length - i - 1] = tmp;
            }
        }
        return data;
    }
}
