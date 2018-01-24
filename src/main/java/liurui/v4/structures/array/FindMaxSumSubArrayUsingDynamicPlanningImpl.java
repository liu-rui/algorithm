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
        int lastMax = Integer.MIN_VALUE;
        int lastBegin = 0;

        for (int i = 0; i < ary.length; i++) {
            if (lastMax > 0) {
                lastMax += ary[i];
            } else {
                lastBegin = i;
                lastMax = ary[i];
            }

            if (lastMax > max) {
                max = lastMax;
                begin = lastBegin;
                end = i;
            }
        }
        return Arrays.copyOfRange(ary, begin, end + 1);
    }
}
