using System;
using System.Collections.Generic;
using System.Linq;

/// <summary>
/// This class provides static methods for performing merge sort on a list.
/// </summary>
public static class MergeSort
{
    /// <summary>
    /// Sorts the given list using merge sort.
    /// </summary>
    /// <param name="list">The list to be sorted.</param>
    public static void Sort<T>(List<T> list) where T : IComparable<T>
    {
        Sort(list, 0, list.Count - 1);
    }

    private static void Sort<T>(List<T> list, int l, int r) where T : IComparable<T>
    {
        if (l < r)
        {
            int m = l + (r - l) / 2;
            Sort(list, l, m);
            Sort(list, m + 1, r);

            Merge(list, l, m, r);
        }
    }

    private static void Merge<T>(List<T> list, int l, int m, int r) where T : IComparable<T>
    {
        List<T> left = new List<T>(list.GetRange(l, m - l + 1));
        List<T> right = new List<T>(list.GetRange(m + 1, r - m));

        int i = 0, j = 0, k = l;

        while (i < left.Count && j < right.Count)
        {
            list[k++] = left[i].CompareTo(right[j]) <= 0 ? left[i++] : right[j++];
        }

        while (i < left.Count)
        {
            list[k++] = left[i++];
        }

        while (j < right.Count)
        {
            list[k++] = right[j++];
        }
    }
}