package sorting;

import java.util.Objects;

public class SortObject implements Comparable<SortObject>{

    public static int compareCounter = 0;
    public static int equalsCounter = 0;
    public static int hashCounter = 0;
    private int number;

    public SortObject(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(SortObject o) {
        compareCounter++;
        return this.number - o.getNumber();
    }

    @Override
    public boolean equals(Object object) {
        equalsCounter++;
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        SortObject that = (SortObject) object;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        hashCounter++;
        return Objects.hash(number);
    }
}
