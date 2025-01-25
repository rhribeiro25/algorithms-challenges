package br.com.rhribeiro25;

public class MaxSubarraySum {
    /**
     * Finds the maximum sum of a contiguous subarray using Kadane's Algorithm.
     * @param nums The input array of integers.
     * @return The maximum sum of the contiguous subarray.
     */
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Maximum Subarray Sum: " + maxSubArray(nums));
    }
}

/*
 * Problem: Maximum Subarray Sum (Kadane's Algorithm)
 *
 * Given an integer array, find the contiguous subarray (containing at least one number) which has the largest sum.
 * The solution should return the sum of this subarray.
 *
 * For example:
 * Input: [1, -2, 3, 4, -1, 2, 1, -5, 4]
 * Output: 8
 * Explanation: The contiguous subarray with the largest sum is [3, 4, -1, 2, 1], which has a sum of 8.
 *
 * Constraints:
 * - The array may contain both positive and negative integers.
 * - The solution must find the maximum sum of a subarray in linear time O(n).
 *
 * Approach (Kadane's Algorithm):
 *
 * Kadane's algorithm is an efficient dynamic programming algorithm to solve this problem in linear time. It works as follows:
 *
 * 1. Initialize two variables:
 *    - `currentSum`: Keeps track of the sum of the current subarray.
 *      - If adding a new element makes the sum negative, we reset the sum to the current element (i.e., start a new subarray).
 *    - `maxSum`: Keeps track of the maximum sum encountered so far.
 *
 * 2. Iterate through the array from left to right:
 *    - For each element, decide whether to include it in the current subarray (add it to `currentSum`) or start a new subarray starting with the current element (set `currentSum` to the current element).
 *    - Update `maxSum` to be the larger of the current `maxSum` and `currentSum`.
 *
 * 3. The final value of `maxSum` will be the maximum sum of the subarray.
 *
 * Key Points:
 * - Kadane's algorithm solves the problem in **O(n)** time complexity.
 * - The solution requires **O(1)** additional space since we are only using a constant number of variables.
 *
 * This algorithm is optimal for finding the maximum subarray sum because it only requires a single traversal of the array.
 *
 * Example Walkthrough:
 * Given the input array: [1, -2, 3, 4, -1, 2, 1, -5, 4]
 *
 * - Initialize `currentSum = 0` and `maxSum = Integer.MIN_VALUE`.
 * - For each element, update `currentSum` and `maxSum`:
 *   - For element 1: `currentSum = max(1, 0 + 1) = 1`, update `maxSum = max(Integer.MIN_VALUE, 1) = 1`.
 *   - For element -2: `currentSum = max(-2, 1 - 2) = -1`, `maxSum = 1`.
 *   - For element 3: `currentSum = max(3, -1 + 3) = 3`, update `maxSum = max(1, 3) = 3`.
 *   - For element 4: `currentSum = max(4, 3 + 4) = 7`, update `maxSum = max(3, 7) = 7`.
 *   - For element -1: `currentSum = max(-1, 7 - 1) = 6`, `maxSum = 7`.
 *   - For element 2: `currentSum = max(2, 6 + 2) = 8`, update `maxSum = max(7, 8) = 8`.
 *   - For element 1: `currentSum = max(1, 8 + 1) = 9`, update `maxSum = max(8, 9) = 9`.
 *   - For element -5: `currentSum = max(-5, 9 - 5) = 4`, `maxSum = 9`.
 *   - For element 4: `currentSum = max(4, 4 + 4) = 8`, `maxSum = 9`.
 *
 * The final `maxSum` will be **8**, which is the sum of the subarray [3, 4, -1, 2, 1].
 */
