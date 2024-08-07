package com.example.stackandqueue;

public class _01StackUsingArray {
    private int[] arr;
    private int top;

    public _01StackUsingArray() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        // Your Code
        if(top<999)
        {
            top++;
            arr[top]=x;
        }
    }

    public int pop() {

        if(top==-1)
            return -1;

        return arr[top--];
    }
}
