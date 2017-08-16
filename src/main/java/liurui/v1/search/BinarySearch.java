package liurui.v1.search;

public class BinarySearch {
    public int find(int[] data, int item) {
        int begin = 0;
        int end = data.length - 1;
        int cur = 0;

        while (begin < end) {
            if (begin == end - 1) {
                if (item == data[begin]) return begin;
                else if (item == data[end]) return end;
                else return -1;
            } else {
                cur = (end + begin) / 2;
            }

            if (data[cur] == item)
                return cur;
            else if (data[cur] > item)
                end = cur;
            else
                begin = cur;
        }

        return -1;
    }
}
