package liurui.defines.structures;

import liurui.answers.structures.StackUsingDoubleQueueImpl;
import org.junit.Test;

public class StackUsingDoubleQueueTest {

    @Test
    public void test() {
        StackUsingDoubleQueue item = new StackUsingDoubleQueueImpl();

        new StackTest().test(item);
    }
}