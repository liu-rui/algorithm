package liurui.v1.sort;

import liurui.sorts.Sortable;

public class HeapSort implements Sortable {
    @Override
    public int[] sort(int[] data) {
        int[] ret = build(data);

        sortPrivate(ret);

        for (int i = 0; i < data.length; i++) {
            data[i] = ret[i + 1];
        }
        return data;
    }

    private int[] build(int[] data) {
        int[] ret = new int[data.length + 1];

        for (int item : data) {
            ret[0]++;

            int i = ret[0];

            while (i > 1 && item > ret[i / 2]) {
                ret[i] = ret[i / 2];
                i /= 2;
            }
            ret[i] = item;
        }
        return ret;
    }


    private void sortPrivate(int[] data) {
        while (data[0] > 1) {
            int tmp = data[data[0]];
            data[data[0]] = data[1];
            data[1] = tmp;
            data[0]--;

            int i = 1;

            while (i * 2 <= data[0]) {
                if (i * 2 + 1 <= data[0] && data[i * 2 + 1] > data[i * 2] && data[i * 2 + 1] > tmp) {
                    data[i] = data[i * 2 + 1];
                    i = i * 2 + 1;
                } else if (data[i * 2] > tmp) {
                    data[i] = data[i * 2];
                    i = i * 2;
                } else
                    break;
            }
            data[i] = tmp;
        }
    }
}
