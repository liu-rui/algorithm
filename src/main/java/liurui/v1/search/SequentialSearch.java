package liurui.v1.search;

/***
 * 顺序查找
 */
public class SequentialSearch {
    public int find(int[] data, int item) {
        if (data[0] == item) return 0;

        int tmp = data[0];
        data[0] = item;

        int i = data.length - 1;

        while (data[i] != item) {
            i--;
        }

        data[0] = tmp;
        return i == 0 ? -1 : i;
    }
}
