package liurui.sorts;

/***
 * 快速排序
 */
public class QuickSort implements Sortable {
    @Override
    public int[] sort(int[] data) {
        sort(data, 0, data.length - 1);
        return data;
    }

    private void sort(int[] data, int start, int end) {
        if(start >= end) return;

        int i = start;
        int j = end;
        int item = data[start];

        while (i < j) {
            while (i < j && data[j] > item)
                j--;

            if (i < j)
                data[i++] = data[j];

            while (i < j && data[i] <= item)
                i++;

            if (i < j)
                data[j--] = data[i];
        }

        data[i] = item;
        sort(data, start, i - 1);
        sort(data, i + 1, end);
    }
}
