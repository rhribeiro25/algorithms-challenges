package br.com.rhribeiro25;

import java.util.HashMap;

/**
 * Computes Fibonacci numbers using Dynamic Programming (Top-Down Approach with Memoization).
 */
public class FibonacciDP {
    private HashMap<Integer, Long> memo = new HashMap<>();

    /**
     * Calculates the Fibonacci number at a given position.
     * Uses memoization to avoid redundant calculations.
     *
     * @param n the position in the Fibonacci sequence
     * @return the Fibonacci number at position n
     */
    public long fibonacci(int n) {
        if (n <= 1) return n;

        // Check memo table
        if (memo.containsKey(n)) return memo.get(n);

        // Compute and store in memo table
        long result = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        FibonacciDP fibDP = new FibonacciDP();
        int n = 50;
        System.out.println("Fibonacci number at position " + n + ": " + fibDP.fibonacci(n));
    }
}

/*
 * Problem: Fibonacci with Dynamic Programming (FibonacciDP)
 *
 * The Fibonacci sequence is a series of numbers where each number is the sum of the two preceding ones, starting from 0 and 1.
 * The sequence goes like this: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, and so on.
 *
 * **Objective**:
 * Given an integer `n`, return the `n`-th number in the Fibonacci sequence.
 *
 * **Fibonacci Formula**:
 * - F(0) = 0
 * - F(1) = 1
 * - F(n) = F(n-1) + F(n-2) for n > 1
 *
 * **Constraints**:
 * - The value of `n` is a non-negative integer, typically 0 <= n <= 1000.
 * - The Fibonacci sequence grows exponentially, and we want to compute the result efficiently.
 *
 * **Dynamic Programming Approach**:
 * The naive recursive approach to solve Fibonacci has an exponential time complexity due to repetitive calculations, resulting in redundant computations.
 * To optimize this, we use dynamic programming, which stores intermediate results to avoid redundant calculations.
 *
 * **Steps**:
 * 1. Use an array to store the Fibonacci numbers that we have already computed.
 * 2. Start with the base cases: F(0) = 0 and F(1) = 1.
 * 3. Iterate from 2 to `n`, computing F(n) by summing F(n-1) and F(n-2), and storing the result in the array.
 * 4. The final result will be the value stored at the `n`-th index in the array.
 *
 * **Time Complexity**:
 * - O(n), because we compute each Fibonacci number only once.
 *
 * **Space Complexity**:
 * - O(n), as we store the Fibonacci numbers in an array. We can reduce this to O(1) by storing only the last two computed values.
 *
 * **Example**:
 * Input: n = 6
 * Output: 8
 * Explanation: The Fibonacci sequence is 0, 1, 1, 2, 3, 5, 8. The 6th Fibonacci number is 8.
 *
 * **Optimizations**:
 * This dynamic programming solution can be further optimized by only keeping track of the last two Fibonacci numbers, reducing the space complexity.
 */
