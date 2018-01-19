package liurui.defines.sorts;

import liurui.v4.sorts.BubbleSortImpl;
import org.junit.Test;

public class BubbleSortTest {
    @Test
    public void sort() {
        BubbleSort item = new BubbleSortImpl();

        new SortTest().test(item);
    }
}