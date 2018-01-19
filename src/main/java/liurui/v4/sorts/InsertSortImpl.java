package liurui.v4.sorts;

import liurui.defines.sorts.InsertSort;

/**
 * 插入排序
 */
public class InsertSortImpl implements InsertSort {
    @Override
    public int[] sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int item = data[i];
            int j = i;
            while (j > 0 && data[j - 1] > item) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = item;
        }
        return data;
    }
}
