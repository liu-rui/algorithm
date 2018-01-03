package liurui.defines.structures;

import liurui.standard.structures.HashTableUsingLinkImpl;
import org.junit.Test;

public class HashTableUsingLinkTest {
    @Test
    public void test(){
        HashTableUsingLink  item = new HashTableUsingLinkImpl();

        new HashtableTest().test(item);
    }
}