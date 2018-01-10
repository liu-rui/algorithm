package liurui.defines.structures.array;

/**
 * 寻找旋转数组的拐点
 * 原数组1,2,3,4,5,6,7旋转后得到4,5,6,7,1,2,3;我们将新得到的数组为原数组
 * 的旋转数组，同时1为这个新数据的拐点
 */
public interface FindRotateInflectionPoint {

    /**
     * 寻找旋转数组的拐点
     *
     * @param ary 旋转数组
     * @return 旋转数组的拐点
     */
    int find(int[] ary);
}
