package liurui.v4.searchs;

import liurui.defines.searchs.YoungSearch;

/***
 * 定位查找杨氏矩阵
 */
public class YoungSearchImpl implements YoungSearch {
    @Override
    public boolean search(int[][] data, int item) {
        if(data ==  null || data.length ==0 || data[0].length == 0) return false;

        int max_row = data.length;
        int max_column = data[0].length;

        int row = 0;
        int col =  max_row-1;

        while (row< max_column && col>=0){
            if(data[row][col] == item ){
                return true;
            }else if(data[row][col] > item){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}
