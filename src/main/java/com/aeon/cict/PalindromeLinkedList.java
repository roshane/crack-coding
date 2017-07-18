package com.aeon.cict;

import java.util.Stack;

/**
 * Created by roshane on 7/16/17.
 */
public class PalindromeLinkedList {

    static class Node {
        String data;
        Node next;

        Node(String s) {
            this.data = s;
        }

        public String toString() {
            return String.format("{%s}", data);
        }
    }

    static class LinkedList {
        Node head;
        Node current;
        int size = 0;

        void add(String s) {
            if (head == null) {
                head = new Node(s);
                current = head;
            } else {
                current.next = new Node(s);
                current = current.next;
            }
            size++;
        }

        String get(int i) {
            if (i < 0) {
                // return null
                return null;
            }
            Node n = head;
            int x = 0;
            while (x < i && n != null) {
                n = n.next;
                x++;
            }
            if (n != null) {
                return n.data;
            }
            return null;
        }

        void reverse() {
            if (head == null) {
                throw new RuntimeException("empty list");
            }
            Node current = head;
            Stack<Node> stack = new Stack<>();
            while (current != null) {
                stack.push(current);
                current = current.next;
            }
            Node h = new Node(stack.pop().data);
            current = h;
            while (!stack.isEmpty()) {
                current.next = new Node(stack.pop().data);
                current = current.next;
            }
            this.head = h;
        }

        public String toString() {
            String result = "";
            Node current = head;
            while (current != null) {
                result += current.toString() + " -> ";
                current = current.next;
            }
            result += "NULL";
            return result;
        }
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        System.out.println(list);
        list.reverse();
        System.out.println(list);
//        System.out.printf("isPalindrome(%s): %b\n", list.toString(), isPalindrome(list.head));
//        System.out.println(list.size);
//        System.out.printf("get(%d): %s", 2, list.get(2));
    }

    static boolean isPalindrome(Node head) {
        Stack<Node> stack = new Stack<>();
        Node current = head;

        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        current = head;
        while (current != null && !stack.isEmpty()) {
            if (current.data != stack.pop().data) {
                return false;
            }
            current = current.next;
        }

        return true;
    }

}
