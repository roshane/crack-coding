package com.aeon.prob2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by roshane on 7/17/17.
 */
public class FindSumOfNum {

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 9};
        int b[] = {-1, -2, 3, 9};
        int c[] = {1, -2, 3, 4, 5};
        int d[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int e[] = {1,3,5,7,8,9,0,6,4,2};

        System.out.println(BinarySearch.arrayToString(e));
        bubbleSort(e);
        System.out.println(BinarySearch.arrayToString(e));
//        int[] numbers = findNumbers(a, 7);
//        System.out.println(numbers[0] + "|" + numbers[1]);
//        numbers = findNumbers(b, 7);
//        System.out.println(numbers[0] + "|" + numbers[1]);
//        numbers = findNumbers(c, 8);
//        System.out.println(numbers[0] + "|" + numbers[1]);
//        System.out.println("\n");
//        numbers = findNumbers2(a, 7);
//        System.out.println(numbers[0] + "|" + numbers[1]);
//        numbers = findNumbers2(b, 7);
//        System.out.println(numbers[0] + "|" + numbers[1]);
//        numbers = findNumbers2(c, 8);
//        System.out.println(numbers[0] + "|" + numbers[1]);
        String s1="hello";
        String s2="elloh";

    }


    static int[] findNumbers(int[] arr, int sum) {// O(n log(n))
        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++) {// (n)
            int diff = sum - arr[i];
            int n = Arrays.binarySearch(arr, diff); // log(n)
            if (n >= 0 && n != i) {
                result[0] = arr[i];
                result[1] = arr[n];
            }
        }
        return result;
    }

    static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = i - 1;
            while (j >= 0) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j--;
            }
        }
    }

    static int[] findNumbers2(int[] arr, int sum) {
        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = sum - arr[i];
            if (set.contains(diff)) {
                result[0] = diff;
                result[1] = arr[i];
                break;
            } else {
                set.add(arr[i]);
            }
        }
        return result;
    }
}
