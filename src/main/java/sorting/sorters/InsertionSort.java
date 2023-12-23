package sorting.sorters;

import java.util.Arrays;
import java.util.List;

/**
 * Insertion sort implementation
 * O(n²)
 *
 * @see <a href="https://www.geeksforgeeks.org/insertion-sort/">Insertion sort</a>
 */
public final class InsertionSort extends Sorter {

    /**
     * Prevent instantiation of utility class
     */
    private InsertionSort() {
    }

    /**
     * Sorts a list of comparable objects in ascending order using insertion sort
     *
     * @param list the list to be sorted
     * @param <T>  the type of the objects in the list
     */
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

    /**
     * Sorts an array of comparable objects in ascending order using insertion sort
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
