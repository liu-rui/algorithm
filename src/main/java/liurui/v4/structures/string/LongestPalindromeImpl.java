package liurui.v4.structures.string;

import liurui.defines.structures.string.LongestPalindrome;

/**
 * 寻找最大的回文子串
 * 例如:abcdedco,结果为cdedc
 */
public class LongestPalindromeImpl implements LongestPalindrome {
    @Override
    public String search(String str) {
        int begin = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < str.length() - 1; i++) {
            int tmpMax = 0;

            for (int j = 0; i - j >= 0 && i + j <= str.length() - 1 && str.charAt(i - j) == str.charAt(i + j); j++) {
                tmpMax = j * 2 + 1;
            }

            if (tmpMax > max) {
                max = tmpMax;
                begin = i - max / 2;
            }

            for (int j = 0; i - j >= 0 && i + j + 1 <= str.length() - 1 && str.charAt(i - j) == str.charAt(i + j + 1); j++) {
                tmpMax = j * 2 + 2;
            }

            if (tmpMax > max) {
                max = tmpMax;
                begin = i - max / 2;
            }
        }
        return str.substring(begin, begin + max);
    }
}
