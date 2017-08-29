package liurui.v2.sort;

import liurui.v1.sort.Sortable;

public class BucketSort implements Sortable {
    @Override
    public int[] sort(int[] data) {
        int[] bucket = new int[10];

        for (int datum : data) {
            bucket[datum]++;
        }

        int index = 0;

        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == 0) continue;
            int j = bucket[i];

            while (j > 0) {
                data[index++] = i;
                j--;
            }
        }

        return data;
    }
}
