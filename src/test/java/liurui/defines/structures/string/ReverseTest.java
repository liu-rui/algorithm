package liurui.defines.structures.string;

import liurui.v4.structures.string.ReverseImpl;
import org.junit.Test;

import static org.junit.Assert.*;


public class ReverseTest {
    @Test
    public void test() {
        Reverse item = new ReverseImpl();
        assertEquals("cba", item.reverse("abc"));
        assertEquals("abedcfg", item.reverse("abcdefg", 2, 4));
    }
}
