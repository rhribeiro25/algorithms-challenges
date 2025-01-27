package br.com.rhribeiro25;

public class CountDiv {
    public int solution(int A, int B, int K) {
        // Quantos múltiplos de K existem até B
        int countB = B / K;

        // Quantos múltiplos de K existem até A-1
        int countA = (A > 0) ? (A - 1) / K : -1;

        // Total de múltiplos no intervalo [A..B]
        return countB - countA;
    }
    public static void main(String[] args) {
        CountDiv countDiv = new CountDiv();

        // Test cases
        int A1 = 6, B1 = 11, K1 = 2;
        System.out.println("Count of divisible numbers between " + A1 + " and " + B1 + " by " + K1 + " is: " + countDiv.solution(A1, B1, K1)); // Output: 3

        int A2 = 0, B2 = 10, K2 = 3;
        System.out.println("Count of divisible numbers between " + A2 + " and " + B2 + " by " + K2 + " is: " + countDiv.solution(A2, B2, K2)); // Output: 4

        int A3 = 10, B3 = 10, K3 = 5;
        System.out.println("Count of divisible numbers between " + A3 + " and " + B3 + " by " + K3 + " is: " + countDiv.solution(A3, B3, K3)); // Output: 1

        int A4 = 10, B4 = 20, K4 = 7;
        System.out.println("Count of divisible numbers between " + A4 + " and " + B4 + " by " + K4 + " is: " + countDiv.solution(A4, B4, K4)); // Output: 2

        int A5 = 1, B5 = 1_000_000_000, K5 = 2;
        System.out.println("Count of divisible numbers between " + A5 + " and " + B5 + " by " + K5 + " is: " + countDiv.solution(A5, B5, K5)); // Output: 500,000,000
    }
}

/*
Write a function:

class Solution { public int solution(int A, int B, int K); }

that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Write an efficient algorithm for the following assumptions:

A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.
 */