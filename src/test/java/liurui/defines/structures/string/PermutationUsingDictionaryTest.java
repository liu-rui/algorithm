package liurui.defines.structures.string;

import liurui.v4.structures.string.PermutationUsingDictionaryImpl;
import org.junit.Test;

public class PermutationUsingDictionaryTest {

    @Test
    public void test() {
        Permutation item = new PermutationUsingDictionaryImpl();

        new PermutationTest().test(item);
    }
}
