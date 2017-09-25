package liurui.searchs;

import org.junit.Test;

import static org.junit.Assert.*;

public class BlockSearchTest {

    @Test
    public void test() {
        BlockSearch blockSearch = new BlockSearch(new int[]{10, 20, 30, 40});

        blockSearch.insert(1);
        blockSearch.insert(12);
        blockSearch.insert(22);
        blockSearch.insert(23);
        blockSearch.insert(9);
        blockSearch.insert(27);

        assertTrue(blockSearch.search(22));
        assertFalse(blockSearch.search(21));
    }
}