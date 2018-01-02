package liurui.v3.structures;

import liurui.structures.Item;
import liurui.structures.Queuable;

public class QueueUsingLink implements Queuable {
    Item<Integer> header, tail;
    int size;


    @Override
    public void add(int data) {
        Item<Integer> item = new Item<>(data);

        if (size == 0) {
            header = tail = item;
        } else {
            tail.setNext(item);
            tail = item;
        }
        size++;
    }

    @Override
    public int pop() {
        if (size == 0) throw new IndexOutOfBoundsException();

        int ret = header.getData();

        if(size == 1){
            header = tail = null;
        }else{
            header = header.getNext();
        }
        size --;
        return ret;
    }

    @Override
    public int peek() {
        if (size == 0) throw new IndexOutOfBoundsException();
        return header.getData();
    }

    @Override
    public void clear() {
        header = tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }
}
