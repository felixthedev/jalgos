package com.jalgos.mergesort;

import java.util.Arrays;

/**
 * Top-down mergesort.
 *
 * Based on:
 * Robert Sedgewick, Kevin Wayne. Algorithms. Fourth Edition. Addison-Wesley, 2011.
 * ISBN: 978-0-321-57351-3
 */
public class MergeSortTDSedgewick1 {

    public static void main(String[] args) {
        Integer[] testArray = {2, 1, 1, 7, 9, 3 ,5};
        System.out.println("IN: " + Arrays.toString(testArray));
        sort(testArray);
        System.out.println("OUT: " + Arrays.toString(testArray));
    }

    private static Integer[] aux; // auxiliary array for merges

    public static void sort(Integer[] a) {
        aux = new Integer[a.length]; // Allocate space just once.
        sort(a, 0, a.length - 1);
    }

    private static void sort(Integer[] a, int lo, int hi) {
        // Sort a[lo..hi].
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;

        sort(a, lo, mid); // Sort left half.
        sort(a, mid + 1, hi); // Sort right half.
        merge(a, lo, mid, hi); // Merge results.
    }

    private static void merge(Integer[] a, int lo, int mid, int hi) {
        // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) aux[k] = a[k]; // Copy a[lo..hi] to aux[lo..hi].

        for (int k = lo; k <= hi; k++) {
            // Merge back to a[lo..hi].
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) < 0) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
}
