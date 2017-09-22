package liurui.questions;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class IntersectionTest {
    @Test
    public void test() {
        Intersection intersection = new Intersection();

        assertArrayEquals(new int[]{3, 8}, intersection.get(new int[]{5, 8, 3, 7}, new int[]{8, 3, 6, 10}));
    }
}
