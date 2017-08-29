package liurui.v2.sort;

import liurui.v1.sort.Sortable;

public class SelectSort implements Sortable {
    @Override
    public int[] sort(int[] data) {

        for (int i = data.length - 1; i > 0; i--) {
            int max = i;

            for (int j = i - 1; j >= 0; j--) {
                if (data[j] > data[max])
                    max = j;
            }

            if (max != i) {
                int tmp = data[i];
                data[i] = data[max];
                data[max] = tmp;
            }
        }

        return data;
    }
}
