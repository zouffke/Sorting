using System;
using System.Collections.Generic;
using System.Linq;

/// <summary>
/// Selection sort implementation
/// O(n²)
/// </summary>
public static class SelectionSort
{
    /// <summary>
    /// Sorts a list of comparable objects in ascending order using selection sort
    /// </summary>
    /// <param name="list">The list to be sorted</param>
    public static void Sort<T>(List<T> list) where T : IComparable<T>
    {
        for (int i = 0; i < list.Count; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < list.Count; j++)
            {
                if (list[j].CompareTo(list[minIndex]) < 0)
                {
                    minIndex = j;
                }
            }

            T temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }
}