package sorting;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sorting.sorters.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SortingTest {
    private static ExecuteSorter executeSorter;
    private static Writer writer;
    private List<SortObject> list;

    @BeforeAll
    static void beforeAll() {
        executeSorter = new ExecuteSorter();
        writer = new Writer("C:\\Users\\zouff\\PycharmProjects\\Sorting\\src\\sorting\\sorters\\");
    }

    @Test
    void bubble() {
        System.out.println("BUBBLE SORT");
        List<Integer> operations = new ArrayList<>();
        for (int i = 10; i <= 1000; i += 10) {
            fillList(i);
            operations.add(executeSorter.execute(() -> BubbleSort.sort(list)));
            assertTrue(checkSort(list));
        }
        writer.write("bubble.csv", operations, 10);
    }

    @Test
    void selection() {
        System.out.println("SELECTION SORT");
        List<Integer> operations = new ArrayList<>();
        for (int i = 10; i <= 1000; i += 10) {
            fillList(i);
            operations.add(executeSorter.execute(() -> SelectionSort.sort(list)));
            assertTrue(checkSort(list));
        }
        writer.write("selection.csv", operations, 10);
    }

    @Test
    void insertion() {
        System.out.println("INSERTION SORT");
        List<Integer> operations = new ArrayList<>();
        for (int i = 10; i <= 1000; i += 10) {
            fillList(i);
            operations.add(executeSorter.execute(() -> InsertionSort.sort(list)));
            assertTrue(checkSort(list));
        }
        writer.write("insertion.csv", operations, 10);
    }

    @Test
    void bucket() {
        System.out.println("BUCKET SORT");
        List<Integer> operations = new ArrayList<>();
        for (int i = 10; i <= 1000; i += 10) {
            fillList(i);
            operations.add(executeSorter.execute(() -> BucketSort.sort(list)));
            assertTrue(checkSort(list));
        }
        writer.write("bucket.csv", operations, 10);
    }

    @Test
    void merge() {
        System.out.println("MERGE SORT");
        List<Integer> operations = new ArrayList<>();
        for (int i = 10; i <= 10000; i += 10) {
            fillList(i);
            operations.add(executeSorter.execute(() -> MergeSort.sort(list)));
            assertTrue(checkSort(list));
        }
        writer.write("merge.csv", operations, 10);
    }

    private void fillList(int size) {
        this.list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new SortObject(size - i));
        }
    }

    private <T extends Comparable<T>> boolean checkSort(List<T> list) {
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i - 1)) < 0 || list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }
}