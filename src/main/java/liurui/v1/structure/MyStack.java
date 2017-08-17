package liurui.v1.structure;

import java.util.Arrays;

public class MyStack {
    private int[] ary;
    private int count = 0;

    public MyStack() {
        this(2);
    }

    public MyStack(int init) {
        this.ary = new int[init];
    }

    public void push(int data) {
        ary[count++] = data;

        if (count == ary.length)
            ary = Arrays.copyOf(ary, ary.length * 2);
    }

    public int pop() {
        if (count == 0) throw new IndexOutOfBoundsException();

        return ary[--count];
    }

    public int peek() {
        if (count == 0) throw new IndexOutOfBoundsException();

        return ary[count - 1];
    }

    public int getCount() {
        return count;
    }

    public int getSize() {
        return ary.length;
    }
}
