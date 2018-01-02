package liurui.v3.sorts;

import liurui.sorts.Sortable;

public class BucketSort implements Sortable {
    @Override
    public int[] sort(int[] data) {
        int[] ret = new int[data.length];
        int[] buckets = new int[10];

        for (int item : data) {
            buckets[item]++;
        }

        int index = 0;

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == 0) continue;

            for (int j = 0; j < buckets[i]; j++) {
                ret[index++] = i;
            }
        }

        return ret;
    }
}
