package liurui.standard.questions;

import liurui.defines.sorts.Sortable;
import liurui.defines.structures.ArrayListable;
import liurui.standard.sorts.QuickSortImpl;
import liurui.standard.structures.ArrayListUsingArrayImpl;


public class IntersectionImpl implements liurui.defines.questions.Intersection {
    @Override
    public int[] get(int[] a, int[] b) {
        ArrayListable list = new ArrayListUsingArrayImpl();
        Sortable sortable = new QuickSortImpl();

        a = sortable.sort(a);
        b = sortable.sort(b);

        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            if(a[i] == b[j]){
                list.add(a[i]);
                i++;
                j++;
            }else if(a[i] > b[j]) {
                j++;
            } else {
                i++;
            }
        }

        int[] ret = new int[list.getSize()];

        for (int i1 = 0; i1 < ret.length; i1++) {
            ret[i1] = list.get(i1);
        }
        return ret;
    }
}
