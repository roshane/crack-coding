package com.aeon.prob;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by roshane on 7/13/17.
 */
public class BalanceParenthesis {

    public static void main(String[] args) {

        Arrays.asList("()",
                "",
                "[][{()}]",
                "}[",
                "()[00]{abc}()",
                "[[{}")
                .forEach(s -> {
                    System.out.printf("isBanalceParan %s: %b\n", s, isBalancedParanehesis(s));
                });

    }

    private static String closeParan = "]})";
    private static String openParan = "[{(";
    private static String paranPair = "(){}[]";

    private static boolean isBalancedParanehesis(String txt) {
        if (txt.length() < 2)
            return false;

        Stack<Character> stack = new Stack<>();

        for (char c : txt.toCharArray()) {
            if (isOpenParan(c)) {
                stack.push(c);
            } else if (isCloseParan(c) && stack.isEmpty()) {
                return false;
            } else if (isCloseParan(c) && !stack.isEmpty()) {
                String pair = stack.pop() + "" + c;
                if (!isMatching(pair)) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    private static boolean isOpenParan(char c) {
        return openParan.indexOf(c) > -1;
    }

    private static boolean isCloseParan(char c) {
        return closeParan.indexOf(c) > -1;
    }

    private static boolean isMatching(String pair) {
        return paranPair.contains(pair);
    }
}
