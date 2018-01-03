package liurui.defines.sorts;

import liurui.standard.sorts.ShellSortImpl;
import org.junit.Test;

public class ShellSortTest {
    @Test
    public void sort() {
        ShellSort item = new ShellSortImpl();

        new SortTest().test(item);
    }
}