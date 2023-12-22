package sorters;

import java.util.List;

public abstract class Sorter {
    protected static <T> void updateArr(List<T> list, T[] arr){
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
    }
}
