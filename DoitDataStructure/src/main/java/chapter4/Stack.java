package chapter4;

public class Stack<E> {
    private E[] stk;
    private int capacity;
    private int pointer;

    public Stack(int capacity) {
        this.capacity = capacity;
        stk = (E[]) new Object[capacity];
        pointer = 0;
    }
}
