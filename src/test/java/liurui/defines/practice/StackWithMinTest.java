package liurui.defines.practice;

import liurui.defines.structures.StackTest;
import liurui.v4.practice.StackWithMinImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackWithMinTest {
    @Test
    public void test() {
        StackWithMin item = new StackWithMinImpl();

        new StackTest().test(item);
    }

    @Test
    public void testGetMin() {
        StackWithMin item = new StackWithMinImpl();

        item.push(3);
        assertEquals(3, item.getMin());
        item.push(4);
        assertEquals(3, item.getMin());
        item.push(5);
        assertEquals(3, item.getMin());
        item.push(1);
        assertEquals(1, item.getMin());
        item.push(2);
        assertEquals(1, item.getMin());
        item.push(1);
        assertEquals(1, item.getMin());

        assertEquals(1, item.pop());
        assertEquals(1, item.getMin());
        assertEquals(2, item.pop());
        assertEquals(1, item.getMin());
        assertEquals(1, item.pop());
        assertEquals(3, item.getMin());
        assertEquals(5, item.pop());
        assertEquals(3, item.getMin());
        assertEquals(4, item.pop());
        assertEquals(3, item.getMin());
        assertEquals(3, item.pop());
    }
}
