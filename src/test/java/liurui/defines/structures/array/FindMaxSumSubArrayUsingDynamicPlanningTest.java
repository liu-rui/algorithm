package liurui.defines.structures.array;

import liurui.v4.structures.array.FindMaxSumSubArrayUsingDynamicPlanningImpl;
import org.junit.Test;

public class FindMaxSumSubArrayUsingDynamicPlanningTest {
    @Test
    public void test() {
        FindMaxSumSubArray item = new FindMaxSumSubArrayUsingDynamicPlanningImpl();

        new FindMaxSumSubArrayTest().test(item);
    }
}
