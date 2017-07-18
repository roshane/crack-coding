package com.aeon.cict;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roshane on 7/16/17.
 */
public class PalindromePermutation {

    public static void main(String[] args) {
//        String s="Tact Coa";
        String s="tactcoapapa";
        System.out.printf("isPalindromePermutation(%s): %b",s,isPalindromePermutation(s));
    }

    static boolean isPalindromePermutation(String a) {

        boolean foundUniqueChar = false;

        a = a.toLowerCase();

        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            char current = a.charAt(i);
            if (current != ' ') {
                charMap.compute(current, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                if (foundUniqueChar) {
                    return false;
                }
                foundUniqueChar = true;
            }
        }
        return true;
    }
}
