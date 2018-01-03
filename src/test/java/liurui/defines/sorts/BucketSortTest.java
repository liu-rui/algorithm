package liurui.defines.sorts;

import liurui.answers.sorts.BucketSortImpl;
import org.junit.Test;

public class BucketSortTest {
    @Test
    public void sort(){
        BucketSort item = new BucketSortImpl();

        new SortTest().test(item);
    }

}