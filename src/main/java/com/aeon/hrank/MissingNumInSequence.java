package com.aeon.hrank;

import javafx.util.converter.IntegerStringConverter;

import java.util.stream.IntStream;

/**
 * Created by roshane on 7/15/17.
 */
public class MissingNumInSequence {

    public static void main(String[] args) {
//        int[] a = {1, 2, 4, 5, 6, 7, 8};
        int[] a = {1, 3, 4, 5};
//        System.out.printf("findMissingNumber(%s): %d", arrayToString(a), findMissingNumber(a));
//        System.out.println();
        int sum = IntStream.range(250, 301)
                .sum();
        System.out.println("sum: "+sum);
    }



    static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }


    static int findMissingNumber(int[] seq) {
        int actualSum = calculateSumOfSequence(seq[0], seq[seq.length - 1]);
        int givenSum = 0;
        for (int i : seq) {
            givenSum += i;
        }
        return actualSum - givenSum;
    }

    static int calculateSumOfSequence(int from, int to) {
        return IntStream.range(from, to + 1)
                .sum();
    }
}
