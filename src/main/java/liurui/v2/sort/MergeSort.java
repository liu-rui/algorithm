package liurui.v2.sort;

import liurui.sorts.Sortable;

public class MergeSort implements Sortable {
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
