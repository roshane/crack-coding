package com.aeon.prob;

import java.util.Arrays;

/**
 * Created by roshane on 7/9/2017.
 */
public class UniqueChars {

    public static void main(String[] args) {
        Arrays.asList("roshane", "hello", "world", "aa", "abcd", "sheh")
                .forEach(s -> System.out.println("isUnique: " + s + " = " + isUniqueChars(s)));

    }

    private static boolean isUniqueChars(String s) {
        boolean isUnique = true;
        boolean[] charTable = new boolean[128];
        for (int i = 0; i < s.length(); i++) {//n
            if (charTable[(int) s.charAt(i)]) {
                isUnique = false;
                break;
            } else {
                charTable[(int) s.charAt(i)] = true;
            }
        }
        return isUnique;
    }
}
