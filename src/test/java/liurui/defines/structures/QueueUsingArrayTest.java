package liurui.defines.structures;

import liurui.answers.structures.QueueUsingArrayImpl;
import org.junit.Test;

public class QueueUsingArrayTest {
    @Test
    public void test() {
        QueueUsingArray item = new QueueUsingArrayImpl();

        new QueueTest().test(item);
    }

}
