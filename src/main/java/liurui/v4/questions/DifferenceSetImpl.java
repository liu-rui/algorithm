package liurui.v4.questions;

import liurui.defines.questions.DifferenceSet;
import liurui.defines.questions.Intersection;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 请求两个数组的差集
 */
public class DifferenceSetImpl implements DifferenceSet {

    @Override
    public int[] get(int[] a, int[] b) {
        ArrayList<Integer> ret = new ArrayList<>();

        sort(a);
        sort(b);

        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                i++;
                j++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                ret.add(a[i]);
                i++;
            }
        }

        for (; i < a.length; i++) {
            ret.add(a[i]);
        }

        int[] ary = new int[ret.size()];
        for (int i1 = 0; i1 < ret.size(); i1++) {
            ary[i1] = ret.get(i1);
        }
        return ary;
    }

    private void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int begin, int end) {
        if (begin >= end) return;
        int item = a[begin];
        int i = begin;
        int j = end;

        while (i < j) {
            while (i < j && a[j] > item) {
                j--;
            }

            if (i < j) {
                a[i++] = a[j];
            }

            while (i<j && a[i] <= item){
                i++;
            }

            if(i<j){
                a[j--] = a[i];
            }
        }
        a[i] = item;
        sort(a, begin, i - 1);
        sort(a, i + 1, end);
    }
}
