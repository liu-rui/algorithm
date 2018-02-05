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

        while (i<data.length && j>=0){
            int compare = Integer.compare(data[i][j], item);

            switch (compare){
                case 0:
                     return  true;
                case 1:
                    j--;
                    break;
                case -1:
                    i++;
                    break;
            }
        }
        return false;
    }
}
