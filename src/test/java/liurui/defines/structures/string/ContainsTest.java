package liurui.defines.structures.string;

import static org.junit.Assert.*;

public class ContainsTest {
    public void test(Contains item) {
        assertTrue(item.contains("abcdefg", "bdbg"));
        assertFalse(item.contains("abcdefg", "bdbq"));
    }
}
