package liurui.defines.structures.array;

import liurui.v4.structures.array.FindMaxSumSubArrayUsingExhaustiveImpl;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FindMaxSumSubArrayUsingExhaustiveTest {
    @Test
    public void test() {
        FindMaxSumSubArray item = new FindMaxSumSubArrayUsingExhaustiveImpl();

        new FindMaxSumSubArrayTest().test(item);
    }
}
