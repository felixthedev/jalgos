package com.jalgos.mergesort;

import java.util.Arrays;

/**
 * Top-down mergesort.
 *
 * Based on:
 * https://en.wikipedia.org/wiki/Merge_sort
 */
public class MergeSortTDWikipedia1 {

    public static void main(String[] args) {
        Integer[] testArray = {2, 1, 1, 7, 9, 3 ,5};
        System.out.println("IN: " + Arrays.toString(testArray));
        topDownMergeSort(testArray, new Integer[testArray.length], testArray.length);
        System.out.println("OUT: " + Arrays.toString(testArray));
    }

    // Array A[] has the items to sort; array B[] is a work array.
    public static void topDownMergeSort(Integer[] a, Integer[] b, int n) {
        topDownSplitMerge(a, 0, n, b);
    }

    // iBegin is inclusive; iEnd is exclusive (A[iEnd] is not in the set).
    private static void topDownSplitMerge(Integer[] a, int iBegin, int iEnd, Integer[] b) {
        if (iEnd - iBegin < 2) // if run size == 1 consider it sorted
            return;
        // recursively split runs into two halves until run size == 1,
        // then merge them and return back up the call chain
        int iMiddle = (iEnd + iBegin) / 2;         // iMiddle = mid point
        topDownSplitMerge(a, iBegin, iMiddle, b);  // split / merge left  half
        topDownSplitMerge(a, iMiddle, iEnd, b);    // split / merge right half
        topDownMerge(a, iBegin, iMiddle, iEnd, b); // merge the two half runs
        copyArray(b, iBegin, iEnd, a);             // copy the merged runs back to A
    }

    // Left half is A[iBegin : iMiddle-1].
    // Right half is A[iMiddle : iEnd-1].
    private static void topDownMerge(Integer[] a, int iBegin, int iMiddle, int iEnd, Integer[] b) {
        int i = iBegin, j = iMiddle;

        // While there are elements in the left or right runs...
        for (int k = iBegin; k < iEnd; k++) {
            // If left run head exists and is <= existing right run head.
            if (i < iMiddle && (j >= iEnd || a[i] <= a[j])) {
                b[k] = a[i];
                i = i + 1;
            } else {
                b[k] = a[j];
                j = j + 1;
            }
        }
    }

    private static void copyArray(Integer[] b, int iBegin, int iEnd, Integer[] a) {
        for (int k = iBegin; k < iEnd; k++) {
            a[k] = b[k];
        }
    }

}
