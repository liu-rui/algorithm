package liurui.v3.structures;

import liurui.structures.Stackable;

import java.util.Arrays;

public class StackUsingArray implements Stackable {
    int[] list;
    int size = 0;


    public StackUsingArray(int capacity) {
        list = new int[capacity];
        size = 0;
    }

    @Override
    public void push(int data) {
        list[size++] = data;
        resize();
    }

    @Override
    public int pop() {
        if (size == 0) throw new IllegalArgumentException();

        return list[--size];
    }

    @Override
    public int peek() {
        if (size == 0) throw new IllegalArgumentException();
        return list[size - 1];
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    private void resize() {
        if (size != list.length) return;
        list = Arrays.copyOf(list, list.length * 2);
    }
}
