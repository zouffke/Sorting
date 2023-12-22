package sorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class BucketSort extends Sorter{
    private BucketSort(){}

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

    public static <T extends Comparable<T>> void sort(T[] arr){
        List<T> list = Arrays.stream(arr).toList();
        sort(list);
        Sorter.updateArr(list, arr);
    }
}
