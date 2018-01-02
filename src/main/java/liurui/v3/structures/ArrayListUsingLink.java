package liurui.v3.structures;

import liurui.structures.ArrayListable;
import liurui.structures.Item;

public class ArrayListUsingLink implements ArrayListable {
    Item<Integer> header;
    Item<Integer> tail;
    int size = 0;


    @Override
    public void add(int data) {
        insert(size, data);
    }

    @Override
    public void insert(int index, int data) {
        if (index < 0 || index > size) throw new IllegalArgumentException();

        if (size == 0) {
            header = tail = new Item<>(data);

        } else if (index == 0) {
            Item<Integer> item = new Item<>(data, header);
            header = item;
        } else if (index == size) {
            Item<Integer> item = new Item<>(data);
            tail.setNext(item);
            tail = item;

        } else {
            Item<Integer> prevItem = getItem(index - 1);
            Item<Integer> item = new Item<>(data, prevItem.getNext());
            prevItem.setNext(item);
        }
        size++;
    }

    @Override
    public boolean contains(int data) {
        Item<Integer> item = header;

        while (item != null) {
            if (item.getData() == data) {
                return true;
            }
            item = item.getNext();
        }
        return false;
    }

    @Override
    public int remove() {
        return remove(size - 1);
    }

    @Override
    public int remove(int index) {
        if (index < 0 || index > size) throw new IllegalArgumentException();
        int ret;

        if (size == 1) {
            ret = header.getData();
            clear();
            return ret;
        } else if (index == 0) {
            ret = header.getData();
            header = header.getNext();
            size--;
            return ret;
        } else {
            Item<Integer> prevItem = getItem(index - 1);
            Item<Integer> item = prevItem.getNext();
            prevItem.setNext(item.getNext());

            size--;
            return item.getData();
        }
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
        header = tail = null;
        size = 0;
    }

    @Override
    public int get(int index) {
        return getItem(index).getData();
    }

    private Item<Integer> getItem(int index) {
        if (index < 0 || index > size) throw new IllegalArgumentException();
        Item<Integer> ret = header;

        for (int i = 1; i <= index; i++) {
            ret = ret.getNext();
        }
        return ret;
    }
}
