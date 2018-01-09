package liurui.defines.structures.string;

import liurui.v4.structures.string.ContainsUsingHashImpl;
import org.junit.Test;

public class ContainsUsingHashTest {
    @Test
    public void test(){
        Contains  item = new ContainsUsingHashImpl();

        new ContainsTest().test(item);
    }
}
