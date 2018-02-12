package liurui.v4.structures.string;

import liurui.defines.structures.string.PermutatioUsingFixPosition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 计算出字符的所有排列情况,使用固定位的方式
 */
public class PermutatioUsingFixPositionImpl implements PermutatioUsingFixPosition {
    /**
     * 输出字符所有的排列情况
     *
     * @param str 参与排列的字符
     * @return 字符所有的排列情况
     */
    @Override
    public String[] permutation(String str) {
        ArrayList<String> ret = new ArrayList<>();
        char[] ary = str.toCharArray();

        generic(ret, ary, 0, ary.length - 1);
        System.out.println(ret);
        return ret.toArray(new String[ret.size()]);
    }

    private void generic(ArrayList<String> container, char[] ary, int begin, int end) {
        if (begin == end) {
            container.add(String.valueOf(ary));
        }

        for (int i = begin; i <= end; i++) {
            swap(ary, begin, i);
            generic(container, ary, begin + 1, end);
            swap(ary, begin, i);
        }
    }

    private void swap(char[] ary, int a, int b) {
        char tmp = ary[a];

        ary[a] = ary[b];
        ary[b] = tmp;
    }
}
