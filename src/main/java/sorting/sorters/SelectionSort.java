package sorting.sorters;

import java.util.Arrays;
import java.util.List;

/**
 * Selection sort implementation
 * O(n²)
 *
 * @see <a href="https://www.geeksforgeeks.org/selection-sort/">Selection sort</a>
 * @see Sorter
 */
public final class SelectionSort extends Sorter{
    private SelectionSort() {
    }

    public static <T extends Comparable<T>> void sort(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(i)) < 0){
                    minIndex = j;
                }
            }

            T temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        List<T> list = Arrays.stream(arr).toList();
        sort(list);
        updateArr(list, arr);
    }
}
