package com.aeon.cict;

/**
 * Created by roshane on 7/15/17.
 */
public class UTLify {

    public static void main(String[] args) {
        String s = "Mr John Smith";
        int trueLength = 13;
        System.out.println(utlify(s,trueLength));
    }

    static String utlify(String str, int len) {

        int spaceCount = 0;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                spaceCount += 1;
            }
        }
        char[] result = new char[len + spaceCount * 2];
        int position = result.length - 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                result[position] = '0';
                result[--position] = '2';
                result[--position] = '%';
            }else {
                result[position] = chars[i];
            }
            position--;
        }
        printArray(result);
        return new String(result);
    }

    static void printArray(char[] a){
        for(char c:a){
            System.out.print(c+", ");
        }
        System.out.println();
    }
}
