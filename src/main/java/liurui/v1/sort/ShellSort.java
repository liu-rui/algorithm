package liurui.v1.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/***
 * 希尔排序
 */
public class ShellSort implements Sortable {

    @Override
    public int[] sort(int[] data) {
        int temp;
        for (int i = data.length / 2; i > 0; i /= 2) {
            for (int j = i; j < data.length; j++) {
                for (int k = j; k >= i; k -= i) {
                    if (data[k] < data[k - i]) {
                        temp = data[k];
                        data[k] = data[k - i];
                        data[k - i] = temp;
                    }
                }
            }
        }
        return data;
    }
}
