package liurui.defines.sorts;

import liurui.standard.sorts.InsertSortImpl;
import org.junit.Test;

public class InsertSortTest {
    @Test
    public void sort() throws Exception {
        InsertSort item = new InsertSortImpl();

        new SortTest().test(item);
    }
}