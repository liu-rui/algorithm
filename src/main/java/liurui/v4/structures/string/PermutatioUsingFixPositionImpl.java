package liurui.v4.structures.string;

import liurui.defines.structures.string.PermutatioUsingFixPosition;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 计算出字符的所有排列情况,使用固定位的方式
 * <p>
 * 思想：
 * 先固定好前面的，然后后面的进行交换，当全部排完之后把前一位与
 * 后面的元素进行交换，继续全排列，在当前变化的几位都排完了之
 * 后，再往前新增一位交换位参与到排列中
 */
public class PermutatioUsingFixPositionImpl implements PermutatioUsingFixPosition {
    @Override
    public String[] permutation(String str) {
        ArrayList<String> ret = new ArrayList<>();

        permutation(ret, str.toCharArray(), 0, str.length() - 1);
        return ret.toArray(new String[0]);
    }

    private void permutation(ArrayList<String> container, char[] chars, int begin, int end) {
        if (begin == end) {
            container.add(new String(chars));
            return;
        }

        for (int i = begin; i <= end; i++) {
            swap(chars, begin, i);
            permutation(container, chars, begin + 1, end);
            swap(chars, i, begin);
        }
    }

    private void swap(char[] chars, int a, int b) {
        char tmp = chars[a];

        chars[a] = chars[b];
        chars[b] = tmp;
    }
}