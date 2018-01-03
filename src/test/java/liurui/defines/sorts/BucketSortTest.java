package liurui.defines.sorts;

import liurui.standard.sorts.BucketSortImpl;
import org.junit.Test;

public class BucketSortTest {
    @Test
    public void sort(){
        BucketSort item = new BucketSortImpl();

        new SortTest().test(item);
    }

}