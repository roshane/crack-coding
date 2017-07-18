package com.aeon.cict;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by roshane on 7/16/17.
 */
public class StackImpl {

    static class Stack {
        int top = -1;
        int size = 0;
        int[] container;

        Stack(int s) {
            container = new int[s];
        }

        void push(int data) {
            if (container.length == size) {
                throw new RuntimeException("stack overflow");
            }
            container[size++] = data;
            top++;
        }

        int pop() {
            if (size == 0) {
                throw new RuntimeException("stack empty");
            }
            size--;
            return container[top--];
        }

        int peek() {
            if (size == 0) {
                throw new RuntimeException("stack empty");
            }
            return container[top];
        }

        boolean empty() {
            return size == 0;
        }

        public String toString() {
            String result = "";
            for (int i = 0; i < size; i++) {
                result += container[i] + "->";
            }
            result += "TOP";
            return result;
        }
    }

    public static void main(String[] args) {
        int upperBound = 10;
        Stack stack = new Stack(upperBound);
        final Random random = new Random(System.currentTimeMillis());
        IntStream.range(0, upperBound)
                .forEach(i -> stack.push(random.nextInt(20)));
        System.out.println(stack);
        sortStack(stack);
//        System.out.println("### Sorted ###");
//        System.out.println(stack);

        System.out.println(integerValueOf("88", 10));
        System.out.println(Integer.valueOf("1101", 2));
        System.out.println(Integer.valueOf("1110", 2));
    }

    private static Map<Character, Integer> charIntMap;

    static {
        charIntMap = new HashMap<>();
        charIntMap.put('0', 0);
        charIntMap.put('1', 1);
        charIntMap.put('2', 2);
        charIntMap.put('3', 3);
        charIntMap.put('4', 4);
        charIntMap.put('5', 5);
        charIntMap.put('6', 6);
        charIntMap.put('7', 7);
        charIntMap.put('8', 8);
        charIntMap.put('9', 9);
        charIntMap.put('A', 10);
        charIntMap.put('B', 11);
        charIntMap.put('C', 12);
        charIntMap.put('D', 13);
        charIntMap.put('E', 14);
        charIntMap.put('F', 15);
    }

    static int integerValueOf(String str, int base) {
        if (base > 10 && base != 16) {
            throw new RuntimeException("unsupported base");
        }
        int value = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char current = str.charAt(i);
            int n = charIntMap.get(current);
            if (base <= n) {
                throw new RuntimeException("number format wrong");
            }
            value += (int) (n * Math.pow(base, (str.length() - 1 - i)));
        }
        return value;
    }

    static void sortStack(Stack stack) {
        if (stack.size < 2) {
            return;
        }
        Stack temp = new Stack(stack.size);
        while (!stack.empty()) {
            int current = stack.pop();
            while (!temp.empty() && current < temp.peek()) {
                stack.push(temp.pop());
            }
            temp.push(current);
        }
        System.out.println(temp);
    }
}
