package liurui.v4.sorts;

import liurui.defines.sorts.SelectSort;

/**
 * 选择排序
 */
public class SelectSortImpl implements SelectSort {
    @Override
    public int[] sort(int[] data) {
        for (int i = data.length - 1; i > 0; i--) {
            int max = i;

            for (int j = 0; j < i; j++) {
                if (data[j] > data[max]) {
                    max = j;
                }
            }

            if (max != i) {
                int tmp = data[max];
                data[max] = data[i];
                data[i] = tmp;
            }
        }
        return data;
    }
}
