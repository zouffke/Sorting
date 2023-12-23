package sorting;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sorting.FunctionCalculator;
import sorting.SortObject;
import sorting.sorters.BubbleSort;
import sorting.sorters.InsertionSort;
import sorting.sorters.SelectionSort;
import sorting.sorters.BucketSort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SortingTest {
    private static ExecuteSorter executeSorter;

    @BeforeAll
    static void beforeAll() {
        executeSorter = new ExecuteSorter();
    }

    @Test
    void bubble() {
        System.out.println("BUBBLE SORT");
        assertTrue(executeSorter.execute(() -> BubbleSort.sort(executeSorter.getList()), "bubble.csv"));
    }

    @Test
    void selection() {
        System.out.println("SELECTION SORT");
        assertTrue(executeSorter.execute(() -> SelectionSort.sort(executeSorter.getList()), "selection.csv"));
    }

    @Test
    void insertion() {
        System.out.println("INSERTION SORT");
        assertTrue(executeSorter.execute(() -> InsertionSort.sort(executeSorter.getList()), "insertion.csv"));
    }

    @Test
    void bucket() {
        System.out.println("BUCKET SORT");
        assertTrue(executeSorter.execute(() -> BucketSort.sort(executeSorter.getList()), "bucket.csv"));
    }
}