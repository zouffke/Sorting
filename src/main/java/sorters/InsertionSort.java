package sorters;

import java.util.Arrays;
import java.util.List;

/**
 * Insertion sort implementation
 * O(n²)
 *
 * @see <a href="https://www.geeksforgeeks.org/insertion-sort/">Insertion sort</a>
 */
public final class InsertionSort extends Sorter {

    private InsertionSort() {
    }

    public static <T extends Comparable<T>> void sort(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            int j = i;
            while (j > 0 && list.get(j).compareTo(list.get(j - 1)) < 0) {
                T temp = list.get(j);
                list.set(j, list.get(j - 1));
                list.set(j - 1, temp);
                j--;
            }
        }
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        List<T> list = Arrays.stream(arr).toList();
        sort(list);
        Sorter.updateArr(list, arr);
    }
}
