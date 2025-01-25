package br.com.rhribeiro25;

/**
 * Optimizing Nested Loops: Refactor a program with multiple loops to improve performance.
 *
 * Problem Description:
 * The goal of this problem is to improve the performance of a program that uses multiple nested loops.
 * Nested loops can lead to performance issues when the input size grows, as their time complexity grows exponentially.
 * A common approach to optimizing nested loops is to eliminate unnecessary computations, reduce the number of iterations,
 * or switch to a more efficient algorithm.
 *
 * In this example, we will compare a naive implementation with nested loops (O(n^2)) and then refactor it
 * to achieve better performance with an optimized solution (O(n)).
 *
 * Example:
 * - Problem: We are given an array of integers, and we want to find all pairs that sum up to a target value.
 *
 * Approach:
 * 1. **Naive Approach (O(n^2))**: Use two nested loops to check all pairs in the array.
 * 2. **Optimized Approach (O(n))**: Use a hash set to store the complements of the numbers and check for the target sum.
 */

import java.util.HashSet;
import java.util.Set;

public class OptimizingNestedLoops {

    // Naive Approach (O(n^2)) - Uses nested loops to find all pairs
    public static void findPairsNaive(int[] arr, int target) {
        System.out.println("Naive Approach (O(n^2)):");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("Pair found: (" + arr[i] + ", " + arr[j] + ")");
                }
            }
        }
    }

    // Optimized Approach (O(n)) - Uses a hash set to find pairs efficiently
    public static void findPairsOptimized(int[] arr, int target) {
        System.out.println("Optimized Approach (O(n)):");
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
            }
            seen.add(num);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 5, 7, 8, 9};
        int target = 10;

        // Measure time for Naive Approach (O(n^2))
        long startTime = System.nanoTime();
        findPairsNaive(arr, target);
        long endTime = System.nanoTime();
        System.out.println("Naive Approach Execution Time: " + (endTime - startTime) + " nanoseconds");

        // Measure time for Optimized Approach (O(n))
        startTime = System.nanoTime();
        findPairsOptimized(arr, target);
        endTime = System.nanoTime();
        System.out.println("Optimized Approach Execution Time: " + (endTime - startTime) + " nanoseconds");
    }
}

/**
 * Explanation of the program:
 *
 * 1. **Naive Approach (O(n^2))**:
 *    - In the naive approach, the method `findPairsNaive` uses two nested loops to check all pairs of elements in the array.
 *    - For each element `i`, it iterates through the remaining elements `j` and checks if the sum of `arr[i] + arr[j]` is equal to the target value.
 *    - This results in a time complexity of O(n^2) due to the two nested loops.
 *
 * 2. **Optimized Approach (O(n))**:
 *    - In the optimized approach, the method `findPairsOptimized` uses a hash set to track the elements that have been seen so far.
 *    - For each element `num` in the array, it calculates the complement (`target - num`) and checks if the complement is already in the set.
 *    - If the complement is found, it means there is a pair that sums up to the target, and the pair is printed.
 *    - This approach runs in O(n) time complexity because we only loop through the array once and use a hash set for constant-time lookups.
 *
 * 3. **Performance Comparison**:
 *    - The naive approach requires O(n^2) time because of the nested loops, which can be inefficient for large input sizes.
 *    - The optimized approach reduces the time complexity to O(n) by using a hash set, which significantly improves performance.
 *
 * 4. **Real-World Applications**:
 *    - The naive approach is simple but inefficient for large datasets, and its time complexity grows quadratically as the input size increases.
 *    - The optimized approach is much more efficient, especially for large datasets, as it reduces the problem to a single pass through the array with constant-time set lookups.
 *
 * 5. **Big O Notation**:
 *    - **O(n^2)**: The time complexity of the naive approach due to two nested loops.
 *    - **O(n)**: The time complexity of the optimized approach that uses a hash set for constant-time lookups.
 *
 * 6. **Performance Measurement**:
 *    - The program uses `System.nanoTime()` to measure the execution time of both approaches.
 *    - By comparing the execution times, you can observe how much faster the optimized solution is compared to the naive one.
 *
 * Conclusion:
 * Optimizing nested loops often involves reducing unnecessary computations or utilizing more efficient data structures, like hash sets, to improve the time complexity from O(n^2) to O(n).
 * This is a common technique in optimizing algorithms for better scalability and performance.
 */
