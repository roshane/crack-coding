package com.aeon.hrank;

/**
 * Created by roshane on 7/15/17.
 */
public class FindMissingNumberInSecondArray {

    public static void main(String[] args) {
        int[] a = {9, 7, 8, 5, 4, 6, 2, 3, 1};
        int[] b = {2, 3, 4, 9, 1, 8, 5, 6};
        System.out.println("Missing Int: "+findMissingDuplicate(a,b));
    }

    static int findMissingDuplicate(int[] a, int[] b) {
        if (Math.abs(a.length - b.length) != 1) {
            return Integer.MAX_VALUE;//throw new RuntimeException("Invalid arguments");
        }
        int maxLen = Math.max(a.length, b.length);
        int lonelyInt = 0;
        for (int i = 0; i < maxLen; i++) {
            if (i < a.length) {
                lonelyInt ^= a[i];
            }
            if (i < b.length) {
                lonelyInt ^= b[i];
            }
        }
        return lonelyInt;
    }
}
