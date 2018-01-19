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
        char[] chars = str.toCharArray();
        ArrayList<String> container = new ArrayList<>();

        permutation(container, chars, 0, chars.length - 1);
        return container.toArray(new String[0]);
    }

    private void permutation(ArrayList<String> container, char[] chars, int begin, int end) {
        if (begin == end) {
            container.add(String.valueOf(chars));
            return;
        }

        for (int i = begin; i <= end; i++) {
            swap(chars, i, begin);
            permutation(container, chars, begin + 1, end);
            swap(chars, begin, i);
        }
    }

    private void swap(char[] chars, int a, int b) {
        char tmp = chars[a];

        chars[a] = chars[b];
        chars[b] = tmp;
    }
}
