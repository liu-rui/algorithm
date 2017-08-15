package liurui.v1.sort;


/***
 * 桶排序
 */
public class BucketSort implements Sortable {


    @Override
    public int[] sort(int[] data) {
        int[] bucketArray = new int[20];

        for (int i : data) {
            bucketArray[i]++;
        }


        int[] ret = new int[data.length];
        int index = 0;

        for (int i = 0; i < bucketArray.length; i++) {
            if (bucketArray[i] == 0) continue;

            for (int j = 0; j < bucketArray[i]; j++) {
                ret[index++] = i;
            }
        }
        return ret;
    }
}
