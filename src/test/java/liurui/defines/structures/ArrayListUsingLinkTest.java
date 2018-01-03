package liurui.defines.structures;

import liurui.answers.structures.ArrayListUsingLinkImpl;
import org.junit.Test;

public class ArrayListUsingLinkTest {
    @Test
    public void test() {
        ArrayListUsingLink ary = new ArrayListUsingLinkImpl();

        new ArrayListTest().test(ary);
    }
}
