package liurui.v4.searchs;

import liurui.defines.searchs.FindK;

import java.lang.reflect.WildcardType;

/**
 * 找出数组中第k大的数
 * 时间复杂度为O(N)
 */
public class FindKImpl implements FindK {

    /**
     * 找出数组中第k大的数
     *
     * @param ary 数组
     * @param k   第k
     * @return 第k大的数
     */
    @Override
    public int find(int[] ary, int k) {
        return find(ary, k, 0, ary.length - 1);
    }

    private int find(int[] ary, int k, int begin, int end) {
        int i = sort(ary, begin, end);

        if (i + 1 > k) {
            return find(ary, k, begin, i - 1);
        } else if (i + 1 < k) {
            return find(ary, k, i + 1, end);
        } else {
            return ary[i];
        }
    }

    private int sort(int[] ary, int begin, int end) {
        if (begin >= end) return begin;
        int item = ary[begin];

        while (begin < end) {
            while (begin < end && ary[end] < item) {
                end--;
            }

            if (begin < end) {
                ary[begin++] = ary[end];
            }

            while (begin < end && ary[begin] >= item) {
                begin++;
            }

            if (begin < end) {
                ary[end--] = ary[begin];
            }
        }
        ary[begin] = item;
        return begin;
    }
}
