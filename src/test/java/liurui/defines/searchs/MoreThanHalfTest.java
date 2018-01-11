package liurui.defines.searchs;

import liurui.v4.searchs.MoreThanHalfImpl;
import org.junit.Test;

import static org.junit.Assert.*;


public class MoreThanHalfTest {
    @Test
    public void test() {
        MoreThanHalf item = new MoreThanHalfImpl();

        assertEquals(1, item.find(new int[]{0, 1, 2, 1, 2, 1, 1}));
        assertEquals(2, item.find(new int[]{0, 2, 2, 1, 2, 0, 2}));
    }
}

