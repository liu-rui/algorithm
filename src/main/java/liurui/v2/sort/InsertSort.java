package liurui.v2.sort;

import liurui.sorts.Sortable;

public class InsertSort implements Sortable {
    @Override
    public int[] sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int tmp = data[i];
            int j = i;
            for (;j > 0 && tmp < data[j - 1]; j--) {
                data[j] = data[j-1];
            }
            data[j] = tmp;
        }

        return data;
    }
}
