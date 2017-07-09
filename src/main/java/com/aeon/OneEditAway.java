package com.aeon;

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

        words.entrySet()
                .forEach(e -> {
                    Pair p = e.getValue();
                    int editCount = editCount(p.a, p.b);
                    System.out.printf("editCount(%s, %s): %d => 1 or 0 edit away %b\n", p.a,
                            p.b,
                            editCount,
                            (editCount == 0 || editCount == 1));
                });
    }

    private static int editCount(String s1, String s2) {

        int count = 0;

//        if (s1.length() != s2.length()) {
//            count += Math.abs(s1.length() - s2.length());
//        }
        boolean[] charMap = new boolean[128];
        for (int i = 0; i < s1.length(); i++) {
            charMap[s1.charAt(i)] = true;
        }

        for (int i = 0; i < s2.length(); i++) {
            charMap[s2.charAt(i)] = !charMap[s2.charAt(i)];
        }
        for (int i = 0; i < charMap.length; i++) {
            if (charMap[i] && s1.length()!=s2.length()) {
                count += 1;
            }
        }
        return count;
    }
}
