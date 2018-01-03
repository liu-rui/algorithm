package liurui.defines.structures;

import liurui.standard.structures.StackUsingLinkImpl;
import org.junit.Test;

public class StackUsingLinkTest {
    @Test
    public void test() {
        StackUsingLink item = new StackUsingLinkImpl();

        new StackTest().test(item);
    }
}
