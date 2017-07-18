package com.aeon.cict;

import java.util.Arrays;

/**
 * Created by roshane on 7/16/17.
 */
public class OneWay {

    public static void main(String[] args) {
        Arrays.asList(new Pair("pael", "ple"),
                new Pair("pales", "pale"),
                new Pair("pale", "bale"),
                new Pair("pale", "bele"),
                new Pair("pale", "bae"))
                .forEach(p -> {
                    System.out.printf("isOneWay(%s,%s): %b", p.a, p.b, isOneway(p.a, p.b));
                    System.out.println();
                });
    }

    static boolean isOneway(String s1, String s2) {

        if (s2.length() == (s1.length() + 1)) {
            System.out.println("\tisOneInsert");
            return isOneInsert(s1, s2);
        } else if (s1.length() - 1 == s2.length()) {
            System.out.println("\tisOneRemove");
            return isOneInsert(s2, s1);
        } else if (s1.length() == s2.length()) {
            System.out.println("\tisOneReplace");
            return isOneReplace(s1, s2);
        }
        return false;
    }

    static boolean isOneInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }

        }
        return true;
    }

    static boolean isOneReplace(String s1, String s2) {
        boolean foundUnique = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundUnique) {
                    return false;
                }
                foundUnique = true;
            }
        }
        return true;
    }
}
