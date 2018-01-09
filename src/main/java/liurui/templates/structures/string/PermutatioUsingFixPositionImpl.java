package liurui.templates.structures.string;

import liurui.defines.structures.string.PermutatioUsingFixPosition;

/**
 * 计算出字符的所有排列情况,使用固定位的方式
 *
 *
 *
 * 思想：
 * 先固定好前面的，然后后面的进行交换，当全部拍完之后把前一位与
 * 后面的元素进行交换，继续全排列，在当前变化的几位都排完了之
 * 后，再往前新增一位交换位参与到排列中
 */
public class PermutatioUsingFixPositionImpl implements PermutatioUsingFixPosition {
    @Override
    public String[] permutation(String str) {
        return new String[0];
    }
}
