package br.com.rhribeiro25;

import java.util.Stack;

public class MaxStacking {

    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    public MaxStacking() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (maxStack.isEmpty() || val >= maxStack.peek()) {
            maxStack.push(val);
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        int val = stack.pop();
        if (val == maxStack.peek()) {
            maxStack.pop();
        }
        return val;
    }

    public int peek() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        return stack.peek();
    }

    public int getMax() {
        if (maxStack.isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        return maxStack.peek();
    }

    public static void main(String[] args) {
        MaxStacking maxStack = new MaxStacking();
        maxStack.push(5);
        maxStack.push(1);
        maxStack.push(10);
        System.out.println(maxStack.getMax());  // Output: 10
        maxStack.pop();
        System.out.println(maxStack.getMax());  // Output: 5
    }
}
