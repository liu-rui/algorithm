package liurui.structures;

/***
 * 排好序的动态数组
 */
public class MySortedArrayList extends MyArrayList {
    public MySortedArrayList(int capacity) {
        super(capacity);
    }

    @Override
    public void add(int data) {
        int i = size;
        for (; i > 0 && list[i - 1] > data; i--) {
            list[i] = list[i - 1];
        }
        list[i] = data;
        size++;
        resize();
    }

    @Override
    public void insert(int index, int data) {
        add(data);
    }

    @Override
    public boolean contains(int data) {
        if (isEmpty()) return false;
        int begin = 0;
        int end = size - 1;

        while (begin <= end) {
            int i = begin + (end - begin) / 2;
            if (list[i] == data)
                return true;
            else if (data > list[i])
                begin = i + 1;
            else
                end = i - 1;
        }
        return false;
    }
}
