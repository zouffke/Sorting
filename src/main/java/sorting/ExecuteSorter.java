package sorting;

import java.util.ArrayList;
import java.util.List;

public final class ExecuteSorter {

    private List<SortObject> list;
    private SortObject[] arr;

    public ExecuteSorter() {
    }

    public boolean execute(Runnable r) {
        List<Integer> se = new ArrayList<>();
        for (int i = 10; i < 1001; i += 10) {
            fillList(i);
            r.run();
            int compared = SortObject.compareCounter + SortObject.equalsCounter + SortObject.hashCounter;
            if (i >= 50 && i <= 150) {
                se.add(compared);
            }
            if (!checkSort(list)) return false;
            System.out.printf("%d\n", compared);
            SortObject.compareCounter = 0;
            SortObject.equalsCounter = 0;
            SortObject.hashCounter = 0;
        }
        System.out.println(FunctionCalculator.getFunction(se.stream().mapToInt(i -> i).toArray()));
        return true;
    }

    public void fillList(int size) {
        this.list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new SortObject(size - i));
        }
    }

    public void fillArr(int size) {
        this.arr = new SortObject[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new SortObject(size - i);
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

    private <T extends Comparable<T>> boolean checkSort(T[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i - 1]) < 0 || arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public List<SortObject> getList() {
        return list;
    }

    public SortObject[] getArr() {
        return arr;
    }
}
