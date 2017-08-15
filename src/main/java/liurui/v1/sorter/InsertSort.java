package liurui.v1.sorter;


/***
 * 插入排序
 */
public class InsertSort implements SortBase {
    @Override
    public int[] sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int tmp = data[i];
            int j = i;

            for (; j > 0 && data[j-1] > tmp; j--) {
                data[j] = data[j-1];
            }
            data[j] = tmp;
        }
        return data;
    }
}
