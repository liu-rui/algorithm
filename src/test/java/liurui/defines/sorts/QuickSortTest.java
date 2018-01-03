package liurui.defines.sorts;

import liurui.standard.sorts.QuickSortImpl;
import org.junit.Test;

public class QuickSortTest {
    @Test
    public void sort(){

        QuickSort item = new QuickSortImpl();

        new SortTest().test(item);
    }

}