package liurui.v4.structures.string;

import liurui.defines.structures.string.PermutationUsingDictionary;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 计算出字符的所有排列情况,使用字典序的方式
 */
public class PermutationUsingDictionaryImpl implements PermutationUsingDictionary {
    /**
     * 输出字符所有的排列情况
     *
     * @param str 参与排列的字符
     * @return 字符所有的排列情况
     */
    @Override
    public String[] permutation(String str) {
        ArrayList<String> ret = new ArrayList<>();
        char[] ary = str.toCharArray();

        sort(ary, new char[ary.length], 0, ary.length - 1);


        while (true) {
            ret.add(String.valueOf(ary));
            int minIndex = -1;

            for (int i = ary.length - 2; i >= 0; i--) {
                if (ary[i] < ary[i + 1]) {
                    minIndex = i;
                    break;
                }
            }

            if (minIndex == -1) {
                break;
            }

            int firstIndex = -1;

            for (int i = ary.length - 1; i > minIndex; i--) {
                if (ary[i] > ary[minIndex]) {
                    firstIndex = i;
                    break;
                }
            }
            swap(ary, minIndex, firstIndex);
            reverse(ary, minIndex + 1, ary.length - 1);
        }

        System.out.println(ret);
        return ret.toArray(new String[ret.size()]);
    }

    private void swap(char[] ary, int a, int b) {
        char tmp = ary[a];

        ary[a] = ary[b];
        ary[b] = tmp;
    }

    private void reverse(char[] ary, int begin, int end) {
        int mid = (end - begin) / 2;

        for (int i = 0; i <= mid; i++) {
            swap(ary, begin + i, end - i);
        }
    }

    private void sort(char[] ary, char[] merged, int begin, int end) {
        if (begin >= end) return;
        int mid = begin + (end - begin) / 2;

        sort(ary, merged, begin, mid);
        sort(ary, merged, mid + 1, end);
        merge(ary, merged, begin, mid, end);
    }

    private void merge(char[] ary, char[] merged, int begin, int mid, int end) {
        int i = begin;
        int j = mid + 1;
        int mergedIndex = begin;

        while (i <= mid && j <= end) {
            if (ary[i] <= ary[j]) {
                merged[mergedIndex++] = ary[i++];
            } else {
                merged[mergedIndex++] = ary[j++];
            }
        }

        while (i <= mid) {
            merged[mergedIndex++] = ary[i++];
        }

        while (j <= end) {
            merged[mergedIndex++] = ary[j++];
        }

        for (mergedIndex = begin; mergedIndex <= end; mergedIndex++) {
            ary[mergedIndex] = merged[mergedIndex];
        }
    }
}
