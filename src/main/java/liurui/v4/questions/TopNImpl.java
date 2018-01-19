package liurui.v4.questions;

import liurui.defines.questions.TopN;

import javax.swing.event.ChangeListener;
import javax.swing.text.AsyncBoxView;
import java.util.Arrays;

public class TopNImpl implements TopN {
    /**
     * 求数组中最大的前num个数
     *
     * @param data 数组
     * @param num  需要返回的数量
     * @return 最大数列表，结果从大到小排列
     */
    @Override
    public int[] max(int[] data, int num) {
        if (data == null || data.length == 0 || num <= 0 || num > data.length) return null;
        int[] heap = new int[num + 1];

        for (int item : data) {
            //未满
            if (heap[0] != heap.length - 1) {
                heap[0]++;
                int i = heap[0];

                while (i > 1 && heap[i / 2] > item) {
                    heap[i] = heap[i / 2];
                    i /= 2;
                }
                heap[i] = item;
            } else if (heap[1] < item) {
                int parent = 1;
                int child = 2;

                while (child <= heap[0]) {
                    if (child + 1 <= heap[0] && heap[child] > heap[child + 1]) {
                        child += 1;
                    }

                    if (heap[child] >= item) {
                        break;
                    } else {
                        heap[parent] = heap[child];
                        parent = child;
                        child *= 2;
                    }
                }
                heap[parent] = item;
            }
        }

        int[] ret = new int[num];
        int i = num - 1;

        while (true) {
            ret[i--] = heap[1];

            if (heap[0] == 1) break;
            int item = heap[heap[0]];
            heap[0]--;

            int parent = 1;
            int child = 2;

            while (child <= heap[0]) {
                if (child + 1 <= heap[0] && heap[child] > heap[child + 1]) {
                    child++;
                }

                if (heap[child] >= item) {
                    break;
                } else {
                    heap[parent] = heap[child];
                    parent = child;
                    child *= 2;
                }
            }
            heap[parent] = item;
        }
        return ret;
    }

    /**
     * 求数组中最小的前num个数
     *
     * @param data 数组
     * @param num  需要返回的数量
     * @return 最小数列表，结果从小到大排列
     */
    @Override
    public int[] min(int[] data, int num) {
        int[] heap = new int[num + 1];

        for (int item : data) {
            //未满
            if (heap[0] != heap.length - 1) {
                heap[0]++;
                int i = heap[0];

                while (i > 1 && heap[i / 2] < item) {
                    heap[i] = heap[i / 2];
                    i /= 2;
                }
                heap[i] = item;
            } else if (heap[1] > item) {
                int parent = 1;
                int child = 2;

                while (child <= heap[0]) {
                    if (child + 1 <= heap[0] && heap[child] < heap[child + 1]) {
                        child++;
                    }

                    if (heap[child] <= item) {
                        break;
                    } else {
                        heap[parent] = heap[child];
                        parent = child;
                        child *= 2;
                    }
                }
                heap[parent] = item;
            }
        }

        int[] ret = new int[num];
        int i =  num-1;

        while (true){
            ret[i--] =    heap[1];
            if(heap[0] ==1){
                break;
            }
            int item = heap[heap[0]];
            heap[0]--;
            int parent =1;
            int child = 2;

            while (child <=  heap[0]){
                if(child +1 <= heap[0] && heap[child] <  heap[child+1]){
                    child++;
                }
                if(heap[child]<=item){
                    break;
                }else{
                    heap[parent] = heap[child];
                    parent=child;
                    child*=2;
                }
            }
            heap[parent] = item;
        }
        return ret;
    }
}
