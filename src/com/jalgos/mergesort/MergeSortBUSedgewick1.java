package com.jalgos.mergesort;

import java.util.Arrays;

/**
 * Bottom-up mergesort.
 *
 * Based on:
 * Robert Sedgewick, Kevin Wayne. Algorithms. Fourth Edition. Addison-Wesley, 2011.
 * ISBN: 978-0-321-57351-3
 */
public class MergeSortBUSedgewick1 {

    public static void main(String[] args) {
        Integer[] testArray = {2, 1, 1, 7, 9, 3 ,5};
        System.out.println("IN: " + Arrays.toString(testArray));
        sort(testArray);
        System.out.println("OUT: " + Arrays.toString(testArray));
    }

    private static Integer[] aux; // Auxiliary array for merges.

    public static void sort(Integer[] a) {
        // Do lg N passes of pairwise merges.
        int N = a.length;
        aux = new Integer[N];

        for (int sz = 1; sz < N; sz = sz + sz) { // sz: subarray size
            for (int lo = 0; lo < N - sz; lo += sz + sz) { // lo: subarray index
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
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
