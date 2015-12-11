package com.jalgos.mergesort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Top-down mergesort.
 *
 * Based on:
 * Steven S. Skiena. The Algorithm Design Manual. Second Edition. Springer, 2008.
 * ISBN: 978-1-84800-069-8
 */
public class MergeSortTDSkiena1 {

    public static void main(String[] args) {
        List<Integer> testList = Arrays.asList(2, 1, 1, 7, 9, 3 ,5);
        System.out.println("IN: " + testList);
        mergesort(testList, 0, testList.size() - 1);
        System.out.println("OUT: " + testList);
    }

    public static void mergesort(List<Integer> s, int low, int high) {
        int middle; // index of middle element

        if (low < high) {
            middle = (low + high) / 2;
            mergesort(s, low, middle);
            mergesort(s, middle + 1, high);
            merge(s, low, middle, high);
        }
    }

    private static void merge(List<Integer> s, int low, int middle, int high) {
        int i; // counter
        Queue<Integer> buffer1 = new LinkedList<Integer>(); // buffers to hold elements for merging
        Queue<Integer> buffer2 = new LinkedList<Integer>(); // buffers to hold elements for merging

        for (i = low; i <= middle; i++) buffer1.add(s.get(i));
        for (i = middle + 1; i <= high; i++) buffer2.add(s.get(i));

        i = low;

        while (!(buffer1.isEmpty() || buffer2.isEmpty())) {
            if (buffer1.peek().compareTo(buffer2.peek()) <= 0) {
                s.set(i++, buffer1.poll());
            } else {
                s.set(i++, buffer2.poll());
            }
        }

        while (!buffer1.isEmpty()) s.set(i++, buffer1.poll());
        while (!buffer2.isEmpty()) s.set(i++, buffer2.poll());
    }

}
