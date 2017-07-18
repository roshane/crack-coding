package com.aeon.cict;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by roshane on 7/15/17.
 */
public class CheckPermutation {

    public static void main(String[] args) {
        Arrays.asList(
                new Pair("hello", "elHlo"),
                new Pair("roshane", "eanrosh"))
                .forEach(p -> {
                    System.out.printf("isPermutation(%s,%s): %b\n", p.a, p.b, isPermutation(p.a, p.b));
                });
    }

    static boolean isPermutation(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        a=a.toLowerCase();
        b=b.toLowerCase();
        int[] charTable = new int[128];
        for (char c : a.toCharArray()) {
            int ascii = (int) c;
            charTable[ascii]++;
        }
        for (char c : b.toCharArray()) {
            int ascii = (int) c;
            charTable[ascii]--;
            if(charTable[ascii]<0){
                return false;
            }
        }
        return true;
    }
}
