package liurui.defines.structures.string;

import liurui.v4.structures.string.LongestPalindromeImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest {
    @Test
    public void test() {
        LongestPalindrome item = new LongestPalindromeImpl();

        assertEquals("cdedc", item.search("abcdedco"));
        assertEquals("cdefgfedc", item.search("abcdefgfedcgcda"));
    }
}
