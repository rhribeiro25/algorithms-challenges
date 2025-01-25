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

/*
 * Problem: Max Stack
 *
 * **Objective**:
 * The task is to implement a data structure, called **MaxStack**, that supports the following operations:
 * - `push(x)`: Pushes the element `x` onto the stack.
 * - `pop()`: Removes and returns the top element from the stack.
 * - `top()`: Returns the top element without removing it.
 * - `getMax()`: Returns the maximum element in the stack in constant time (O(1)).
 *
 * **Problem Definition**:
 * We need to design a stack that supports all the traditional stack operations (`push`, `pop`, `top`), but
 * with the additional feature of retrieving the maximum element in the stack in constant time.
 * This means that whenever we call `getMax()`, it should return the largest element currently in the stack without
 * needing to traverse the entire stack.
 *
 * **Approach**:
 * - A basic stack only supports the `push`, `pop`, and `top` operations. However, finding the maximum element would
 *   normally require traversing the entire stack, which could be inefficient.
 * - To address this, we use an additional stack (often called `maxStack`) to keep track of the maximum values at each stage.
 *   - Whenever we push an element onto the main stack, we also push the maximum element encountered so far onto `maxStack`.
 *   - When we pop an element from the main stack, we also pop from `maxStack` to maintain synchronization.
 * - The top element of the `maxStack` will always represent the current maximum element in the main stack.
 *
 * **Space Complexity**:
 * - The space complexity of this solution is **O(n)**, where `n` is the number of elements in the stack.
 *   - We are using an extra stack (`maxStack`), which holds at most the same number of elements as the original stack.
 *
 * **Time Complexity**:
 * - The time complexity for each operation (`push`, `pop`, `top`, and `getMax`) is **O(1)**, as each of these operations
 *   only involves pushing or popping from a stack, which is done in constant time.
 *
 * **Example**:
 * Consider the following sequence of operations:
 * MaxStack stack = new MaxStack();
 * stack.push(1);
 * stack.push(2);
 * stack.push(3);
 * stack.getMax(); // returns 3
 * stack.pop();
 * stack.getMax(); // returns 2
 * stack.push(0);
 * stack.getMax(); // returns 2
 */
