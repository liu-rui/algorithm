package liurui;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyBucketSortTest {
    @Test
    public void sort() throws Exception {
        assertArrayEquals(new int[]{6, 5, 4, 3}, new MyBucketSort().sort(new int[]{4, 6, 5, 3}));
    }
}