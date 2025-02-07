package br.com.rhribeiro25;

public class MaxSliceSum {
    public int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int maxEndingHere = A[0]; // Inicializa com o primeiro elemento
        int maxSoFar = A[0]; // Inicializa com o primeiro elemento

        for (int i = 1; i < A.length; i++) {
            maxEndingHere = Math.max(A[i], maxEndingHere + A[i]); // Decide se começa um novo subarray ou continua o atual
            maxSoFar = Math.max(maxSoFar, maxEndingHere); // Atualiza o máximo global
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        MaxSliceSum sol = new MaxSliceSum();

        int[] A1 = {3, 2, -6, 4, 0};
        System.out.println("Max slice sum: " + sol.solution(A1)); // Esperado: 5

        int[] A2 = {-2, 1};
        System.out.println("Max slice sum: " + sol.solution(A2)); // Esperado: 1

        int[] A3 = {5, -7, 3, 5, -2, 4, -1};
        System.out.println("Max slice sum: " + sol.solution(A3)); // Esperado: 10

        int[] A4 = {-10, -5, -3, -1};
        System.out.println("Max slice sum: " + sol.solution(A4)); // Esperado: -1 (maior número único)

        int[] A5 = {1, 2, 3, 4, 5};
        System.out.println("Max slice sum: " + sol.solution(A5)); // Esperado: 15 (soma total)
    }
}

/*
A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the maximum sum of any slice of A.

For example, given array A such that:

A[0] = 3  A[1] = 2  A[2] = -6
A[3] = 4  A[4] = 0
the function should return 5 because:

(3, 4) is a slice of A that has sum 4,
(2, 2) is a slice of A that has sum −6,
(0, 1) is a slice of A that has sum 5,
no other slice of A has sum greater than (0, 1).
Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..1,000,000];
each element of array A is an integer within the range [−1,000,000..1,000,000];
the result will be an integer within the range [−2,147,483,648..2,147,483,647].
 */