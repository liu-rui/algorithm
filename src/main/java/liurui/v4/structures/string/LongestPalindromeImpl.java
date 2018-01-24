package liurui.v4.structures.string;

import liurui.defines.structures.string.LongestPalindrome;

/**
 * 寻找最大的回文字串
 * 例如:abcdedco,结果为cdedc
 */
public class LongestPalindromeImpl implements LongestPalindrome {
    @Override
    public String search(String str) {
        int begin = 0;
        int max = 0;

        for (int i = 0; i < str.length(); i++) {
            int lastMax = 0;
            for (int j = 0; i - j >= 0 && i + j < str.length() && str.charAt(i - j) == str.charAt(i + j); j++) {
                lastMax = j * 2 + 1;
            }

            if (lastMax > max) {
                max = lastMax;
                begin = i - max / 2;
            }

            lastMax = 0;

            for (int j = 0; i - j >= 0 && i + j + 1 < str.length() && str.charAt(i - j) == str.charAt(i + j + 1); j++) {
                lastMax = j * 2 + 2;
            }

            if (lastMax > max) {
                max = lastMax;
                begin = i - max / 2;
            }
        }
        return str.substring(begin, begin + max);
    }
}
