package liurui.v4.searchs;

import liurui.defines.searchs.FindK;

import java.util.Arrays;

/**
 * 找出数组中第k大的数
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
        if (begin >= end) {
            return -1;
        }

        int mid = sort(ary, begin, end);
        int compare = Integer.compare(mid + 1, k);

        switch (compare) {
            case 0:
                return ary[mid];
            case 1:
                return find(ary, k, begin, mid - 1);
            case -1:
                return find(ary, k, mid + 1, end);
        }
        return -1;
    }

    private int sort(int[] ary, int begin, int end) {
        if (begin >= end) {
            return begin;
        }

        int i = begin;
        int j = end;
        int item = ary[i];


        while (i < j) {
            while (i < j && ary[j] < item) {
                j--;
            }

            if (i < j) {
                ary[i++] = ary[j];
            }

            while (i < j && ary[i] >= item) {
                i++;
            }

            if (i < j) {
                ary[j--] = ary[i];
            }
        }
        ary[i] = item;
        System.out.println(Arrays.toString(ary));
        return i;
    }
}
