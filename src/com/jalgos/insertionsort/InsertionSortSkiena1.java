package com.jalgos.insertionsort;

import java.util.Arrays;
import java.util.List;

/**
 * Based on:
 * Steven S. Skiena. The Algorithm Design Manual. Second Edition. Springer, 2008.
 * ISBN: 978-1-84800-069-8
 */
public class InsertionSortSkiena1 {

    public static void main(String[] args) {
        List<Integer> testList = Arrays.asList(2, 1, 1, 7, 9, 3 ,5);
        System.out.println("IN: " + testList);
        insertionSort(testList, testList.size());
        System.out.println("OUT: " + testList);
    }

    public static void insertionSort(List<Integer> s, int n) {
        int i, j; // counters
        Integer swapObject;

        for (i = 1; i < n; i++) {
            j = i;
            while (j > 0 && s.get(j).compareTo(s.get(j - 1)) < 0) {
                swapObject = s.get(j);
                s.set(j, s.get(j - 1));
                s.set(j - 1, swapObject);
                j = j - 1;
            }
        }
    }
}
