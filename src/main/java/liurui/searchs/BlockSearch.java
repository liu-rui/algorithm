package liurui.searchs;

import liurui.structures.ArrayListUsingArray;
import liurui.structures.ArrayListable;

/***
 * 分块查找
 */
public class BlockSearch {
    private int[] index;
    private ArrayListable[] ary;

    public BlockSearch(int[] index) {
        this.index = index;
        ary = new ArrayListable[index.length];
    }

    public void insert(int data) {
        int i = binarySearch(data);

        ArrayListable arrayListable = ary[i];

        if (arrayListable == null) {
            arrayListable = new ArrayListUsingArray();
            ary[i] = arrayListable;
        }
        arrayListable.add(data);
    }

    public boolean search(int data) {
        int i = binarySearch(data);

        if (ary[i] == null) {
            return false;
        }
        return ary[i].contains(data);
    }

    private int binarySearch(int data) {
        int begin = 0;
        int end = index.length - 1;
        int mid = -1;

        while (begin <= end) {
            mid = begin + (end - begin) / 2;
            if (index[mid] == data) {
                return mid;
            } else if (index[mid] > data) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return mid;
    }
}
