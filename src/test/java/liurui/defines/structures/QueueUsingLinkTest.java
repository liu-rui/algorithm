package liurui.defines.structures;

import liurui.standard.structures.QueueUsingLinkImpl;
import org.junit.Test;

public class QueueUsingLinkTest {
    @Test
    public void test() {
        QueueUsingLink item = new QueueUsingLinkImpl();

        new QueueTest().test(item);
    }
}
