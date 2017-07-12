package com.scratch;

import java.util.stream.IntStream;

class Node<T> {
    T item;
    Node next;

    Node(T t) {
        this.item = t;
    }

    @Override
    public String toString() {
        return "Node{ item: " + this.item + "}";
    }
}

class LinkedList<T> {
    Node<T> head;
    Node<T> current;
    int count;

    LinkedList() {
        head=new Node<T>(null);
        current=head;
    }

    void add(T item) {
        Node<T> tNode = new Node<>(item);
        System.out.println("adding: "+item);
        if (current == null) {
            current = tNode;
        } else {
            current.next = tNode;
            current = tNode;
        }
        count += 1;
    }

    public String toString() {

        String s = "";
        Node<T> temp = head.next;

        while (temp != null) {
            s += temp.toString() + "-";
            temp = temp.next;
        }
        return s;
    }


}

class Test {

    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>();
        IntStream.range(1,10)
                .forEach(list::add);
        System.out.println(list);
    }

}
