import org.junit.jupiter.api.Test;
import sorters.BubbleSort;
import sorters.InsertionSort;
import sorters.SelectionSort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SortingTest {

    private List<SortObject> list;

    @Test
    void bubble() {
        System.out.println("BUBBLE SORT");
        execute(() -> BubbleSort.sort(list));
    }

    @Test
    void selection() {
        System.out.println("SELECTION SORT");
        execute(() -> SelectionSort.sort(list));
    }

    @Test
    void insertion() {
        System.out.println("INSERTION SORT");
        execute(() -> InsertionSort.sort(list));
    }

    @Test
    void bucket() {
        System.out.println("BUCKET SORT");
        execute(() -> sorters.BucketSort.sort(list));
    }

    private void execute(Runnable r) {
        List<Integer> se = new ArrayList<>();
        for (int i = 10; i < 1001; i += 10) {
            fillList(i);
            r.run();
            int compared = SortObject.compareCounter + SortObject.equalsCounter + SortObject.hashCounter;
            if (i >= 50 && i <= 150) {
                se.add(compared);
            }
            assertTrue(checkSort(list));
            System.out.printf("%d\n", compared);
            SortObject.compareCounter = 0;
            SortObject.equalsCounter = 0;
            SortObject.hashCounter = 0;
        }
        System.out.println(FunctionCalculator.getFunction(se.stream().mapToInt(i -> i).toArray()));
    }

    private void fillList(int size) {
        list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new SortObject(size - i));
        }
    }

    private static <T extends Comparable<T>> boolean checkSort(List<T> list) {
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i - 1)) < 0 || list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    private static <T extends Comparable<T>> boolean checkSort(T[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i - 1]) < 0 || arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}