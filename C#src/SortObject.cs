using System;
using System.Collections.Generic;

/// <summary>
/// Class used to test Sorters.
/// </summary>
public class SortObject : IComparable<SortObject>
{
    /// <summary>
    /// Counter for comparing objects.
    /// </summary>
    public static int CompareCounter = 0;

    /// <summary>
    /// Counter for checking if objects are equal.
    /// </summary>
    public static int EqualsCounter = 0;

    /// <summary>
    /// Counter for hashing objects.
    /// </summary>
    public static int HashCounter = 0;

    /// <summary>
    /// int that is compared when sorting
    /// </summary>
    private int number;

    /// <summary>
    /// Constructor
    /// </summary>
    /// <param name="number">int that is compared when sorting</param>
    public SortObject(int number)
    {
        this.number = number;
    }

    /// <summary>
    /// Returns the number
    /// </summary>
    /// <returns>number</returns>
    public int GetNumber()
    {
        return number;
    }

    /// <summary>
    /// Sets the number
    /// </summary>
    /// <param name="number">int that is compared when sorting</param>
    public void SetNumber(int number)
    {
        this.number = number;
    }

    /// <summary>
    /// Compares two SortObjects
    /// </summary>
    /// <returns>0 if the numbers are equal, a negative number if the number of this object is smaller than the number of the other object, a positive number if the number of this object is bigger than the number of the other object</returns>
    public int CompareTo(SortObject o)
    {
        CompareCounter++;
        return this.number - o.GetNumber();
    }

    /// <summary>
    /// Checks if two SortObjects are equal
    /// </summary>
    /// <param name="obj">object to compare to</param>
    /// <returns>true if the numbers are equal, false otherwise</returns>
    public override bool Equals(object obj)
    {
        EqualsCounter++;
        if (this == obj) return true;
        if (obj == null || GetType() != obj.GetType()) return false;
        SortObject that = (SortObject)obj;
        return number == that.GetNumber();
    }

    /// <summary>
    /// Returns the hashcode of the number
    /// </summary>
    /// <returns>hashcode of the number</returns>
    public override int GetHashCode()
    {
        HashCounter++;
        return number.GetHashCode();
    }
}