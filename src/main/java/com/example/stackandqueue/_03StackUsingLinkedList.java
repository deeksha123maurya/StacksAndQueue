package com.example.stackandqueue;

public class _03StackUsingLinkedList {
    private class stackNode {
        int data;
        stackNode next;
        stackNode(int d) {
            data = d;
            next = null;
        }
    }
    stackNode top;
    int size;
    _03StackUsingLinkedList() {
        this.top = null;
        this.size = 0;
    }
    public void stackPush(int x) {
        stackNode element = new stackNode(x);
        element.next = top;
        top = element;
        System.out.println("Element pushed");
        size++;
    }
    public int stackPop() {
        if (top == null) return -1;
        int topData = top.data;
        stackNode temp = top;
        top = top.next;
        return topData;
    }
    public int stackSize() {
        return size;
    }
    public boolean stackIsEmpty() {
        return top == null;
    }
    public void printStack() {
        stackNode current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

