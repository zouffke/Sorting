package sorting.sorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class MergeSort extends Sorter {
    private MergeSort() {
    }

    public static <T extends Comparable<T>> void sort(List<T> list) {
        sort(list, 0, list.size() - 1);
    }

    private static <T extends Comparable<T>> void sort(List<T> list, int l, int r) {
        if (l < r){
            int m = l + (r - l) / 2;
            sort(list, l, m);
            sort(list, m + 1, r);

            merge(list, l, m, r);
        }
    }

    private static <T extends Comparable<T>> void merge(List<T> list, int l, int m, int r) {
    List<T> left = new ArrayList<>(list.subList(l, m + 1));
    List<T> right = new ArrayList<>(list.subList(m + 1, r + 1));

    int i = 0, j = 0, k = l;

    while (i < left.size() && j < right.size()){
        list.set(k++, (left.get(i).compareTo(right.get(j)) <= 0) ? left.get(i++) : right.get(j++));
    }

    while (i < left.size()) list.set(k++, left.get(i++));
    while (j < right.size()) list.set(k++, right.get(j++));
}

    public static <T extends Comparable<T>> void sort(T[] arr) {
        List<T> list = Arrays.stream(arr).toList();
        sort(list);
        updateArr(list, arr);
    }
}
