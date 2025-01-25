package br.com.rhribeiro25;

public class LongestCommonSubsequence {
    /**
     * Finds the length of the longest common subsequence (LCS) between two strings using dynamic programming.
     * @param text1 The first string.
     * @param text2 The second string.
     * @return The length of the LCS.
     */
    public static int lcs(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        String text1 = "ABCBDAB";
        String text2 = "BDCAB";

        System.out.println("Length of Longest Common Subsequence: " + lcs(text1, text2));
    }
}

/*
 * Problem: Solving the Longest Common Subsequence (LCS) Problem using Dynamic Programming
 *
 * **Objective**:
 * The goal of this problem is to find the **Longest Common Subsequence (LCS)** between two given strings.
 * The LCS problem is a classical problem in computer science, particularly in fields such as bioinformatics,
 * text comparison, and version control systems.
 *
 * **Problem Definition**:
 * Given two strings, `X` and `Y`, the task is to find the length of the longest subsequence that appears
 * in both strings, in the same order but not necessarily consecutively.
 *
 * **Subsequence**:
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements
 * without changing the order of the remaining elements.
 *
 * **Dynamic Programming Approach**:
 * The key to solving the LCS problem efficiently is to use **Dynamic Programming (DP)**.
 * We create a 2D DP table `dp[i][j]` where `dp[i][j]` represents the length of the LCS of the first `i` characters of string `X`
 * and the first `j` characters of string `Y`.
 *
 * The recurrence relation to fill the DP table is as follows:
 * - If `X[i-1] == Y[j-1]`, then `dp[i][j] = dp[i-1][j-1] + 1` (i.e., the LCS includes this character).
 * - Otherwise, `dp[i][j] = max(dp[i-1][j], dp[i][j-1])` (i.e., we take the maximum of excluding the current character from either string).
 *
 * **Base Case**:
 * - When either string is empty (i.e., `i = 0` or `j = 0`), the LCS is 0 because an empty string has no common subsequence with any string.
 *
 * **Steps**:
 * 1. Create a 2D DP table `dp[m+1][n+1]` to store the LCS length for every subproblem.
 * 2. Iterate over both strings, filling the DP table based on the recurrence relation.
 * 3. The solution will be in `dp[m][n]`, which represents the length of the LCS for the full strings `X` and `Y`.
 *
 * **Time Complexity**:
 * - The time complexity is **O(m * n)**, where `m` and `n` are the lengths of the two strings.
 *   This is because we need to fill a 2D table of size `(m+1) x (n+1)` using a nested loop.
 *
 * **Space Complexity**:
 * - The space complexity is **O(m * n)** due to the 2D DP array used to store subproblem solutions.
 *
 * **Example**:
 * Given the following strings:
 * X = "ABCBDAB"
 * Y = "BDCABB"
 *
 * The LCS is "BCAB" with a length of 4.
 */
