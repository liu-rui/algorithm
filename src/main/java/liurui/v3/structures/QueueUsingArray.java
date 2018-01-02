package liurui.v3.structures;

import liurui.structures.Queuable;

public class QueueUsingArray implements Queuable {
    int[] list = new int[10];
    int header, tail;


    @Override
    public void add(int data) {
        if (full()) throw new IllegalArgumentException();

        list[tail] = data;
        tail = (tail + 1) % list.length;
    }

    @Override
    public int pop() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        int ret = list[header];

        header = (header+1) %  list.length;
        return ret;
    }

    @Override
    public int peek() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        return list[header];
    }

    @Override
    public void clear() {
        header = tail = 0;
    }

    @Override
    public int getSize() {
        if (tail >= header)
            return tail - header;
        else
            return tail + list.length - header;
    }

    private boolean full() {
        return header == (tail + 1) % list.length;
    }

    private boolean isEmpty() {
        return header == tail;
    }
}
