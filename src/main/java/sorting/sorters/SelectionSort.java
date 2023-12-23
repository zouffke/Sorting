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
public final class SelectionSort extends Sorter {
    /**
     * Prevent instantiation of utility class
     */
    private SelectionSort() {
    }

    /**
     * Sorts a list of comparable objects in ascending order using selection sort
     *
     * @param list the list to be sorted
     * @param <T>  the type of the objects in the list
     */
    public static <T extends Comparable<T>> void sort(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(i)) < 0) {
                    minIndex = j;
                }
            }

            T temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }

    /**
     * Sorts an array of comparable objects in ascending order using selection sort
     *
     * @param arr the array to be sorted
     * @param <T> the type of the objects in the array
     * @see #sort(List)
     * @see Sorter#updateArr(List, Object[])
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        List<T> list = Arrays.stream(arr).toList();
        sort(list);
        updateArr(list, arr);
    }
}
