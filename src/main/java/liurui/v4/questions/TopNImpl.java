package liurui.v4.questions;

import liurui.defines.questions.TopN;

import javax.sound.midi.Soundbank;
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
        int[] heap = new int[num + 1];

        for (int item : data) {
            if (heap[0] != num) {
                heap[0]++;
                int i = heap[0];

                while (i / 2 > 0 && heap[i / 2] > item) {
                    heap[i] = heap[i / 2];
                    i /= 2;
                }
                heap[i] = item;
            } else if (heap[1] < item) {
                int parent = 1;
                int child = 2;

                while (child <= heap[0]) {
                    if (child + 1 <= heap[0] && heap[child] > heap[child + 1]) {
                        child++;
                    }

                    if (heap[child] > item) {
                        break;
                    }

                    heap[parent] = heap[child];
                    parent = child;
                    child *= 2;
                }
                heap[parent] = item;
            }
        }

        int[] ret = new int[num];

        for (int i = num - 1; i >= 0; i--) {
            ret[i] = heap[1];

            int item = heap[heap[0]];
            int parent = 1;
            int child = 2;

            heap[0]--;

            if (heap[0] == 0) {
                break;
            }
            while (child <= heap[0]) {
                if (child + 1 <= heap[0] && heap[child] > heap[child + 1]) {
                    child++;
                }

                if (heap[child] > item) {
                    break;
                }
                heap[parent] = heap[child];
                parent = child;
                child *= 2;
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
            if (heap[0] != num) {
                heap[0]++;
                int i = heap[0];

                while (i / 2 > 0 && heap[i / 2] < item) {
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

                    if (heap[child] < item) {
                        break;
                    }
                    heap[parent] = heap[child];
                    parent = child;
                    child *= 2;
                }
                heap[parent] = item;
            }
        }

        int[] ret = new int[num];

        for (int i = num - 1; i >= 0; i--) {
            ret[i] = heap[1];

            int item = heap[heap[0]];
            int parent = 1;
            int child = 2;

            heap[0]--;

            if (heap[0] == 0) {
                break;
            }

            while (child <= heap[0]) {
                if (child + 1 <= heap[0] && heap[child] < heap[child + 1]) {
                    child++;
                }

                if (heap[child] < item) {
                    break;
                }
                heap[parent] = heap[child];
                parent = child;
                child *= 2;
            }
            heap[parent] = item;
        }
        return ret;
    }
}
