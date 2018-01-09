package liurui.defines.structures.string;

import liurui.v4.structures.string.PalindromeImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeTest {
    @Test
    public void test() {
        Palindrome item = new PalindromeImpl();

        assertTrue(item.isPalindrome("abcba"));
        assertTrue(item.isPalindrome("abccba"));
        assertFalse(item.isPalindrome("abdbd"));
    }
}
