package liurui.questions;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class OddEvenSortTest {
    @Test
    public void test() {
        assertArrayEquals(new int[]{3, 9, 5, 8, 6, 10}, new liurui.v3.questions.OddEvenSort().sort(new int[]{3, 6, 8, 5, 9, 10}));
    }
}
