package com.aeon.prob;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roshane on 7/9/2017.
 */
public class OneEditAway {

    private static class Pair {
        private String a, b;

        Pair(String x, String y) {
            a = x;
            b = y;
        }

    }

    public static void main(String[] args) {
        Map<Integer, Pair> words = new HashMap<>();
        words.put(1, new Pair("pale", "ple"));
        words.put(2, new Pair("pales", "pale"));
        words.put(3, new Pair("pale", "bale"));
        words.put(4, new Pair("pale", "bake"));
        words.put(5, new Pair("aple", "apple"));
        words.put(6, new Pair("apple", "aple"));

        words.entrySet()
                .forEach(e -> {
                    Pair p = e.getValue();
                    boolean isOneEdit = oneEditAway(p.a, p.b);
                    System.out.printf("editCount(%s, %s): => 1 edit away [%b]\n", p.a,
                            p.b,
                            isOneEdit);
                });
    }

    private static boolean oneEditAway(String s1, String s2) {
        if (s1.length() == s2.length() + 1) {
            return isOneRemoved(s1, s2);
        } else if (s1.length() + 1 == s2.length()) {
            return isOneInsert(s1, s2);
        } else if (s1.length() == s2.length()) {
            return isOneChange(s1, s2);
        }
        return false;
    }

    private static boolean isOneChange(String s1, String s2) {
        Map<Character, Integer> charMap = buildCharMap(s1);
        for (int i = 0; i < s2.length(); i++) {
            charMap.compute(s2.charAt(i), (k, v) -> v == null ? 1 : v - 1);
        }
        System.out.println("isOneChange: " + charMap);
        return editCount(charMap) == 2;

    }

    private static boolean isOneInsert(String s1, String s2) {
        Map<Character, Integer> charCount = buildCharMap(s2);
        for (int i = 0; i < s1.length(); i++) {
            charCount.compute(s1.charAt(i), (k, v) -> v == null ? 1 : v - 1);
        }
        System.out.println("isOneInsert: " + charCount);
        return editCount(charCount) == 1;
    }

    private static boolean isOneRemoved(String s1, String s2) {
        Map<Character, Integer> charMap = buildCharMap(s1);
        for (int i = 0; i < s2.length(); i++) {
            charMap.compute(s2.charAt(i), (k, v) -> v == null ? 1 : v - 1);
        }
        System.out.println("isOneRemoved: " + charMap);
        return editCount(charMap) == 1;
    }

    private static Map<Character, Integer> buildCharMap(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charMap.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }
        return charMap;
    }

    private static int editCount(Map<Character, Integer> charMap) {
        return (int) charMap.entrySet()
                .stream()
                .filter(e -> e.getValue() != 0)
                .count();
    }
}
