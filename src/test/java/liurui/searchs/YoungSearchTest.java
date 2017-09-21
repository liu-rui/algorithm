package liurui.searchs;

import org.junit.Test;

import static org.junit.Assert.*;

public class YoungSearchTest {
    @Test
    public void test() {
        YoungSearch youngSearch = new YoungSearch(new int[][]{{1, 3, 4},
                {2, 4, 6},
                {5, 7, 8}});

        assertTrue(youngSearch.search(7));
        assertFalse(youngSearch.search(9));
    }
}