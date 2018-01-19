package liurui.v4.structures.string;

import liurui.defines.structures.string.LongestPalindrome;

/**
 * 寻找最大的回文字串
 * 例如:abcdedco,结果为cdedc
 */
public class LongestPalindromeImpl implements LongestPalindrome {
    @Override
    public String search(String str) {
        if (str == null || str.isEmpty()) return "";
        int begin = 0;
        int end = 0;
        int max = 0;

        for (int i = 0; i < str.length(); i++) {
            int cur = 0;
            for (int j = 0; i - j >= 0 && i + j < str.length(); j++) {
                if (str.charAt(i - j) == str.charAt(i + j)) {
                    cur = j * 2;
                } else {
                    break;
                }
            }

            if (cur > max) {
                max = cur;
                begin = i - max / 2;
                end = i + max / 2;
            }

            cur = 0;
            for (int j = 0; i - j >= 0 && i + j + 1 < str.length(); j++) {
                if (str.charAt(i - j) == str.charAt(i + j + 1)) {
                    cur += j * 2 + 1;
                } else {
                    break;
                }
            }

            if (cur > max) {
                max = cur;
                begin = i - max / 2;
                end = i + max / 2 + 1;
            }
        }

        return str.substring(begin, end + 1);
    }
}
