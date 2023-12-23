package sorting.sorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Bucket sort implementation
 * O(n²)
 *
 * @see <a href="https://www.geeksforgeeks.org/bucket-sort-2/">Bucket sort</a>
 */
public final class BucketSort extends Sorter {
    /**
     * Prevent instantiation
     */
    private BucketSort() {
    }

    /**
     * Sorts a list of comparable objects using bucket sort
     *
     * @param list the list to be sorted
     * @param <T>  the type of the objects in the list
     */
    public static <T extends Comparable<T>> void sort(List<T> list) {
        int max = list.stream().max(T::compareTo).get().hashCode();
        int min = list.stream().min(T::compareTo).get().hashCode();
        int range = max - min + 1;
        int bucketSize = 10;
        int bucketCount = (int) Math.ceil((double) range / bucketSize);
        List<List<T>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        for (T t : list) {
            int bucketIndex = (t.hashCode() - min) / bucketSize;
            buckets.get(bucketIndex).add(t);
        }
        list.clear();
        for (List<T> bucket : buckets) {
            InsertionSort.sort(bucket);
            list.addAll(bucket);
        }
    }

    /**
     * Sorts an array of comparable objects using bucket sort
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
