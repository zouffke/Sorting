package sorting;

/**
 * Class for executing sorting algorithms and calculating their complexity.
 */
public final class ExecuteSorter {

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
     * @see FunctionCalculator#getFunction(int[])
     */
    public int execute(Runnable r) {
        SortObject.compareCounter = 0;
        SortObject.equalsCounter = 0;
        SortObject.hashCounter = 0;
        r.run();
        int compared = SortObject.compareCounter + SortObject.equalsCounter + SortObject.hashCounter;
        SortObject.compareCounter = 0;
        SortObject.equalsCounter = 0;
        SortObject.hashCounter = 0;
        return compared;
    }
}
