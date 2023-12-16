package sorters;

import java.util.Arrays;
import java.util.List;

public final class BubbleSort {
    private BubbleSort() {
    }

    public static <T extends Comparable<T>> void sort(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        List<T> list = Arrays.stream(arr).toList();
        sort(list);
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
    }
}