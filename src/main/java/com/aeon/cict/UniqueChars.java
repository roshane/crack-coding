package com.aeon.cict;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Arrays;

/**
 * Created by roshane on 7/15/17.
 */
public class UniqueChars {

    public static void main(String[] args) {
        long start=System.nanoTime();

        Arrays.asList("helo", "roshane", "world", "abcab", "aacc", "-/")
                .forEach(s -> System.out.printf("isUniqueChars(%s): %b\n", s, isUniqueCharsNaive(s)));

        long end= System.nanoTime();

        System.out.println("running time(ns): "+(end-start));

    }

    static boolean isUniqueCharsNaive(String s) {
        if (s.length() > 128) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                if (current == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isUniqueChars(String s) {
        if (s.length() > 128) {
            return false;
        }
        boolean[] charTable = new boolean[128];
        for (char c : s.toCharArray()) {
            int ascii = (int) c;
            if (charTable[ascii]) {
                return false;
            }
            charTable[ascii] = true;
        }
        return true;
    }
}
