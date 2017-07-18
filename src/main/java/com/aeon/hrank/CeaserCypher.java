package com.aeon.hrank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by roshane on 7/14/17.
 */
public class CeaserCypher {

    static boolean isLetter(char c) {
        int current = (int) c;
        int a = (int) 'a';
        int z = (int) 'z';
        int A = (int) 'A';
        int Z = (int) 'Z';

        return (current >= a && current <= z) || (current >= A && current <= Z);
    }

    static boolean isUpperCase(char c) {
        int current = (int) c;
        int A = (int) 'A';
        int Z = (int) 'Z';
        return (current >= A && current <= Z);
    }

    static String PANAGRAM = "panagram";

    static String NOT_PANAGRAM = "not panagram";

    static String checkIsPanagram(String str) {
        Set<Character> charSet = new HashSet<>();
        str = str.toLowerCase();
        int a = (int) 'a';
        int z = (int) 'z';
        for (char c : str.toCharArray()) {
            int ascii = (int) c;
            if (ascii >= a && ascii <= z) {
                charSet.add(c);
            }
        }
        System.out.println(charSet);
        return charSet.size() == 26 ? PANAGRAM : NOT_PANAGRAM;
    }

    static boolean isLowerCase(char c) {
        int current = (int) c;
        int a = (int) 'a';
        int z = (int) 'z';
        return (current >= a && current <= z);
    }

    static char encryptChar(char c, int k) {

        int a = (int) 'a';
        int z = (int) 'z';
        int Z = (int) 'Z';
        int A = (int) 'A';

        int offset = z - a + 1;

        if (isLetter(c)) {

            if (k % offset == 0) {
                return c;
            }

            int current = (int) c;
            int shifted = current + (k % offset);

            if (isUpperCase(c) && (shifted > Z)) {
                shifted -= offset;
            }
            if (isLowerCase(c) && (shifted > z)) {
                shifted -= offset;
            }
            return (char) shifted;
        }
        return c;
    }

    static String encryptString(String s, int k) {
        String result = "";
        for (char c : s.toCharArray()) {
            result += encryptChar(c, k);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(encryptChar('l', 26));
        System.out.println(encryptString("middle-Outz", 2));
        System.out.println(encryptString("159357lcfd", 98));
        System.out.println(encryptString("!m-rB`-oN!.W`cLAcVbN/CqSoolII!SImji.!w/`Xu`uZa1TWPRq`uRBtok`xPT`lL-zPTc.BSRIhu..-!.!tcl!-U", 62));
        //!w-bL`-yX!.G`mVKmFlX/MaCyyvSS!CSwts.!g/`He`eJk1DGZBa`eBLdyu`hZD`vV-jZDm.LCBSre..-!.!dmv!-E

        String input1 = "We promptly judged antique ivory buckles for the next prize";
        System.out.println(checkIsPanagram(input1));
        System.out.println("mapAsciiToInt: " + mapAsciiToInt('Z'));
        System.out.println("countWeifht(hack): " + countWeight("hack"));
        System.out.println("uniquecharCount(abccddde): " + uniqueCharCount("abccddde"));
    }


    static int mapAsciiToInt(char c) {
        int offset = (int) 'a' - 1;
        int current = (int) c;
        return (char) (current - offset);
    }

    static int countWeight(String s) {
        int result = 0;
        for (char c : s.toCharArray()) {
            result += mapAsciiToInt(c);
        }
        return result;
    }

    static Map<Character, Integer> buildCharTable(String s) {
        Map<Character, Integer> charTable = new HashMap<>();
        for (char c : s.toCharArray()) {
            charTable.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        return charTable;
    }

    static Set<Integer> uniqueCharCount(String s) {

        Set<Integer> universe = new HashSet<>();
        String uniqueCharSeq = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            uniqueCharSeq += chars[i];
            universe.add(countWeight(uniqueCharSeq));
            if (i + 1 == s.length() || chars[i] != chars[i + 1]) {
                System.out.println("countingWeight: " + uniqueCharSeq);
                universe.add(countWeight(uniqueCharSeq));
                uniqueCharSeq = "";
            }
        }
        return universe;
    }
}
