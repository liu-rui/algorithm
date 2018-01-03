package liurui.defines.questions;

import liurui.standard.questions.HanLuoTaImpl;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class HanLuoTaTest {
    @Test
    public void test() {
        HanLuoTa item = new HanLuoTaImpl();

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
