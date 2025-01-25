package br.com.rhribeiro25;

/**
 * Big O Analysis: Analyze the complexity of a given function.
 *
 * Problem Description:
 * In computer science, Big O notation is used to describe the performance or complexity of an algorithm
 * in terms of time or space. The goal is to analyze how the runtime or memory requirements grow as the input size increases.
 *
 * In this example, we will examine the time complexity of different types of functions:
 * - O(1) (constant time): The runtime is constant and does not depend on the input size.
 * - O(n) (linear time): The runtime grows linearly with the input size.
 * - O(n^2) (quadratic time): The runtime grows quadratically with the input size.
 *
 * Approach:
 * We will implement three functions with different time complexities and analyze how the runtime changes
 * with the input size. Additionally, we will simulate a method to measure the time taken by these functions for different input sizes.
 *
 * Example:
 * - Function 1: O(1) complexity
 * - Function 2: O(n) complexity
 * - Function 3: O(n^2) complexity
 *
 * We will use `System.nanoTime()` to measure the time taken by each function and print the results.
 */

public class BigOAnalysis {

    // O(1) - Constant time complexity
    // The runtime does not depend on the size of the input.
    public static void constantTimeExample() {
        // Perform a constant-time operation (e.g., accessing an array element)
        int[] arr = {1, 2, 3, 4, 5};
        int x = arr[0];  // Access the first element, constant time
    }

    // O(n) - Linear time complexity
    // The runtime grows linearly with the size of the input.
    public static void linearTimeExample(int n) {
        // Perform a linear-time operation (e.g., looping through an array)
        for (int i = 0; i < n; i++) {
            System.out.print(i + " "); // Print each element, linear time
        }
    }

    // O(n^2) - Quadratic time complexity
    // The runtime grows quadratically with the size of the input.
    public static void quadraticTimeExample(int n) {
        // Perform a quadratic-time operation (e.g., nested loops)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("(" + i + ", " + j + ") "); // Print pairs of indices, quadratic time
            }
        }
    }

    public static void main(String[] args) {
        // Measure the time for O(1) complexity function
        long startTime = System.nanoTime();
        constantTimeExample();
        long endTime = System.nanoTime();
        System.out.println("O(1) Execution Time: " + (endTime - startTime) + " nanoseconds");

        // Measure the time for O(n) complexity function
        int n = 1000; // Test with input size of 1000
        startTime = System.nanoTime();
        linearTimeExample(n);
        endTime = System.nanoTime();
        System.out.println("\nO(n) Execution Time for n=" + n + ": " + (endTime - startTime) + " nanoseconds");

        // Measure the time for O(n^2) complexity function
        startTime = System.nanoTime();
        quadraticTimeExample(n);
        endTime = System.nanoTime();
        System.out.println("\nO(n^2) Execution Time for n=" + n + ": " + (endTime - startTime) + " nanoseconds");
    }
}

/**
 * Explanation of the program:
 * 1. **O(1) - Constant Time Complexity**:
 *    - The method `constantTimeExample` performs an operation that takes constant time.
 *    - It accesses an element from an array, which is a constant time operation (i.e., the runtime does not depend on the input size).
 *
 * 2. **O(n) - Linear Time Complexity**:
 *    - The method `linearTimeExample` takes an input size `n` and loops through it once, performing an operation for each element in the array.
 *    - This results in a linear relationship between the input size `n` and the execution time.
 *
 * 3. **O(n^2) - Quadratic Time Complexity**:
 *    - The method `quadraticTimeExample` involves nested loops, where the number of iterations grows quadratically with `n`.
 *    - For each element in the outer loop, the inner loop runs `n` times, resulting in `n^2` iterations in total.
 *
 * 4. **Performance Measurement**:
 *    - The program uses `System.nanoTime()` to measure the time taken by each of the functions.
 *    - This allows us to observe the difference in execution time for different time complexities.
 *
 * 5. **Big O Notation**:
 *    - **O(1)**: Constant time complexity indicates that the function's runtime remains the same regardless of the input size.
 *    - **O(n)**: Linear time complexity means the function's runtime grows directly in proportion to the input size.
 *    - **O(n^2)**: Quadratic time complexity indicates that the function's runtime grows quadratically with the input size.
 *
 * 6. **Real-World Applications**:
 *    - **O(1)**: Used in operations such as accessing a specific element in an array or hash map lookup.
 *    - **O(n)**: Common in functions that need to process each element in a collection, such as searching through a list.
 *    - **O(n^2)**: Found in algorithms that require nested iterations, such as bubble sort or matrix multiplication.
 *
 * Note: The performance timing will depend on the system's load and hardware. However, the important takeaway here is the relationship between the input size `n` and the runtime, which illustrates the significance of Big O notation in analyzing algorithm efficiency.
 */
