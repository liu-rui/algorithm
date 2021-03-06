package liurui.v4.structures.array;

import liurui.defines.structures.array.FindMaxSumSubArrayUsingExhaustive;

import java.util.Arrays;

/**
 * 找出连加值最大的子数组，使用穷举法
 * 子数组：数组中连续的一部分
 * 时间复杂度为O(N^3)
 */
public class FindMaxSumSubArrayUsingExhaustiveImpl implements FindMaxSumSubArrayUsingExhaustive {
    /**
     * 找出连加值最大的子数组
     *
     * @param ary 原数组
     * @return 子数组
     */
    @Override
    public int[] find(int[] ary) {
        int begin = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < ary.length; i++) {
            for (int j = i; j < ary.length; j++) {
                int tmp = 0;

                for (int k = i; k <= j; k++) {
                    tmp += ary[k];
                }

                if (tmp > max) {
                    max = tmp;
                    begin = i;
                    end = j;
                }
            }
        }


        return Arrays.copyOfRange(ary, begin, end + 1);
    }
}
