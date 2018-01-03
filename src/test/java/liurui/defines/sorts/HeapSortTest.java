package liurui.defines.sorts;

import liurui.answers.sorts.HeapSortImpl;
import org.junit.Test;

public class HeapSortTest {
    @Test
    public void sort() {
        HeapSort item = new HeapSortImpl();

        new SortTest().test(item);
    }
}