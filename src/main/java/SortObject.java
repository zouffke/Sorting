public class SortObject implements Comparable<SortObject>{

    public static int compareCounter = 0;
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
}
