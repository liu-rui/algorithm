package liurui.questions;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DifferenceSetTest {

    @Test
    public void test() {
        DifferenceSet diff = new DifferenceSet();
        assertArrayEquals(new int[]{5,7}, diff.get(new int[]{5, 8, 3, 7}, new int[]{8, 3, 6, 10}));
    }
}