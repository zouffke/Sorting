package sorting.sorters;

import java.util.Arrays;
import java.util.List;

/**
 /**
 * Quick sort implementation
 * O(n²)
 *
 * @see Sorter
 * @see <a href="https://www.geeksforgeeks.org/quick-sort/">Quick Sort</a>
 */
public class QuickSort extends Sorter {
    // Private constructor to prevent instantiation
    private QuickSort() {
    }

    /**
     * Sorts the given list using the QuickSort algorithm.
     * @param list the list to be sorted
     * @param <T> the type of elements in the list. Must be a subtype of Comparable<T>
     */
    public static <T extends Comparable<T>> void sort(List<T> list) {
        sort(list, 0, list.size() - 1);
    }

    /**
     * Swaps the elements at the given indices in the list.
     * @param list the list in which to swap elements
     * @param i the index of one element to be swapped
     * @param j the index of the other element to be swapped
     * @param <T> the type of elements in the list. Must be a subtype of Comparable<T>
     */
    private static <T extends Comparable<T>> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /**
     * Partitions the given subarray and returns the index of the pivot after partitioning.
     * @param list the list to be partitioned
     * @param low the starting index of the subarray
     * @param high the ending index of the subarray
     * @param <T> the type of elements in the list. Must be a subtype of Comparable<T>
     * @return the index of the pivot after partitioning
     */
    private static <T extends Comparable<T>> int partition(List<T> list, int low, int high) {
        T pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) < 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    /**
     * Recursively sorts the given subarray using the QuickSort algorithm.
     * @param list the list to be sorted
     * @param low the starting index of the subarray
     * @param high the ending index of the subarray
     * @param <T> the type of elements in the list. Must be a subtype of Comparable<T>
     */
    private static <T extends Comparable<T>> void sort(List<T> list, int low, int high) {
        if (low < high) {
            int pivot = partition(list, low, high);
            sort(list, low, pivot - 1);
            sort(list, pivot + 1, high);
        }
    }

    /**
     * Sorts the given array using the QuickSort algorithm.
     * @param arr the array to be sorted
     * @param <T> the type of elements in the array. Must be a subtype of Comparable<T>
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        List<T> list = Arrays.stream(arr).toList();
        sort(list);
        updateArr(list, arr);
    }
}