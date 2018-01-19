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

        while (begin <= end) {
            int mid = begin + (end - begin) / 2;

            if (data[mid] == item) {
                return mid;
            } else if (data[mid] > item) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return -1;
    }
}
