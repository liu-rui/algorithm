package liurui.defines.structures.string;

import liurui.v4.structures.string.RotateImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class RotateTest {
    @Test
    public void test() {
        Rotate item = new RotateImpl();
        assertEquals("efgabcd", item.rotate("abcdefg", 3));
        assertEquals("fgabcde", item.rotate("abcdefg", 4));
    }
}


