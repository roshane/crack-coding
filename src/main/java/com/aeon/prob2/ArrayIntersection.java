package com.aeon.prob2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by roshane on 7/18/17.
 */
public class ArrayIntersection {

    public static void main(String[] args) {
        int[][] arrays = {{2, 3, 1, 7, 1}, {2, 5, 7}, {7, 3, 1, 5}};

        List<Set<Integer>> uniqueIntForEach = new ArrayList<>();
        for (int i = 0; i < arrays.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < arrays[i].length; j++) {
                set.add(arrays[i][j]);
            }
            uniqueIntForEach.add(set);
        }

        System.out.println(uniqueIntForEach);


        Map<Integer, Integer> numberFrequency = new HashMap<>();
        for (int i = 0; i < uniqueIntForEach.size(); i++) {
            for (int number : uniqueIntForEach.get(i)) {
                numberFrequency.compute(number, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        System.out.println(numberFrequency);
        List<Integer> intersection = numberFrequency.entrySet()
                .stream()
                .filter(e -> e.getValue() == arrays.length)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(intersection);

        System.out.println(toLowerCase("hELLo-WoORLD"));
        System.out.println(toBinaryString(4));
        mergeSroted();
        isSorted();
    }

    static void isSorted() {
//        int a[] = {0, 1, 2, 3, 4, 5, 6};
        int a[] = {2, 2, 3, 3, 5, 9};
        int max = a[a.length - 1];
        int min = a[0];
        boolean isSorted = true;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                isSorted = false;
                break;
            }
            if (a[i] < min) {
                isSorted = false;
                break;
            }
        }
        System.out.println("sorted: " + isSorted);
    }

    static void mergeSroted() {
        int[] a = {0, 1, 2, 3, 9, 10, 0, 0, 0, 0};
        int[] b = {5, 6, 7, 8};
        int iLastA = 5;
        int iLastB = b.length - 1;
        int iMerged = iLastA + iLastB + 1;
        System.out.println("a: " + BinarySearch.arrayToString(a));
        System.out.println("b: " + BinarySearch.arrayToString(b));
        while (iLastB >= 0) {
            if (iLastA >= 0 && a[iLastA] > b[iLastB]) {
                a[iMerged] = a[iLastA];
                iLastA--;
            } else {
                a[iMerged] = b[iLastB];
                iLastB--;
            }
            iMerged--;
        }
        System.out.println("a: " + BinarySearch.arrayToString(a));
    }

    static String toBinaryString(int a) {
        StringBuilder sb = new StringBuilder();
        int remainder = a;
        while (true) {
            sb.append(remainder % 2);
            remainder /= 2;
            if (remainder == 0) {
                break;
            }
        }
        return sb.reverse().toString();
    }

    static String toLowerCase(String s) { // O(|s|)
        String result = "";
        for (char c : s.toCharArray()) {
            if (isUpperCase(c)) {
                result += toLowerCase(c);
            } else {
                result += c;
            }
        }
        return result;
    }

    static char toLowerCase(char c) { // O(1)
        int offset = a - A;
        if (isUpperCase(c)) {
            int current = (int) c;
            return (char) (current + offset);
        }
        return c;
    }

    static int a = (int) 'a';
    static int z = (int) 'z';
    static int A = (int) 'A';
    static int Z = (int) 'Z';

    static boolean isUpperCase(char c) {
        int current = (int) c;
        return (c >= A) && (c <= Z);
    }
}
