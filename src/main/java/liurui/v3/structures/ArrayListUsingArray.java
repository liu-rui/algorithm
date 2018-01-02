package liurui.v3.structures;

import liurui.structures.ArrayListable;

import java.util.Arrays;

public class ArrayListUsingArray implements ArrayListable {
    int[] list;
    int size = 0;

    public ArrayListUsingArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException();
        list = new int[capacity];
    }

    @Override
    public void add(int data) {
        insert(size, data);
    }

    @Override
    public void insert(int index, int data) {
        if (index < 0 || index > size) throw new IllegalArgumentException();

        if (size == 0) {
            list[0] = data;
        } else if (index == size) {
            list[size] = data;
        } else {
            for (int i = size - 1; i >= index; i--) {
                list[i + 1] = list[i];
            }
            list[index] = data;
        }
        size++;
        resize();
    }

    @Override
    public boolean contains(int data) {
        for (int i = 0; i < size; i++) {
            if (list[i] == data) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int remove() {
        return remove(size - 1);
    }

    @Override
    public int remove(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();

        int data = list[index];

        if (size == 1) {
            clear();
        } else if (index == size - 1) {
            size--;
        } else {
            for (int i = index + 1; i < size; i++) {
                list[i-1] = list[i];
            }
            size--;
        }
        return data;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();
        return list[index];
    }

    private void resize() {
        if (size != list.length) return;
        list = Arrays.copyOf(list, list.length * 2);
    }
}
