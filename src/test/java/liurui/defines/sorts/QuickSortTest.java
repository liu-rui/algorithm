package liurui.defines.sorts;

import liurui.answers.sorts.QuickSortImpl;
import org.junit.Test;

public class QuickSortTest {
    @Test
    public void sort(){

        QuickSort item = new QuickSortImpl();

        new SortTest().test(item);
    }

}