package liurui.defines.structures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HaFuManTreeTest {

    @Test
    public void test(){
        HaFuManTree tree = new HaFuManTree();

        tree.set("a" , 40);
        tree.set("b" , 50);
        tree.set("c" , 30);
        tree.set("d" , 10);
        tree.generic();
        assertEquals("11" ,   tree.get("a"));
        assertEquals("01011001111" , tree.encode("bcdaa"));
        assertEquals("bcdaa" , tree.decode("01011001111"));
    }
}