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
        int lastSum = 0;
        int maxSum = ary[0];
        int begin = 0;
        int end = 0;

        for (int i = 0; i < ary.length; i++) {
            if(lastSum > 0){
                lastSum+= ary[i];
            }else{
                lastSum =  ary[i];
                begin = i;
            }

            if(lastSum > maxSum){
                maxSum = lastSum;
                end = i;
            }
        }
        return Arrays.copyOfRange(ary, begin, end + 1);
    }
}
