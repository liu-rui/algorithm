package liurui.v4.questions;

import liurui.defines.questions.MaxNumber;

/**
 * 找出两个数中最大的数，不允许使用比较运算符
 */
public class MaxNumberImpl implements MaxNumber {
    /**
     * 找出两个数中最大的数，不允许使用比较运算符
     *
     * @param ary 为了简单,使用长度为2的数组存储来代替两个变量
     * @return 两个数中最大的数
     */
    @Override
    public int find(int[] ary) {
        int c = ary[0] - ary[1];
        int cSign = sign(c);
        int aSign = sign(ary[0]);
        int bSign =  sign(ary[1]);
        int sameAB = fan(  aSign ^ bSign);
        int enableA =  sameAB * cSign + fan(sameAB) * aSign ;
        int enableB = sameAB * fan(cSign) + fan(sameAB) * bSign;
        return enableA * ary[0] + enableB * ary[1];
    }

    private int sign(int data) {
        return  fan((data >> 31) & 1);
    }

    private int fan(int data) {
        return data ^ 1;
    }
}
