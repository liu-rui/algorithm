package liurui.v4.searchs;

import liurui.defines.searchs.BinarySearch;

/**
 * 二分查找法，数组事先已经升序排列，不用考虑排序问题
 */
public class BinarySearchImpl implements BinarySearch {
    @Override
    public int find(int[] data, int item) {
        if (data == null || data.length == 0) return -1;

        int begin = 0;
        int end = data.length - 1;
        int current;

        while (begin <= end) {
            current = begin + (end - begin) / 2;

            if (data[current] == item) {
                return current;
            } else if (data[current] > item) {
                end = current - 1;
            } else {
                begin = current + 1;
            }
        }
        return -1;
    }
}
