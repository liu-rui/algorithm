package liurui.defines.structures.string;

import liurui.v4.structures.string.PermutatioUsingFixPositionImpl;
import org.junit.Test;

public class PermutationUsingFixPositionTest {

    @Test
    public void test() {
        Permutation item = new PermutatioUsingFixPositionImpl();

        new PermutationTest().test(item);
    }
}
