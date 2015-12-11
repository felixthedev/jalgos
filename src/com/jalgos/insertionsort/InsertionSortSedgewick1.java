package com.jalgos.insertionsort;

import java.util.Arrays;

/**
 * Insertion sort.
 *
 * Based on:
 * Robert Sedgewick, Kevin Wayne. Algorithms. Fourth Edition. Addison-Wesley, 2011.
 * ISBN: 978-0-321-57351-3
 */
public class InsertionSortSedgewick1 {

    public static void main(String[] args) {
        Integer[] testArray = {2, 1, 1, 7, 9, 3 ,5};
        System.out.println("IN: " + Arrays.toString(testArray));
        sort(testArray);
        System.out.println("OUT: " + Arrays.toString(testArray));
    }

    public static void sort(Integer[] a) {
        // Sort a[] into increasing order.
        int N = a.length;
        for (int i = 1; i < N; i++) {
            // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
            for (int j = i; j > 0 && a[j].compareTo(a[j - 1]) < 0; j--) {
                Integer swapObject = a[j];
                a[j] = a[j - 1];
                a[j - 1] = swapObject;
            }
        }
    }
}
