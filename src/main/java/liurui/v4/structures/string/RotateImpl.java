package liurui.v4.structures.string;

import liurui.defines.structures.string.Rotate;

/**
 * 旋转字符串
 * <p>
 * 如: abcdefg ,旋转的下标为3
 * 结果为: efgabcd
 * <p>
 * 就是将下标后面的数放在最前面
 */
public class RotateImpl implements Rotate {

    /**
     * 旋转字符串
     *
     * @param str   待旋转的字符串
     * @param index 旋转的下标
     * @return 旋转后的字符串
     */
    @Override
    public String rotate(String str, int index) {
        char[] chars = str.toCharArray();

        reverse(chars, 0, index);
        reverse(chars, index + 1, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int begin, int end) {
        int mid = (end - begin) / 2;

        for (int i = 0; i <= mid; i++) {
            swap(chars, begin + i, end - i);
        }
    }

    private void swap(char[] ary, int a, int b) {
        char tmp = ary[a];

        ary[a] = ary[b];
        ary[b] = tmp;
    }
}
