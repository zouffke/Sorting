using System;
using System.Collections.Generic;
using System.Linq;

/// <summary>
/// Bucket sort implementation
/// O(n²)
/// </summary>
public static class BucketSort
{
    /// <summary>
    /// Sorts a list of comparable objects using bucket sort
    /// </summary>
    /// <param name="list">The list to be sorted</param>
    public static void Sort<T>(List<T> list) where T : IComparable<T>
    {
        int max = list.Max().GetHashCode();
        int min = list.Min().GetHashCode();
        int range = max - min + 1;
        int bucketSize = 10;
        int bucketCount = (int)Math.Ceiling((double)range / bucketSize);
        List<List<T>> buckets = new List<List<T>>(bucketCount);
        for (int i = 0; i < bucketCount; i++)
        {
            buckets.Add(new List<T>());
        }
        foreach (T t in list)
        {
            int bucketIndex = (t.GetHashCode() - min) / bucketSize;
            buckets[bucketIndex].Add(t);
        }
        list.Clear();
        foreach (List<T> bucket in buckets)
        {
            InsertionSort.Sort(bucket);
            list.AddRange(bucket);
        }
    }
}

/// <summary>
/// Insertion sort implementation
/// </summary>
public static class InsertionSort
{
    /// <summary>
    /// Sorts a list of comparable objects using insertion sort
    /// </summary>
    /// <param name="list">The list to be sorted</param>
    public static void Sort<T>(List<T> list) where T : IComparable<T>
    {
        for (int i = 1; i < list.Count; i++)
        {
            T key = list[i];
            int j = i - 1;

            while (j >= 0 && list[j].CompareTo(key) > 0)
            {
                list[j + 1] = list[j];
                j = j - 1;
            }
            list[j + 1] = key;
        }
    }
}