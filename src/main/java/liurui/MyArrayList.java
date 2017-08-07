package liurui;

import java.util.Arrays;

public class MyArrayList {
    int[] _ary;
    int _len = 0;

    public MyArrayList() {
        this(2);
    }

    public MyArrayList(int init) {
        _ary = new int[init];
    }


    public void add(int data) {
        _ary[_len++] = data;

        if (_len == _ary.length)
            _ary = Arrays.copyOf(_ary, _ary.length * 2);
    }


    public int get(int i) {
        return _ary[i];
    }

    public void remove() {
        if (_len != 0)
            _len--;
    }

    public int getLen() {
        return _len;
    }

    public int getSize() {
        return _ary.length;
    }
}
