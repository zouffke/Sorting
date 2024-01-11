using System;
using System.Collections.Generic;
using System.Linq;

/// <summary>
/// Insertion sort implementation
/// O(n²)
/// </summary>
public static class InsertionSort
{
    /// <summary>
    /// Sorts a list of comparable objects in ascending order using insertion sort
    /// </summary>
    /// <param name="list">The list to be sorted</param>
    public static void Sort<T>(List<T> list) where T : IComparable<T>
    {
        for (int i = 1; i < list.Count; i++)
        {
            int j = i;
            while (j > 0 && list[j].CompareTo(list[j - 1]) < 0)
            {
                T temp = list[j];
                list[j] = list[j - 1];
                list[j - 1] = temp;
                j--;
            }
        }
    }
}