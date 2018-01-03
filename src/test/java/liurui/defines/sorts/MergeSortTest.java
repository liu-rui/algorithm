package liurui.defines.sorts;

import liurui.answers.sorts.MergeSortImpl;
import org.junit.Test;

public class MergeSortTest {
    @Test
    public void sort() {
        MergeSort item = new MergeSortImpl();

        new SortTest().test(item);
    }
}