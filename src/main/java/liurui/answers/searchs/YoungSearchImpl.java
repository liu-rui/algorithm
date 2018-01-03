package liurui.answers.searchs;

import liurui.defines.searchs.YoungSearch;

/***
 * 定位查找杨氏矩阵
 */
public class YoungSearchImpl implements YoungSearch {

    public boolean search(int[][] data, int item) {
        final int MAX_ROW = data.length;
        final int MAX_COLUMN = data[0].length;
        int row = 0;
        int column = MAX_COLUMN - 1;

        while (row < MAX_ROW && column >= 0) {
            if (data[row][column] == item) {
                return true;
            } else if (data[row][column] > item) {
                column--;
            } else {
                row++;
            }
        }

        return false;
    }
}
