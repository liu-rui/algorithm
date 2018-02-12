package liurui.v4.structures.array;

import liurui.defines.structures.array.FindMaxSumSubArrayUsingDynamicPlanning;

import java.util.Arrays;

/**
 * 找出连加值最大的子数组,使用动态规划法
 * 子数组：数组中连续的一部分
 * 时间复杂度为O(N)
 */
public class FindMaxSumSubArrayUsingDynamicPlanningImpl implements FindMaxSumSubArrayUsingDynamicPlanning {
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
        int tmp = -1;
        int tmpBegin = 0;

        for (int i = 0; i < ary.length; i++) {
            if (tmp < 0) {
                tmp = ary[i];
                tmpBegin = i;
            } else {
                tmp += ary[i];
            }

            if (tmp > max) {
                max = tmp;
                begin = tmpBegin;
                end = i;
            }
        }
        return Arrays.copyOfRange(ary, begin, end + 1);
    }
}
