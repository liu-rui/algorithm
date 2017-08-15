package liurui.v1.sorter;

public class SelectSort implements Sortable {
    @Override
    public int[] sort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[min])
                    min = j;
            }
            if(min != i){
                int tmp =  data[i];
                data[i] = data[min];
                data[min] = tmp;
            }
        }

        return data;
    }
}
