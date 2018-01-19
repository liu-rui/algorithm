package liurui.defines.practice;

import liurui.defines.practice.HanNoI;
import liurui.v4.practice.HanNoIImpl;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class HanNoITest {
    @Test
    public void test() {
        HanNoI item = new HanNoIImpl();

        assertArrayEquals(new String[]{"a -> c",
                        "a -> b",
                        "c -> b",
                        "a -> c",
                        "b -> a",
                        "b -> c",
                        "a -> c" },
                item.move(3, 'a', 'b', 'c'));
    }
}
