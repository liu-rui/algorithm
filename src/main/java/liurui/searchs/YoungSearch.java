package liurui.searchs;

/***
 * 定位查找杨氏矩阵
 */
public class YoungSearch {
    private int[][] data;

    public YoungSearch(int[][] data) {
        this.data = data;
    }

    public boolean search(int item) {
        final int MAX_ROW = data.length;
        final int MAX_COLUMN = data[0].length;
        int i = 0;
        int j = MAX_COLUMN - 1;

        while (i<MAX_ROW && j>= 0) {
            if (data[i][j] == item)
                return true;
            else if (data[i][j] > item) {
                j--;
            } else
                i++;
        }

        return false;
    }
}
