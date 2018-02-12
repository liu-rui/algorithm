package liurui.v4.structures.string;

import liurui.defines.structures.string.Reverse;

/**
 * 反转字符串
 */
public class ReverseImpl implements Reverse {
    /**
     * 反转字符串
     *
     * @param str   字符串
     * @param begin 起始位置
     * @param end   终止位置
     * @return 反转后的字符串
     */
    @Override
    public String reverse(String str, int begin, int end) {
        int mid = (end - begin) / 2;
        char[] chars = str.toCharArray();

        for (int i = 0; i <= mid; i++) {
            swap(chars, begin + i, end - i);
        }
        return String.valueOf(chars);
    }

    private void swap(char[] ary, int a, int b) {
        char tmp = ary[a];

        ary[a] = ary[b];
        ary[b] = tmp;
    }
}
