package liurui.defines.structures;

import liurui.standard.structures.StackUsingArrayImpl;
import org.junit.Test;

public class StackUsingArrayTest {
    @Test
    public void test() {
        StackUsingArray item = new StackUsingArrayImpl(2);

        new StackTest().test(item);
    }
}
