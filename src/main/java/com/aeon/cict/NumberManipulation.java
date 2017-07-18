package com.aeon.cict;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Created by roshane on 7/17/17.
 */
public class NumberManipulation {

    public static void main(String[] args) {
        String result = convertToBase(127, 9);
        System.out.println("result: " + result);
        String str = "abcaeeffabcdefabedabc";
        String sub = "abc";
        System.out.printf("countOccurrencesOf(%s, %s): %d\n", str, sub, countOccurrencesOf(str, sub));
        System.out.println(5 & 4);
        IntStream.range(1,20)
                .forEach(i->{
                    System.out.printf("(%d & (%d -1)) == 0: %b\n",i,i,(i & (i-1))==0);
                });

    }

    private static Map<Integer, String> intToStringMap = new HashMap<>();

    static {
        intToStringMap.put(0, "0");
        intToStringMap.put(1, "1");
        intToStringMap.put(2, "2");
        intToStringMap.put(3, "3");
        intToStringMap.put(4, "4");
        intToStringMap.put(5, "5");
        intToStringMap.put(6, "6");
        intToStringMap.put(7, "7");
        intToStringMap.put(8, "8");
        intToStringMap.put(9, "9");
        intToStringMap.put(10, "A");
        intToStringMap.put(11, "B");
        intToStringMap.put(12, "C");
        intToStringMap.put(13, "D");
        intToStringMap.put(14, "E");
        intToStringMap.put(15, "F");
    }

    static int countOccurrencesOf(String str, String sub) {
        if (str.length() < 1 || sub.length() < 1) {
            return 0;
        }
        int count = 0;
        int pos = 0;
        int idx;
        while ((idx = str.indexOf(sub, pos)) != -1) {
            pos = sub.length() + idx;
            count += 1;
        }
        return count;
    }

    static String convertToBase(int number, int radix) {

        if (radix > 10 && radix != 16) {
            throw new RuntimeException("unsupported radix ");
        }

        if (radix == 10) {
            return Integer.toString(number);
        }

        Stack<String> stack = new Stack<>();
        int remainder = number;
        while (remainder != 0) {
            stack.push(intToStringMap.get(remainder % radix));
            remainder /= radix;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }
}
