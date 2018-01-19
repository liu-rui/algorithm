package liurui.v4.questions;

import liurui.defines.questions.Exchange;

/**
 * 交换两个变量的值，不能使用其它的变量
 */
public class ExchangeImpl implements Exchange {

    /**
     * 交换两个变量的值，不能使用其它的变量
     *
     * @param ary 为了简单,使用长度为2的数组存储来代替两个变量
     * @return 交换后的数组
     */
    @Override
    public int[] exec(int[] ary) {
        ary[0] ^= ary[1];
        ary[1] ^= ary[0];
        ary[0] ^= ary[1];
        return ary;
    }
}