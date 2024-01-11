# Sorting algorithms
This repository contains the implementation of the most common sorting algorithms in Java.

## C#
To be able to quickly transfer the algorithms to a Unity project, the algorithms are also written in C# and can be found in the branch [C#_files](https://github.com/zouffke/Sorting/tree/C%23_files).

## Algorithms
The following algorithms are implemented with the following (theoretical) time complexities:
### O(n²)
- [Bubble sort](https://github.com/zouffke/Sorting/blob/master/src/main/java/sorting/sorters/BubbleSort.java)
- [Insertion sort](https://github.com/zouffke/Sorting/blob/master/src/main/java/sorting/sorters/InsertionSort.java)
- [Quick sort](https://github.com/zouffke/Sorting/blob/master/src/main/java/sorting/sorters/QuickSort.java)
- [Selection sort](https://github.com/zouffke/Sorting/blob/master/src/main/java/sorting/sorters/SelectionSort.java)

### O(n log n)
- [Merge sort](https://github.com/zouffke/Sorting/blob/master/src/main/java/sorting/sorters/MergeSort.java)

### O(n)
- [Bucket sort](https://github.com/zouffke/Sorting/blob/master/src/main/java/sorting/sorters/BucketSort.java)

## Extra classes
For cleaner code and to be able to test the algorithms, the following classes are also implemented:
- [Sorter](https://github.com/zouffke/Sorting/blob/master/src/main/java/sorting/sorters/Sorter.java): abstract class that contains the method to update the given array with the sorted list.
- [ExecuteSorter](https://github.com/zouffke/Sorting/blob/master/src/main/java/sorting/ExecuteSorter.java): class that contains the methods to execute the sorting algorithms.
- [FunctionCalculator](https://github.com/zouffke/Sorting/blob/master/src/main/java/sorting/FunctionCalculator.java): class that contains the methods to calculate the time complexity of the algorithms.
- [SortObject](https://github.com/zouffke/Sorting/blob/master/src/main/java/sorting/SortObject.java): The object that is used to sort. It contains a single int, an equals method and a compareTo function.
- [Writer](https://github.com/zouffke/Sorting/blob/master/src/main/java/sorting/Writer.java): class that contains the methods to write the results to a file.

## Testing
The algorithms are tested with the following tests:
- [SortingTest](https://github.com/zouffke/Sorting/blob/master/src/test/java/sorting/SortingTest.java)

``Made by Luca Dandois``