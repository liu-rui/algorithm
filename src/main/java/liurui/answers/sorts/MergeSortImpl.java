package liurui.answers.sorts;

import liurui.defines.sorts.MergeSort;

public class MergeSortImpl implements MergeSort {
    @Override
    public int[] sort(int[] data) {
        sort(data, data ,  0 , data.length- 1);

        return data;
    }

    private void sort(int[] data , int[] tmp , int begin , int end){
        if(begin == end)
        {

        }else{

        }
    }
}
