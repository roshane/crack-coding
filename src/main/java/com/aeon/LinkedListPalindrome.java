package com.aeon;

import java.util.*;

/**
 * Created by roshane on 7/11/2017.
 */
public class LinkedListPalindrome {

    public static void main(String[] args) {
        List<Character> characters=new ArrayList<>();
        characters.add('T');
        characters.add('a');
        characters.add('c');
        characters.add('t');
        characters.add(' ');
        characters.add('C');
        characters.add('o');
        characters.add('a');
        System.out.println("isPalindrome "+characters+" : "+isPalindrome(characters));
    }

    static boolean isPalindrome(List<Character> characters) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : characters) {
            if (isAlphabeticChar(c)) {
                charCount.compute(toLowerCase(c), (k, v) -> v == null ? 1 : v + 1);
            }
        }

        boolean foundOddChar = false;
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() % 2 != 0 && foundOddChar) {
                System.out.println("> not palindrome");
                return false;
            }
            if (entry.getValue() % 2 != 0) {
                foundOddChar = true;
            }
        }
        return true;
    }

    private static char toLowerCase(char c) {
        if (isUppercaseChar(c)) {
            int diff = ((int) 'a' - (int) 'A');
            int current = (int) c;
            return (char) (current + diff);
        }
        return c;
    }

    private static boolean isUppercaseChar(char c) {
        int current = (int) c;
        int A = (int) 'A';
        int Z = (int) 'Z';
        return (current <= Z && current >= A);
    }

    private static String toLowerCase(String str) {
        String result = ""; //StringBuilder sb=new StringBuilder();
        for (char c : str.toCharArray()) {
            result += toLowerCase(c);
        }
        return result;
    }

    static boolean isAlphabeticChar(char c) {
        int a = (int) 'a';
        int z = (int) 'z';
        int A = (int) 'A';
        int Z = (int) 'Z';
        int current = (int) c;
        return ((current >= a && current <= z) || (current <= Z && current >= A));

    }
}
