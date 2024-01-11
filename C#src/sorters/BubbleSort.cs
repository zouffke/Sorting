using System;
using System.Collections.Generic;

/// <summary>
/// This class provides static methods for sorting a list using the QuickSort algorithm.
/// The QuickSort algorithm is a divide-and-conquer algorithm. It works by selecting a 'pivot' element from the list and partitioning the other elements into two sub-lists,
/// according to whether they are less than or greater than the pivot. The sub-lists are then recursively sorted.
/// This class should not be instantiated.
/// </summary>
public static class QuickSort
{
    /// <summary>
    /// Sorts the given list using the QuickSort algorithm.
    /// </summary>
    /// <param name="list">The list to be sorted</param>
    public static void Sort<T>(List<T> list) where T : IComparable<T>
    {
        Sort(list, 0, list.Count - 1);
    }

    private static void Swap<T>(List<T> list, int i, int j)
    {
        T temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    private static int Partition<T>(List<T> list, int low, int high) where T : IComparable<T>
    {
        T pivot = list[high];
        int i = low - 1;
        for (int j = low; j < high; j++)
        {
            if (list[j].CompareTo(pivot) < 0)
            {
                i++;
                Swap(list, i, j);
            }
        }
        Swap(list, i + 1, high);
        return i + 1;
    }

    private static void Sort<T>(List<T> list, int low, int high) where T : IComparable<T>
    {
        if (low < high)
        {
            int pivot = Partition(list, low, high);
            Sort(list, low, pivot - 1);
            Sort(list, pivot + 1, high);
        }
    }
}