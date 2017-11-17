package liurui.sorts;

/***
 * 堆排序
 */
public class BucketSort implements Sortable {
    @Override
    public int[] sort(int[] data) {
        int[] buckets = new int[10];

        for (int datum : data) {
            buckets[datum]++;
        }
        int t = 0;

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == 0) {
                continue;
            }

            for (int j = 0; j < buckets[i]; j++) {
                data[t++] = i;
            }
        }
        return data;
    }
}
