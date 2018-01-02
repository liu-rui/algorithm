package liurui.v3.questions;

import liurui.structures.Queuable;
import liurui.v3.structures.StackUsingLink;


public class QueueUsingDoubleStack implements Queuable {
    StackUsingLink a = new StackUsingLink();
    StackUsingLink b = new StackUsingLink();

    public void push(int data) {
        add(data);
    }

    @Override
    public void add(int data) {
        a.push(data);
    }

    @Override
    public int pop() {
        if (getSize() == 0) throw new IndexOutOfBoundsException();

        if (b.getSize() == 0) {
            while (a.getSize() != 0) {
                b.push(a.pop());
            }
        }

        return b.pop();
    }

    @Override
    public int peek() {
        if (getSize() == 0) throw new IndexOutOfBoundsException();

        if (b.getSize() == 0) {
            while (a.getSize() != 0) {
                b.push(a.pop());
            }
        }

        return b.peek();
    }

    @Override
    public void clear() {
        a.clear();
        b.clear();
    }

    @Override
    public int getSize() {
        return b.getSize() + a.getSize();
    }
}
