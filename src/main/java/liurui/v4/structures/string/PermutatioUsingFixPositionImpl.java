package liurui.v4.structures.string;

import liurui.defines.structures.string.PermutatioUsingFixPosition;

import java.util.ArrayList;

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

        permutation(str.toCharArray(), ret, 0, str.length() - 1);
        return ret.toArray(new String[0]);
    }

    private void permutation(char[] chars, ArrayList<String> container, int begin, int end) {
        if (begin == end) {
            container.add(String.valueOf(chars));
        }

        for (int i = begin; i <= end; i++) {
            swap(chars, begin, i);
            permutation(chars, container, begin + 1, end);
            swap(chars, i, begin);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];

        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
