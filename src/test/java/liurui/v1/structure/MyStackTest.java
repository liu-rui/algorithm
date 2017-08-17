package liurui.v1.structure;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyStackTest {


    @Test
    public void test() {
        MyStack stack = new MyStack(2);

        assertEquals(0, stack.getCount());
        assertEquals(2, stack.getSize());

        stack.push(100);
        assertEquals(1, stack.getCount());
        assertEquals(100, stack.peek());
        assertEquals(100, stack.pop());
        assertEquals(0, stack.getCount());


        stack.push(200);
        stack.push(300);
        stack.push(400);
        stack.push(500);
        stack.push(600);


        assertEquals(5, stack.getCount());
        assertEquals(8, stack.getSize());
        assertEquals(600, stack.pop());
        assertEquals(500, stack.pop());
        assertEquals(400, stack.pop());
        assertEquals(300, stack.pop());
        assertEquals(200, stack.pop());
        assertEquals(0, stack.getCount());
        assertEquals(8, stack.getSize());
    }
}