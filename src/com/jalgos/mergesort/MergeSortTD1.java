package com.jalgos.mergesort;

import java.util.Arrays;

/**
 * Top-down mergesort in functional style.
 *
 * Based on Skiena and my thoughts.
 */
public class MergeSortTD1 {

    public static void main(String[] args) {
        int[] testArray = {2, 1, 1, 7, 9, 3 ,5};
        System.out.println("IN: " + Arrays.toString(testArray));
        int[] resultArray = mergesort(testArray);
        System.out.println("OUT: " + Arrays.toString(resultArray));
    }

    public static int[] mergesort(int[] a) {
        int aLength = a.length;
        if (aLength > 1) {
            int middle = aLength / 2;
            return merge(mergesort(Arrays.copyOfRange(a, 0, middle)),
                         mergesort(Arrays.copyOfRange(a, middle, aLength)));

        }
        return Arrays.copyOf(a, aLength);
    }

    private static int[] merge(int[] l, int[] r) {
        int lLength = l.length, rLength = r.length;
        int[] out = new int[lLength + rLength];

        int oIndex = 0, lIndex = 0, rIndex = 0;

        while (lIndex < lLength && rIndex < rLength) {
            out[oIndex++] = l[lIndex] < r[rIndex] ? l[lIndex++] : r[rIndex++];
        }

        while (lIndex < lLength) out[oIndex++] = l[lIndex++];
        while (rIndex < rLength) out[oIndex++] = r[rIndex++];

        return out;
    }

}
