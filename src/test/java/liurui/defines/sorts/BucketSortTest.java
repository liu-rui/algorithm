package liurui.defines.sorts;

import liurui.v4.sorts.BucketSortImpl;
import org.junit.Test;

public class BucketSortTest {
    @Test
    public void sort(){
        BucketSort item = new BucketSortImpl();

        new SortTest().test(item);
    }

}