package liurui.v2.search;

public class SequentialSearch {
    public int find(int[] data, int item) {
        if (item == data[0]) return 0;
        int tmp = data[0];
        int i = data.length - 1;
        data[0] = item;

        while (data[i] != item) {
            i--;
        }
        data[0] = tmp;

        return i == 0 ? -1 : i;
    }
}
