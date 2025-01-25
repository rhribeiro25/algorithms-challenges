package br.com.rhribeiro25;

import java.util.PriorityQueue;

/**
 * Demonstrates the usage of a priority queue (Min-Heap) in Java.
 */
public class Heap {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Adding elements to the heap
        minHeap.add(15);
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(5);

        System.out.println("Min-Heap elements in ascending order:");
        // Extract elements in sorted order
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
    }
}

/*
 * Problem: Demonstrating the Usage of a Priority Queue (Min-Heap) in Java
 *
 * **Objective**:
 * The goal of this problem is to demonstrate the usage of a **Priority Queue (Min-Heap)** in Java.
 * A priority queue is a data structure that operates similarly to a regular queue,
 * but with the added feature that each element has a priority associated with it.
 * In a min-heap priority queue, the element with the lowest priority (i.e., the smallest element)
 * is always at the front of the queue, ready to be processed.
 *
 * **Min-Heap**:
 * - A **Min-Heap** is a complete binary tree where the value of each node is less than or equal to the values of its children.
 * - In a **Min-Heap**-based priority queue, the element with the smallest value (or priority) is always removed first.
 * - The priority queue in Java is implemented using a heap, and we can use it to solve various problems,
 *   such as finding the kth smallest/largest element, sorting, or scheduling tasks based on priority.
 *
 * **PriorityQueue in Java**:
 * Java provides the `PriorityQueue` class, which implements a min-heap by default.
 * It is part of the `java.util` package and allows efficient insertion and removal of elements based on their natural ordering or a provided comparator.
 *
 * **Methods**:
 * - `add()`: Adds an element to the priority queue.
 * - `peek()`: Retrieves the first element in the priority queue (the element with the smallest priority) without removing it.
 * - `poll()`: Retrieves and removes the first element in the priority queue.
 * - `isEmpty()`: Checks if the priority queue is empty.
 *
 * **Time Complexity**:
 * - The time complexity for insertion (`add()`) and removal (`poll()`) is **O(log n)**,
 *   where `n` is the number of elements in the priority queue.
 *   This is because the heap property must be maintained after each insertion or removal.
 *
 * **Space Complexity**:
 * - The space complexity is **O(n)**, where `n` is the number of elements in the priority queue.
 *
 * **Example Use Cases**:
 * - Task scheduling: Processing tasks in order of their priority.
 * - Finding the k smallest or largest elements in a collection.
 * - Efficiently implementing algorithms like Dijkstra's shortest path algorithm.
 */
