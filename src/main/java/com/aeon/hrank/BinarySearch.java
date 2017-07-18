package com.aeon.hrank;

import java.util.stream.IntStream;

/**
 * Created by roshane on 7/15/17.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] a = {11, 12, 13, 24, 35, 56, 67, 88, 99, 100};
//        int[] a = new int[1000];
//        IntStream.range(1, 1000)
//                .forEach(i -> a[i - 1] = i);
//        a[999]=10;
//        for (int i : a) {
        System.out.printf("binarySearch(%d): %d\n", -5, binarySearch(a, -5));
//        }
    }

    static int binarySearch(int[] input, int k) {
        int lower = 0;
        int upper = input.length;
        return search(input, k, lower, upper);
    }

    static int search(int[] array, int k, int low, int high) {

        int mid = (low + high) / 2;
//        System.out.printf("\t\tSearch: %d Mid: %d Value: %d\n", k, mid, array[mid]);
        if (array[mid] == k) {
            return mid;
        } else if ((mid == array.length - 1 || mid == 0) && array[mid] != k) {
            return -1;
        } else if (array[mid] > k) {
            return search(array, k, low, mid);
        } else {
            return search(array, k, mid, high);
        }
    }
}
