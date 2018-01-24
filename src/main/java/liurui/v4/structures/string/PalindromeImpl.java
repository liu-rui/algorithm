package liurui.v4.structures.string;

import liurui.defines.structures.string.Palindrome;

/**
 * 判断字符串是否是回文
 * 回文是指不管正着读还是反着读都是一样的，如abcba
 */
public class PalindromeImpl implements Palindrome {
    /**
     * 判断字符串是否是回文
     *
     * @param str 字符串
     * @return 是否是回文
     */
    @Override
    public boolean isPalindrome(String str) {
        int mid = str.length() / 2;

        for (int i = 0; i < mid; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
