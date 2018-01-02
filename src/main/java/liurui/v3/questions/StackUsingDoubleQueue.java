package liurui.v3.questions;

import liurui.structures.Stackable;
import liurui.v3.structures.QueueUsingLink;

public class StackUsingDoubleQueue implements Stackable {
    QueueUsingLink a = new QueueUsingLink();
    QueueUsingLink b = new QueueUsingLink();


    @Override
    public void push(int data) {
        if (a.getSize() == 0) {
            b.add(data);
        } else {
            a.add(data);
        }
    }

    @Override
    public int pop() {
        if (getSize() == 0) throw new IndexOutOfBoundsException();

        if (a.getSize() == 0) {
            while (b.getSize() != 1) {
                a.add(b.pop());
            }
            return b.pop();
        } else {
            while (a.getSize() != 1) {
                b.add(a.pop());
            }
            return a.pop();
        }
    }

    @Override
    public int peek() {
        if (getSize() == 0) throw new IndexOutOfBoundsException();

        if (a.getSize() == 0) {
            while (b.getSize() != 1) {
                a.add(b.pop());
            }
            int ret = b.peek();
            a.add(b.pop());
            return ret;
        } else {
            while (a.getSize() != 1) {
                b.add(a.pop());
            }
            int ret = a.peek();
            b.add(a.pop());
            return ret;
        }
    }

    @Override
    public void clear() {
        a.clear();
        b.clear();
    }

    @Override
    public int getSize() {
        return a.getSize() + b.getSize();
    }
}
