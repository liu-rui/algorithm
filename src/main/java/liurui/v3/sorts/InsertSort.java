package liurui.v3.sorts;

import liurui.sorts.Sortable;

public class InsertSort implements Sortable {
    @Override
    public int[] sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int item = data[i];
            int j = i;

            for (; j > 0 && data[j - 1] > item; j--) {
                data[j] = data[j - 1];
            }
            data[j] = item;
        }
        return data;
    }
}
