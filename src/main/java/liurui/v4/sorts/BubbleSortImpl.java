package liurui.v4.sorts;

import liurui.defines.sorts.BubbleSort;

/**
 * 冒泡排序
 */
public class BubbleSortImpl implements BubbleSort {
    @Override
    public int[] sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = 1; j <= data.length - i; j++) {
                if (data[j - 1] > data[j]) {
                    int tmp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = tmp;
                }
            }
        }
        return data;
    }
}
