package liurui.v4.searchs;

import liurui.defines.searchs.BinarySearch;

/**
 * 二分查找法，数组事先已经升序排列，不用考虑排序问题
 */
public class BinarySearchImpl implements BinarySearch {
    @Override
    public int find(int[] data, int item) {
        int begin = 0;
        int end = data.length - 1;

        while (begin <= end) {
            int mid = begin + (end - begin) / 2;

            int compare = Integer.compare(data[mid], item);

            switch (compare) {
                case 0:
                    return mid;
                case 1:
                    end = mid - 1;
                    break;
                case -1:
                    begin = mid + 1;
                    break;
            }
        }
        return -1;
    }
}
