package liurui.v4.structures.array;

import liurui.defines.structures.array.FindRotateInflectionPoint;

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
        int begin = 0;
        int end = ary.length - 1;

        while (begin <= end) {
            if (end - begin == 1) {
                if (ary[begin] > ary[0]) {
                    return ary[end];
                } else {
                    return ary[begin];
                }
            }
            int mid = begin + (end - begin) / 2;

            if (ary[mid] > ary[0]) {
                begin = mid;
            } else {
                end = mid;
            }
        }
        return -1;
    }
}
