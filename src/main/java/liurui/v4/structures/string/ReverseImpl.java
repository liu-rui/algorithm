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

        for (int i = 0; i < mid; i++) {
            char tmp = chars[begin + i];
            chars[begin + i] = chars[end - i];
            chars[end - i] = tmp;
        }
        return String.valueOf(chars);
    }
}
