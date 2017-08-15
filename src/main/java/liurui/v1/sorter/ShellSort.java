package liurui.v1.sorter;

import java.util.Arrays;

/***
 * 希尔排序
 */
public class ShellSort implements SortBase {
    @Override
    public int[] sort(int[] data) {
        for (int i = data.length / 2; i > 0; i /= 2) {
            for (int j = 0; j < data.length; j+=i) {
                for (int p = j + i; p < data.length; p += i) {
                    int tmp = data[p];
                    int k = p;
                    for (; k > j && data[k - i] > tmp; k -= i) {
                        data[k] = data[k - i];
                    }
                    data[k] = tmp;
                }

            }
        }
        return data;
    }
}
