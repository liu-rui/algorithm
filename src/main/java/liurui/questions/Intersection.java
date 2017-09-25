package liurui.questions;

import liurui.sorts.QuickSort;
import liurui.sorts.Sortable;
import liurui.structures.ArrayListUsingArray;
import liurui.structures.ArrayListable;

/***
 * 求出两个数组的交集
 */
public class Intersection {
    public int[] get(int[] a, int[] b) {
        ArrayListable list = new ArrayListUsingArray();
        Sortable sortable = new QuickSort();

        a = sortable.sort(a);
        b = sortable.sort(b);

        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            if(a[i] == b[j]){
                list.add(a[i]);
                i++;
                j++;
            }else if(a[i] > b[j])
                j++;
            else
                i++;
        }

        int[] ret = new int[list.getSize()];

        for (int i1 = 0; i1 < ret.length; i1++) {
            ret[i1] = list.get(i1);
        }
        return ret;
    }
}
