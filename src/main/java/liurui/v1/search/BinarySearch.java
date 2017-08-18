package liurui.v1.search;

public class BinarySearch {
    public int find(int[] data, int item) {
        int begin = 0;
        int end = data.length - 1;
        int cur;

        while (begin < end) {
            cur = (begin + end) / 2;
            if (data[cur] == item)
                return cur;
            else if (data[cur] > item)
                end = cur - 1;
            else
                begin = cur + 1;
        }
        return -1;
    }
}
