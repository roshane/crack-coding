package com.aeon.cict;

import java.util.Arrays;

/**
 * Created by roshane on 7/16/17.
 */
public class StringCompression {

    public static void main(String[] args) {
        Arrays.asList(
                "aabcccccaaa",
                "abbcddeffgg",
                "aaa",
                "aaabbbcccddd"
        ).forEach(s->{
            System.out.printf("compressString(%s): %s",s,compressString(s));
            System.out.println();
        });

    }

    static String compressString(String str) {
        String result = "";
        int uniqueCharCount = 0;
        for (int i = 0; i < str.length(); i++) {
            uniqueCharCount += 1;
            if (i + 1 == str.length() || (str.charAt(i + 1) != str.charAt(i))) {
                result += str.charAt(i) + "" + uniqueCharCount;
                uniqueCharCount = 0;
            }
        }
        System.out.println(result);
        return result.length() < str.length() ? result : str;
    }
}
