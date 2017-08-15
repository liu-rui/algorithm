package liurui.v1.structure;

import java.util.Arrays;

public class MyArrayList {
    private int[] _ary;
    private int _count = 0;

    public MyArrayList() {
        this(2);
    }

    public MyArrayList(int init) {
        if (init <= 0) throw new IllegalArgumentException("init");
        _ary = new int[init];
    }

    public void add(int data) {
        add(_count, data);
    }

    public void add(int i, int data) {
        if (i < 0 || i > _count) throw new IllegalArgumentException("i");

        if (_count != i) {
            int index = _count;
            while (index > i) {
                _ary[index] = _ary[index - 1];
                index--;
            }
        }
        _ary[i] = data;
        _count++;
        if (_count == _ary.length)
            _ary = Arrays.copyOf(_ary, _ary.length * 2);
    }


    public int get(int i) {
        if (i >= _count) throw new IndexOutOfBoundsException();
        return _ary[i];
    }

    public void remove() {
        remove(_count - 1);
    }

    public void remove(int i) {
        if (_count == 0) return;
        if (i < -1 || i >= _count) throw new IndexOutOfBoundsException();

        if (i != _count - 1) {
            int index = i;

            while (index < _count - 1) {
                _ary[index] = _ary[index + 1];
                index++;
            }
        }
        _count--;
    }

    public void clear() {
        _count = 0;
    }

    public int getCount() {
        return _count;
    }

    public int getSize() {
        return _ary.length;
    }
}
