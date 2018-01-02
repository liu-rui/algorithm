package liurui.v3.sorts;

import liurui.sorts.Sortable;

public class SelectSort implements Sortable {
    @Override
    public int[] sort(int[] data) {
        for (int i = data.length - 1; i >= 0; i--) {
            int max = i;

            for (int j = i - 1; j >= 0; j--) {
                if (data[j] > data[max]) {
                    max = j;
                }
            }

            if (max != i) {
                int tmp = data[max];
                data[max] = data[i];
                data[i] = tmp;
            }
        }
        return data;
    }
}
