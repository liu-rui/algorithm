package liurui.defines.structures;

import liurui.standard.structures.ArrayListUsingArrayImpl;
import org.junit.Test;

public class ArrayListUsingArrayTest {
    @Test
    public void test(){
        ArrayListUsingArray  ary = new ArrayListUsingArrayImpl(2);

        new ArrayListTest().test(ary);
    }
}
