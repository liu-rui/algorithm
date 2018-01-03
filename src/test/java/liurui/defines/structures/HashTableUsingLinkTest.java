package liurui.defines.structures;

import liurui.answers.structures.HashTableUsingLinkImpl;
import org.junit.Test;

public class HashTableUsingLinkTest {
    @Test
    public void test(){
        HashTableUsingLink  item = new HashTableUsingLinkImpl();

        new HashtableTest().test(item);
    }
}