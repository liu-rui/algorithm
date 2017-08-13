package liurui;

public class MyBucketSort {

    public int[] sort(int[] data) {
        int[] bucketArray = new int[20];


        for (int value : data) {
            bucketArray[value]++;
        }

        int cur = 0;

        for (int i = bucketArray.length - 1; i >= 0; i--) {

            if (bucketArray[i] == 0)
                continue;


            for (int j = 0; j < bucketArray[i]; j++)
                data[cur++] = i;
        }

        return data;
    }
}
