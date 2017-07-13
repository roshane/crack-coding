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

	final static int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999,
			99999999, 999999999, Integer.MAX_VALUE};

	// Requires positive x
	static int stringSize(int value) {
		for (int i = 0; ; i++)
			if (value <= sizeTable[i])
				return i+1;
	}

	public static void main(String[] args) {
		System.out.println(stringSize(1));
	}

}
