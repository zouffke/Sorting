package sorting;

import java.util.Objects;

/**
 * Class used to test Sorters.
 */
public class SortObject implements Comparable<SortObject>{
    /**
     * Counter for comparing objects.
     */
    public static int compareCounter = 0;
    /**
     * Counter for checking if objects are equal.
     */
    public static int equalsCounter = 0;
    /**
     * Counter for hashing objects.
     */
    public static int hashCounter = 0;
    /**
     * int that is compared when sorting
     */
    private int number;

    /**
     * Constructor
     * @param number int that is compared when sorting
     */
    public SortObject(int number){
        this.number = number;
    }

    /**
     * Returns the number
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the number
     * @param number int that is compared when sorting
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Compares two SortObjects
     * @return 0 if the numbers are equal, a negative number if the number of this object is smaller than the number of the other object, a positive number if the number of this object is bigger than the number of the other object
     */
    @Override
    public int compareTo(SortObject o) {
        compareCounter++;
        return this.number - o.getNumber();
    }

    /**
     * Checks if two SortObjects are equal
     * @param object object to compare to
     * @return true if the numbers are equal, false otherwise
     */
    @Override
    public boolean equals(Object object) {
        equalsCounter++;
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        SortObject that = (SortObject) object;
        return number == that.number;
    }

    /**
     * Returns the hashcode of the number
     * @return hashcode of the number
     */
    @Override
    public int hashCode() {
        hashCounter++;
        return Objects.hash(number);
    }
}
