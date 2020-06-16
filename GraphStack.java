package com.company;

public class GraphStack {
    private  int[] array;
    private  int size = 10;
    private  int current;

    public GraphStack() {
        array = new int[size];
        current = -1;
    }

   public void push(int index) {
        array[++current] = index;
    }

    public int pop() {
        return array[current--];
    }

    public int peek() {
        return array[current];
    }

    public boolean isEmpty() {
        if (current == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void update(){
        current = -1;
    }
}