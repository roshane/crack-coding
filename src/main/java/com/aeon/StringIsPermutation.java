package com.aeon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roshane on 7/9/2017.
 */
public class StringIsPermutation {

    public static void main(String[] args) {
        Map<String,String> testData=new HashMap<>();
        testData.put("abcd","cdab");
        testData.put("abcc","cbac");
        testData.put("abce","abcd");
        testData.put("1255","1552");

        testData.entrySet()
                .forEach(e->{
                    System.out.printf("isPermutation(%s,%s): %b\n",
                            e.getKey(),
                            e.getValue(),
                            isPermutation(e.getKey(),e.getValue()));
                });
    }

    private static boolean isPermutation(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }

        int[] charCount = new int[128];

        for (int i = 0; i < a.length(); i++) {
            charCount[(int) a.charAt(i)] = charCount[(int) a.charAt(i)] + 1;
        }

        for (int i = 0; i < b.length(); i++) {
            int updatedValue = charCount[(int) b.charAt(i)] - 1;
            if (updatedValue < 0) {
                return false;
            }
            charCount[(int) b.charAt(i)] = updatedValue;
        }
        return true;
//
//        boolean isPermutation = true;
//
//        for (int i = 0; i < charCount.length; i++) {
//            if (charCount[i] != 0) {
//                isPermutation = false;
//                break;
//            }
//        }
//        return isPermutation;
    }
}
