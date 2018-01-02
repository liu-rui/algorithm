package liurui.sorts;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class InsertSortTest {
    @Test
    public void sort() throws Exception {
        assertArrayEquals(new int[]{1,1,3,5,5,6,7,9,9}, new liurui.v3.sorts.InsertSort().sort(new int[]{5,9,1,9,5,3,7,6,1}));

    }

}