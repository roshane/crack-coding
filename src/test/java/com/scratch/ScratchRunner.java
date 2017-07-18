package com.scratch;

import javax.management.openmbean.InvalidOpenTypeException;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by roshane on 7/13/17.
 */
public class ScratchRunner {

    static class Node<T> {
        T data;
        Node<T> next;

        T getData() {
            return this.data;
        }

        Node<T> next() {
            return this.next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    static class LinkedList<T> {
        Node<T> head;
        Node<T> current;

        void add(T data) {
            if (head == null) {
                head = new Node<>();
                head.data = data;
                current = head;
            } else {
                Node<T> t = new Node<>();
                t.data = data;
                current.next = t;
                current = t;
            }
        }

        void reverse() {
            if (head == null) {
                return;
            }
            Stack<Node<T>> stack = new Stack<>();
            Node<T> temp = head;
            while (temp.next != null) {
                stack.push(temp);
                temp = temp.next();
            }
            Node<T> newHead = new Node<T>();
            newHead.data = current.data;
            Node<T> newCurrent = newHead;
            while (!stack.isEmpty()) {
                Node<T> t = new Node<>();
                t.data = stack.pop().data;
                newCurrent.next = t;
                newCurrent = newCurrent.next;
            }
            head = newHead;
            current = newCurrent;
        }

        @Override
        public String toString() {
            String result = "";
            Node<T> temp = head;
            while (temp != null) {
                result += temp.toString() + " ";
                temp = temp.next;
            }
            return result;
        }
    }


    static int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 9999999, 999999999, Integer.MAX_VALUE};

    static int[] numbers = {2, 4, 9, 10, 23, 35, 49, 51, 60};

    static String operators = "+-*/";

    static boolean isOperator(String c) {
        return operators.contains(c);
    }

    static int evaluatePostfix(String expression) {
        Stack<Integer> operands = new Stack<>();
        for (String c : expression.split(" ")) {
            if (isOperator(c) && !operands.isEmpty()) {
                int b = operands.pop();
                int a = operands.pop();
                int result = evaluate(a, b, c.charAt(0));
                operands.push(result);
            } else {
                operands.push(Integer.parseInt(c));
            }
        }
        return operands.pop();
    }

    static int evaluate(int a, int b, char c) {
        int result = 0;
        switch (c) {
            case '+': {
                result = a + b;
                break;
            }
            case '-': {
                result = a - b;
                break;
            }
            case '*': {
                result = a * b;
                break;
            }
            case '/': {
                result = a / b;
                break;
            }
            default: {
                System.out.println("invalid operand " + c);
            }
        }
        return result;
    }

    public static void main(String[] args) {

//        Arrays.asList(2, 4, 9, 10, 23, 35, 49, 51, 60)
//                .forEach(i -> {
//                    System.out.printf("binarySearch(%d): %d\n", i, binarySearch(numbers, i));
//                });

//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        System.out.println("my list: " + list);
//        list.reverse();
//        System.out.println("reverse list: " + list);
        Arrays.asList("5 5 /","5 5 +","25 5 / 4 2 / +")
                .forEach(s->{
                    System.out.printf("evaluatePostfix(%s): %d\n",s,evaluatePostfix(s));
                });
    }

    static int binarySearch(int[] input, int n) {
        return search(input, 0, input.length - 1, n);
    }

    static int search(int[] numbers, int low, int upper, int n) {
        int mid = (upper - low) / 2 + 1;
        if (numbers[mid] == n) {
            return mid;
        }

        if (numbers[mid] > n) {
            upper = upper - mid;
        } else {
            low = low + mid;
        }
        return search(numbers, low, upper, n);
    }

    static int getStringSize(int x) {
        for (int i = 0; ; i++) {
            if (sizeTable[i] >= x)
                return i + 1;
        }
    }
}
