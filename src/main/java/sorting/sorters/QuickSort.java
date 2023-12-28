package sorting.sorters;

import java.util.Arrays;
import java.util.List;

public class QuickSort extends Sorter {
    private QuickSort(){}

    public static <T extends Comparable<T>> void sort(List<T> list) {

    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        List<T> list = Arrays.stream(arr).toList();
        sort(list);
        updateArr(list, arr);
    }
}
