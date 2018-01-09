package liurui.defines.structures.string;

import liurui.v4.structures.string.ContainsUsingBitImpl;
import liurui.v4.structures.string.ContainsUsingHashImpl;
import org.junit.Test;

public class ContainsUsingBitTest {
    @Test
    public void test() {
        Contains item = new ContainsUsingBitImpl();

        new ContainsTest().test(item);
    }
}
