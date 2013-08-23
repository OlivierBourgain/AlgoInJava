package com.obourgain.algo.tortoiseandhare;

public class Node {
    private int value;
    private Node next;

    public Node(int value) {
        super();
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        String res = Integer.toString(value);
        return res;
    }
}
