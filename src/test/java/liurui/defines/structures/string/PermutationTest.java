package liurui.defines.structures.string;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PermutationTest {
    public void test(Permutation item) {
        test(item, new String[]{"xy", "yx"}, "xy");
        test(item, new String[]{"xyz", "xzy", "yxz", "yzx", "zxy", "zyx"}, "xyz");
    }

    private void test(Permutation item, String[] expecteds, String str) {
        String[] strings = item.permutation(str);

        Arrays.sort(strings);
        assertArrayEquals(expecteds, strings);
    }
}
