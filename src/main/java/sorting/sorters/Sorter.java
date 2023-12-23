package sorting.sorters;

import java.util.List;

/**
 * Abstract class for all sorting algorithms.
 */
public abstract class Sorter {
    /**
     * Updates the given array with the given list.
     *
     * @param list the list to update the array with
     * @param arr  the array to update
     * @param <T>  the type of the list and array
     */
    protected static <T> void updateArr(List<T> list, T[] arr) {
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
    }
}
