package liurui.v4.questions;

import liurui.defines.questions.DifferenceSet;

import java.util.ArrayList;

/**
 * 请求两个数组的差集
 */
public class DifferenceSetImpl implements DifferenceSet {

    @Override
    public int[] get(int[] a, int[] b) {
        sort(a, 0, a.length - 1);
        sort(b, 0, b.length - 1);

        ArrayList<Integer> container = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            int compare = Integer.compare(a[i], b[j]);

            switch (compare) {
                case 0:
                    i++;
                    j++;
                    break;
                case 1:
                    j++;
                    break;
                case -1:
                    container.add(a[i++]);
                    break;
            }
        }

        while (i<a.length){
            container.add(a[i++]);
        }

        int[] ret = new int[container.size()];

        for (int k = 0; k < container.size(); k++) {
            ret[k] = container.get(k);
        }
        return ret;
    }

    private void sort(int[] ary, int begin, int end) {
        if (begin >= end) return;
        int i = begin;
        int j = end;
        int item = ary[i];

        while (i < j) {
            while (i < j && ary[j] > item) {
                j--;
            }

            if (i < j) {
                ary[i++] = ary[j];
            }

            while (i < j && ary[i] <= item) {
                i++;
            }

            if (i < j) {
                ary[j--] = ary[i];
            }
        }
        ary[i] = item;
        sort(ary, begin, i - 1);
        sort(ary, i + 1, end);
    }
}
