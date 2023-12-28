package sorting.sorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class provides static methods for performing merge sort on a list or an array.
 * It extends the Sorter class.
 * This class is final and cannot be subclassed.
 *
 * @see Sorter
 * @see <a href="https://www.geeksforgeeks.org/merge-sort/">Merge Sort</a>
 */
public final class MergeSort extends Sorter {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private MergeSort() {
    }

    /**
     * Sorts the given list using merge sort.
     *
     * @param <T>  This is a generic type parameter which extends Comparable. It represents the type of elements in the list.
     * @param list The list to be sorted.
     * @see #sort(List, int, int)
     */
    public static <T extends Comparable<T>> void sort(List<T> list) {
        sort(list, 0, list.size() - 1);
    }

    /**
     * Recursively sorts a portion of the list using merge sort.
     *
     * @param <T>  This is a generic type parameter which extends Comparable. It represents the type of elements in the list.
     * @param list The list to be sorted.
     * @param l    The starting index of the portion to be sorted.
     * @param r    The ending index of the portion to be sorted.
     * @see #merge(List, int, int, int)
     */
    private static <T extends Comparable<T>> void sort(List<T> list, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(list, l, m);
            sort(list, m + 1, r);

            merge(list, l, m, r);
        }
    }

    /**
     * Merges two sorted portions of the list into a single sorted portion.
     *
     * @param <T>  This is a generic type parameter which extends Comparable. It represents the type of elements in the list.
     * @param list The list whose portions are to be merged.
     * @param l    The starting index of the first portion.
     * @param m    The ending index of the first portion and starting index of the second portion.
     * @param r    The ending index of the second portion.
     */
    private static <T extends Comparable<T>> void merge(List<T> list, int l, int m, int r) {
        List<T> left = new ArrayList<>(list.subList(l, m + 1));
        List<T> right = new ArrayList<>(list.subList(m + 1, r + 1));

        int i = 0, j = 0, k = l;

        while (i < left.size() && j < right.size()) {
            list.set(k++, (left.get(i).compareTo(right.get(j)) <= 0) ? left.get(i++) : right.get(j++));
        }

        while (i < left.size()) list.set(k++, left.get(i++));
        while (j < right.size()) list.set(k++, right.get(j++));
    }

    /**
     * Sorts the given array using merge sort.
     *
     * @param <T> This is a generic type parameter which extends Comparable. It represents the type of elements in the array.
     * @param arr The array to be sorted.
     * @see #sort(List)
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        List<T> list = Arrays.stream(arr).toList();
        sort(list);
        updateArr(list, arr);
    }
}