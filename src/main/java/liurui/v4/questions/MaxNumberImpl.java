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
        return getMax2(ary[0] , ary[1]);
    }

    /**
     * 异或运算
     */
    public int flip(int n) {
        return n ^ 1;
    }

    /**
     * n是正数或0返回1 n是负数返回0
     */
    public int sign(int n) {
        return flip((n >> 31) & 1);
    }

    /**
     * 我们不能直接比较，那么就用减法来判断，a - b值的符号，符号为
     * 正a大，符号为负b大。scA表示c的符号，scB表示c的相反的符
     * 号，scA是1返回a，scA是0返回B.但是有局限性，那就是a-b的值
     * 可能出现溢出，返回结果不正确。
     * @param a
     * @param b
     * @return
     */
    public int getMax1(int a, int b) {
        int c = a - b;
        int scA = sign(c);// 返回c的符号，正数和0是1，负数是0
        int scB = flip(scA);// 返回c的符号的相反符号
        return a * scA + b * scB;
    }


    /**
     * 先比较a与b两个数的符号，符号不同difSab==1，sameSab==0；直接返回符号为正的那个数。
     * 如果a为0或正，那么b为负(sa==1,sb==0)，则返回a;
     * 如果a为负，那么b为0或正(sa==0,sb==1)，则返回b;
     * 如果符号相同difSab==0,sameSab==1,这种情况下,a-b的值绝对不会溢出，那么就看c的符号。
     * 如果c=a-b,为正返回a;
     * 如果c=a-b,为负返回b;
     *
     *
     * 如果a、b的符号相同(+,+)、(-,-)，difSab=0,returnA=sc;如果sc是1,返回a,否则返回b
     * 如果a、b的符号不同(+,-)、(-,+)，disSab=1,returnA=sa;如果sa是1,返回a,否则返回b
     */
    public int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);// 返回a的符号
        int sb = sign(b);// 返回b的符号
        int sc = sign(c);// 返回c的符号
        int difSab = sa ^ sb;
        int sameSab = flip(difSab);
        int returnA = difSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;

    }
}
