package br.com.rhribeiro25;

/**
 * Solves the 0/1 Knapsack Problem using Dynamic Programming (Bottom-Up Approach).
 */
public class KnapsackDP {
    /**
     * Finds the maximum value that can be obtained with a given weight capacity.
     *
     * @param weights array of item weights
     * @param values array of item values
     * @param capacity maximum weight capacity of the knapsack
     * @return the maximum value
     */
    public int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // Build DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        KnapsackDP knapsack = new KnapsackDP();
        int[] weights = {1, 2, 3, 4};
        int[] values = {10, 20, 30, 40};
        int capacity = 5;

        System.out.println("Maximum value in the knapsack: " + knapsack.knapsack(weights, values, capacity));
    }
}

/*
 * Problem: Solving the 0/1 Knapsack Problem using Dynamic Programming (Bottom-Up Approach)
 *
 * **Objective**:
 * The goal of this problem is to solve the classic **0/1 Knapsack Problem** using **Dynamic Programming**.
 * The 0/1 Knapsack Problem is a combinatorial optimization problem where we are given a set of items,
 * each with a weight and a value. The task is to determine the most valuable combination of items that
 * can fit into a knapsack of limited capacity.
 *
 * **Problem Definition**:
 * We are given:
 * - `n`: the number of items.
 * - `W`: the capacity of the knapsack.
 * - A list of `n` items, where each item has:
 *   - `weight[i]`: the weight of item `i`.
 *   - `value[i]`: the value of item `i`.
 *
 * The goal is to maximize the total value of the items that can be placed in the knapsack without exceeding its capacity.

 * **Dynamic Programming Approach (Bottom-Up)**:
 * In the bottom-up approach, we build up the solution by solving smaller subproblems first. We use a 2D table (dp array)
 * where `dp[i][w]` represents the maximum value that can be achieved with the first `i` items and a knapsack capacity `w`.
 *
 * The solution is built iteratively, using the following recurrence relation:
 * - If the weight of the current item is less than or equal to the current capacity `w`, we can either:
 *   1. Include the item in the knapsack, and add its value to the best solution for the remaining capacity.
 *   2. Exclude the item and keep the solution from the previous item.
 * - If the weight of the current item exceeds the capacity `w`, we cannot include it, so the solution is the same as the previous item.
 *
 * **Base Case**:
 * - For a knapsack capacity of 0 (w=0) or with no items (i=0), the maximum value is 0.
 *
 * **Steps**:
 * 1. Create a 2D DP array `dp[n+1][W+1]` to store the maximum value for each combination of items and capacities.
 * 2. Iterate over all items and capacities, filling the DP table using the recurrence relation.
 * 3. The solution will be in `dp[n][W]`, which represents the maximum value that can be obtained with `n` items and knapsack capacity `W`.
 *
 * **Time Complexity**:
 * - The time complexity is **O(n * W)**, where `n` is the number of items and `W` is the capacity of the knapsack.
 *   This is because we fill up the DP table of size `(n+1) x (W+1)` in a nested loop.
 *
 * **Space Complexity**:
 * - The space complexity is **O(n * W)** due to the 2D DP array used for storing subproblem solutions.
 *
 * **Example**:
 * Given the following items and knapsack capacity:
 * Items:
 *   - Item 1: weight = 2, value = 3
 *   - Item 2: weight = 3, value = 4
 *   - Item 3: weight = 4, value = 5
 * Knapsack capacity = 5
 *
 * The optimal solution is to take items 1 and 2, resulting in a maximum value of 7.
 */
