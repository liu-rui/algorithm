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
        int aSign = sign(ary[0]);
        int bSign = sign(ary[1]);
        int cSign = sign(c);
        int sameSign = flip(aSign ^ bSign);
        int enableA = sameSign * cSign + flip(sameSign) * aSign;
        int enableB = sameSign * flip(cSign) + flip(sameSign) * bSign;

        return enableA * ary[0]  + enableB * ary[1];
    }

    int sign(int a) {
        return flip((a >> 31) & 1);
    }

    int flip(int sign) {
        return sign ^ 1;
    }
}
