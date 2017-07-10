package com.aeon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roshane on 7/11/17.
 */
public class StringCompression {

    public static void main(String[] args) {
        String str = "aabcccccaaa";
        compressString(str);
        System.out.println("result: "+compressString2(str));
    }

    private static String compressString(String str) {
        int count = 0;
        int index = 0;
        Map<Integer, String> charMap = new HashMap<>();
        while (count < str.length()) {
            char current = str.charAt(count);
            int uniqueCharCount = 0;
            while ((count + uniqueCharCount) < str.length()
                    && current == str.charAt(count + uniqueCharCount)) {
                uniqueCharCount += 1;
            }
            charMap.put(index, (current + "" + uniqueCharCount));
            count += uniqueCharCount;
            index += 1;
        }
        System.out.println(charMap);
        if (charMap.size() * 2 < str.length()) {
            String s = "";

        }
        return str;
    }

    static String compressString2(String str) {
        int uniqueCharCount = 0;
        String compressed = "";
        for (int i = 0; i < str.length(); i++) {
            uniqueCharCount += 1;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed += str.charAt(i) + "" + uniqueCharCount;
                uniqueCharCount = 0;
            }
        }

        System.out.println("compressed: " + compressed);

        return compressed.length() < str.length() ? compressed : str;
    }
}
