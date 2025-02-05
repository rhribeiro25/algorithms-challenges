package br.com.rhribeiro25;

import java.util.HashMap;
import java.util.Map;

public class EquiLeader {
    public int solution(int[] A) {
        int n = A.length;
        if (n == 1) return 0;

        // Step 1: Find the leader of the entire array
        Map<Integer, Integer> countMap = new HashMap<>();
        int leader = -1, leaderCount = 0;

        for (int num : A) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) > n / 2) {
                leader = num;
                leaderCount = countMap.get(num);
            }
        }

        if (leaderCount <= n / 2) return 0; // No leader exists

        // Step 2: Count equi leaders
        int equiLeaders = 0;
        int leftCount = 0;
        int rightCount = leaderCount;

        for (int i = 0; i < n; i++) {
            if (A[i] == leader) {
                leftCount++;
                rightCount--;
            }

            int leftSize = i + 1;
            int rightSize = n - leftSize;

            if (leftCount > leftSize / 2 && rightCount > rightSize / 2) {
                equiLeaders++;
            }
        }

        return equiLeaders;
    }

    public static void main(String[] args) {
        EquiLeader sol = new EquiLeader();

        int[][] testCases = {
                {4, 3, 4, 4, 4, 2},  // Expected: 2
                {4, 4, 2, 5, 3, 4, 4, 4},  // Expected: 3
                {1, 2, 3, 4, 5},  // Expected: 0 (No leader)
                {1, 1, 1, 1, 1},  // Expected: 4 (Leader is 1)
                {1},  // Expected: 0 (Single element)
                {2, 2, 2, 2, 3, 3, 3, 2, 2},  // Expected: 3
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] test = testCases[i];
            System.out.println("Test Case " + (i + 1) + ": " + sol.solution(test));
        }
    }
}

/*
A non-empty array A consisting of N integers is given.

The leader of this array is the value that occurs in more than half of the elements of A.

An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

For example, given array A such that:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
we can find two equi leaders:

0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
The goal is to count the number of equi leaders.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

For example, given:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
the function should return 2, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 */