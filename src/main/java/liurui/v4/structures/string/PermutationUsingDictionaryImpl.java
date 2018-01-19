package liurui.v4.structures.string;

import jdk.jfr.events.SocketWriteEvent;
import liurui.defines.structures.string.PermutationUsingDictionary;

import java.util.ArrayList;

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
        char[] chars = str.toCharArray();
        ArrayList<String> container = new ArrayList<>();

        sort(chars, 0, chars.length - 1);

        while (true) {
            container.add(String.valueOf(chars));
            int i = chars.length - 2;

            for (; i >= 0 && chars[i] > chars[i + 1]; i--) ;

            if (i == -1) {
                break;
            }

            int j = chars.length - 1;

            for (; j > i && chars[j] < chars[i]; j--) ;
            swap(chars, i, j);
            reverse(chars, i + 1, chars.length - 1);
        }
        return container.toArray(new String[0]);
    }

    private void sort(char[] chars, int begin, int end) {
        if (begin >= end) return;
        int i = begin;
        int j = end;
        char item = chars[begin];

        while (i < j) {
            while (i < j && chars[j] > item) {
                j--;
            }

            if (i < j) {
                chars[i++] = chars[j];
            }

            while (i < j && chars[i] <= item) {
                i++;
            }

            if (i < j) {
                chars[j--] = chars[i];
            }
        }
        chars[i] = item;
        sort(chars, begin, i - 1);
        sort(chars, i + 1, end);
    }


    private void swap(char[] chars, int a, int b) {
        char tmp = chars[a];

        chars[a] = chars[b];
        chars[b] = tmp;
    }

    private void reverse(char[] chars, int begin, int end) {
        int mid = (end - begin) / 2;

        for (int i = 0; i <= mid; i++) {
            swap(chars, begin + i, end - i);
        }
    }
}
