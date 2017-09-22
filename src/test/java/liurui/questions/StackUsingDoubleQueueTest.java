package liurui.questions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackUsingDoubleQueueTest {

    @Test
    public void test() {
        StackUsingDoubleQueue item = new StackUsingDoubleQueue();

        item.push(10);
        item.push(45);
        item.push(23);
        item.push(56);

        assertEquals(4 , item.getSize());
        assertEquals(56 , item.pop());
        assertEquals(23 , item.pop());
        assertEquals(45 , item.pop());
        assertEquals(10 , item.pop());
    }
}