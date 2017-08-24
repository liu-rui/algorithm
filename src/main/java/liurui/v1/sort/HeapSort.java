package liurui.v1.sort;

import java.util.Arrays;

public class HeapSort implements Sortable {
    @Override
    public int[] sort(int[] data) {
        int[] ret = build(data);

        System.out.println(Arrays.toString(ret));
        sortPrivate(ret);
        return ret;
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
        int i = 2;


    }
}
