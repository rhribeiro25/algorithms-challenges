package br.com.rhribeiro25;

import java.util.Arrays;

public class Triangle {
    public int solution(int[] A) {
        // If there are fewer than 3 elements, no triplet can exist
        if (A.length < 3) {
            return 0;
        }

        // Sort the array
        Arrays.sort(A);

        // Check consecutive triplets
        for (int i = 0; i < A.length - 2; i++) {
            // Check the triangle inequality condition
            if ((long) A[i] + A[i + 1] > A[i + 2]) {
                return 1; // Triangular triplet exists
            }
        }

        return 0; // No triangular triplet exists
    }
    public static void main(String[] args) {
        Triangle solution = new Triangle();

        int[] test1 = {10, 2, 5, 1, 8, 20};
        int[] test2 = {10, 50, 5, 1};
        int[] test3 = {1, 2};
        int[] test4 = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

        System.out.println("Test 1: " + solution.solution(test1)); // Output: 1
        System.out.println("Test 2: " + solution.solution(test2)); // Output: 0
        System.out.println("Test 3: " + solution.solution(test3)); // Output: 0
        System.out.println("Test 4: " + solution.solution(test4)); // Output: 1
    }
}

/*
An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

A[P] + A[Q] > A[R],
A[Q] + A[R] > A[P],
A[R] + A[P] > A[Q].
For example, consider array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
Triplet (0, 2, 4) is triangular.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

For example, given array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
the function should return 1, as explained above. Given array A such that:

  A[0] = 10    A[1] = 50    A[2] = 5
  A[3] = 1
the function should return 0.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 */