package liurui.structures;

import java.util.Arrays;

/***
 * 动态数组
 */
public class MyArrayList {
    public final static int DEFAULT_CAPACITY = 10;
    public final static float RESIZE_FACTOR = 0.75f;
    protected int[] list;
    protected int size;


    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        if (capacity < 1) throw new IllegalArgumentException("capacity");

        list = new int[capacity];
    }

    public void add(int data) {
        insert(size, data);
    }

    public void insert(int index, int data) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("index");

        for (int i = size - 1; i >= index; i--) {
            list[i + 1] = list[i];
        }
        list[index] = data;
        size++;
        resize();
    }

    protected void resize() {
        if (size < list.length * RESIZE_FACTOR) return;
        list = Arrays.copyOf(list, list.length * 2);
    }

    public boolean contains(int data) {
        if (isEmpty()) return false;
        if (list[0] == data) return true;
        int first = list[0];

        list[0] = data;
        int i = size - 1;

        while (data != list[i]) {
            i--;
        }
        list[0] = first;
        return i != 0;
    }

    public int remove() {
        return remove(size - 1);
    }

    public int remove(int index) {
        if (isEmpty() || index < 0) throw new IndexOutOfBoundsException("index");
        int ret = list[index];

        for (int i = index + 1; i < size; i++) {
            list[i - 1] = list[i];
        }
        size--;
        return ret;
    }

    public int getSize() {
        return size;
    }

    public int capacity() {
        return list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
    }

    public int get(int index) {
        if (isEmpty() || index < 0) throw new IndexOutOfBoundsException("index");
        return list[index];
    }
}
