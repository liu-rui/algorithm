package liurui.questions;

import liurui.sorts.QuickSort;
import liurui.sorts.Sortable;
import liurui.structures.ArrayListUsingLink;
import liurui.structures.ArrayListable;

/***
 * 请求两个数据的差集
 * 时间复杂度为　nLOGn（a的排序） + mLOGm（b的排序） + (n + m)（差集计算）
 * 最终时间复杂度为: O(nLOGn)
 */
public class DifferenceSet {
    public int[] get(int[] a, int[] b) {
        ArrayListable list = new ArrayListUsingLink();
        Sortable sorter = new QuickSort();

        a = sorter.sort(a);
        b = sorter.sort(b);

        int i = 0;
        int j = 0;

        while (i != a.length && j != b.length) {
            if (a[i] == b[j]) {
                i++;
                j++;
            } else if (a[i] > b[j])
                j++;
            else
                list.add(a[i++]);
        }

        if (i != a.length)
            for (; i < a.length; i++)
                list.add(a[i]);
        int[] ret = new int[list.getSize()];

        for (int i1 = 0; i1 < ret.length; i1++) {
            ret[i1] = list.get(i1);
        }
        return ret;
    }
}
