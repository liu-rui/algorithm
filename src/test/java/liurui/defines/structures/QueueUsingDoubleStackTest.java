package liurui.defines.structures;

import liurui.standard.structures.QueueUsingDoubleStackImpl;
import org.junit.Test;

public class QueueUsingDoubleStackTest {
    @Test
    public void test() {
        QueueUsingDoubleStack item = new QueueUsingDoubleStackImpl();

        new QueueTest().test(item);
    }
}