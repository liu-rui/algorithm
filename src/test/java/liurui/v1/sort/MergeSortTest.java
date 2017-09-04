package liurui.v1.sort;

import liurui.v2.sort.MergeSort;
import liurui.v2.sort.ShellSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {
    @Test
    public void sort() throws Exception {
        assertArrayEquals(new int[]{1,1,3,5,5,6,7,9,9}, new MergeSort().sort(new int[]{5,9,1,9,5,3,7,6,1}));
    }

}