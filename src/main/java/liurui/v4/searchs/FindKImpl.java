package liurui.v4.searchs;

import liurui.defines.searchs.FindK;
import liurui.defines.structures.Item;

/**
 * 找出数组中第k大的数
 */
public class FindKImpl implements FindK {

    /**
     * 找出数组中第k大的数
     *
     * @param ary 数组
     * @param k   第k
     * @return 第k大的数
     */
    @Override
    public int find(int[] ary, int k) {
        int begin = 0 ;
        int end = ary.length - 1;
        while (true){
            int i = partition(ary , begin , end);

            if(i+1 == k){
                return ary[i];
            }else if(i+1 > k){
                end = i-1;
            }else{
                begin = i+1;
            }
        }
    }


    private int partition(int[] ary, int begin, int end) {
        if (begin >= end) return begin;
        int item = ary[begin];

        while (begin < end) {
            while (begin < end && ary[end] < item) {
                end--;
            }

            if (begin < end) {
                ary[begin++] = ary[end];
            }

            while (begin<end && ary[begin] >= item){
                begin++;
            }

            if(begin < end){
                ary[end--] = ary[begin];
            }
        }
        ary[begin] = item;
        return begin;
    }
}
