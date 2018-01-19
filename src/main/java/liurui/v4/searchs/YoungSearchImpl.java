package liurui.v4.searchs;

import liurui.defines.searchs.YoungSearch;

/***
 * 定位查找杨氏矩阵
 */
public class YoungSearchImpl implements YoungSearch {
    @Override
    public boolean search(int[][] data, int item) {
        int i = 0;
        int j = data[0].length-1;

        while (j >= 0 && i < data.length) {
            if (data[i][j] == item) {
                return true;
            } else if (data[i][j] > item) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
