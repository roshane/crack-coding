package com.aeon;

/**
 * Created by roshane on 7/9/2017.
 */
public class PermutationOfPalindrome {

    public static void main(String[] args) {
//        String input = "Tact Coa";
//        String input = "12 12";
        String input = "12#1#x2";
        System.out.printf("permutationOfPalindrome(%s): %b", input,
                permutationOfPalindrome(input));
    }
// |str|=m => 3m => O(m)
    private static boolean permutationOfPalindrome(String str) {
        boolean isPermutation = true;
        char space = ' ';
        int uniqueCharCount = 0;
        str=str.toLowerCase();
        int spaceCount=0;

        int[] charCount = new int[128];

        for (int i = 0; i < str.length(); i++) { // |str|
            if(str.charAt(i)!=space) {
                charCount[str.charAt(i)] += 1;
            }else{
                spaceCount+=1;
            }
        }

        if ((str.length()-spaceCount) % 2 == 0) {
            //each char count %2 == 0
            for (int i = 0; i < str.length(); i++) { // |str|
                if (charCount[str.charAt(i)] % 2 != 0) {
                    isPermutation = false;
                    break;
                }
            }
        } else {
            //each char count %2 == 0 except only one char
            for (int i = 0; i < str.length(); i++) { // |str|
                if (charCount[str.charAt(i)] % 2 != 0) {
                    uniqueCharCount += 1;
                }
            }
            isPermutation = (uniqueCharCount == 1);
        }

        return isPermutation;
    }
}
