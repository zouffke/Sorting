package sorting;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for executing sorting algorithms and calculating their complexity.
 */
public final class ExecuteSorter {

    /**
     * List of objects to be sorted.
     */
    private List<SortObject> list;
    /**
     * Array of objects to be sorted.
     */
    private SortObject[] arr;

    /**
     * Constructor.
     */
    public ExecuteSorter() {
    }

    /**
     * Executes sorting algorithms and calculates their complexity.
     *
     * @param r        Runnable object.
     * @param filename name of the file to write sequence to.
     * @return true if sorting was successful, false otherwise.
     * @see #fillList(int)
     * @see #checkSort(List)
     * @see FunctionCalculator#getFunction(int[])
     */
    public boolean execute(Runnable r, String filename) {
        List<Integer> se = new ArrayList<>();
        try (PrintWriter writer = new PrintWriter("C:\\Users\\zouff\\PycharmProjects\\Sorting\\src\\sorting\\sorters\\" + filename, StandardCharsets.UTF_8)) {
            writer.println("operations,objects");
            for (int i = 10; i < 1001; i += 10) {
                fillList(i);
                r.run();
                int compared = SortObject.compareCounter + SortObject.equalsCounter + SortObject.hashCounter;
                if (i >= 50 && i <= 150) {
                    se.add(compared);
                }
                if (!checkSort(list)) return false;
                writer.println(String.format("%d,%d", compared, i));
                System.out.println(compared);
                SortObject.compareCounter = 0;
                SortObject.equalsCounter = 0;
                SortObject.hashCounter = 0;
            }

            System.out.println(FunctionCalculator.getFunction(se.stream().mapToInt(Integer::intValue).toArray()));
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * Fills list with SortObject objects in descending order.
     *
     * @param size size of the list.
     * @see SortObject
     */
    public void fillList(int size) {
        this.list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new SortObject(size - i));
        }
    }

    /**
     * Fills array with SortObject objects in descending order.
     *
     * @param size size of the array.
     * @see SortObject
     */
    public void fillArr(int size) {
        this.arr = new SortObject[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new SortObject(size - i);
        }
    }

    /**
     * Checks if list is sorted.
     *
     * @param list list to be checked.
     * @param <T>  type of objects in the list.
     * @return true if list is sorted, false otherwise.
     */
    private <T extends Comparable<T>> boolean checkSort(List<T> list) {
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i - 1)) < 0 || list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if array is sorted.
     *
     * @param arr array to be checked.
     * @param <T> type of objects in the array.
     * @return true if array is sorted, false otherwise.
     */
    private <T extends Comparable<T>> boolean checkSort(T[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i - 1]) < 0 || arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Getter for list.
     *
     * @return list.
     */
    public List<SortObject> getList() {
        return list;
    }

    /**
     * Getter for array.
     *
     * @return array.
     */
    public SortObject[] getArr() {
        return arr;
    }
}
