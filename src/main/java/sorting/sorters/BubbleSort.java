package sorting.sorters;

import java.util.Arrays;
import java.util.List;

/**
 * Bubble sort implementation
 * O(n²)
 *
 * @see <a href="https://www.geeksforgeeks.org/bubble-sort/">Bubble sort</a>
 * @see Sorter
 */
public final class BubbleSort extends Sorter{
    /**
     * Prevent instantiation
     */
    private BubbleSort() {
    }

    /**
     * Sorts a list of comparable objects using bubble sort
     *
     * @param list the list to be sorted
     * @param <T>  the type of the objects in the list
     */
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

    /**
     * Sorts an array of comparable objects using bubble sort
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