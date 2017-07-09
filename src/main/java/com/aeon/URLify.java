package com.aeon;

/**
 * Created by roshane on 7/9/2017.
 */
public class URLify {

    public static void main(String[] args) {
        String input = "Mr John Smith";
        System.out.printf("urlify(%s): %s", input,
                urlify(input.toCharArray(), input.length()));
    }

    private static String urlify(char[] input, int actualSize) {

        int spaceCount = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == ' ') {
                spaceCount += 1;
            }
        }

        int newSize = actualSize + spaceCount * 2;
        char[] result = new char[newSize];
        int index = 0;
        int i = 0;
        while (index < newSize) {
            if (input[i] == ' ') {
                result[index] = '%';
                result[index + 1] = '2';
                result[index + 2] = '0';
                index += 3;
            } else {
                result[index] = input[i];
                index += 1;
            }
            i += 1;
        }
        return new String(result);
    }
}
