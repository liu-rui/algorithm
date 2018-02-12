package liurui.v4.structures.array;

import liurui.defines.structures.array.FindRotateInflectionPoint;

import java.awt.event.MouseWheelListener;

/**
 * 寻找旋转数组的拐点
 * 原数组1,2,3,4,5,6,7旋转后得到4,5,6,7,1,2,3;我们将新得到的数组为原数组
 * 的旋转数组，同时1为这个新数据的拐点
 */
public class FindRotateInflectionPointImpl implements FindRotateInflectionPoint {

    /**
     * 寻找旋转数组的拐点
     *
     * @param ary 旋转数组
     * @return 旋转数组的拐点
     */
    @Override
    public int find(int[] ary) {
        int i = 0;
        int j = ary.length - 1;

        while (i <= j) {
            if (j - i == 1) {
                if (ary[i] > ary[0]) {
                    return ary[j];
                } else {
                    return ary[i];
                }
            }
            int mid = i + (j - i) / 2;

            if (ary[mid] > ary[0]) {
                i = mid;
            } else {
                j = mid;
            }
        }
        return -1;
    }
}
