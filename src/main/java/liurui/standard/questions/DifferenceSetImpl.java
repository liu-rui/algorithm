package liurui.standard.questions;

import liurui.defines.questions.DifferenceSet;
import liurui.defines.sorts.Sortable;
import liurui.defines.structures.ArrayListable;
import liurui.standard.sorts.QuickSortImpl;
import liurui.standard.structures.ArrayListUsingLinkImpl;

public class DifferenceSetImpl implements   DifferenceSet {
    public int[] get(int[] a, int[] b){
        ArrayListable list = new ArrayListUsingLinkImpl();
        Sortable sorter = new QuickSortImpl();

        a = sorter.sort(a);
        b = sorter.sort(b);

        int i = 0;
        int j = 0;

        while (i != a.length && j != b.length) {
            if (a[i] == b[j]) {
                i++;
                j++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                list.add(a[i++]);
            }
        }

        if (i != a.length) {
            for (; i < a.length; i++) {
                list.add(a[i]);
            }
        }
        int[] ret = new int[list.getSize()];

        for (int i1 = 0; i1 < ret.length; i1++) {
            ret[i1] = list.get(i1);
        }
        return ret;
    }
}
