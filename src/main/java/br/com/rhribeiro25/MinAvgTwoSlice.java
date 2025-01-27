package br.com.rhribeiro25;

public class MinAvgTwoSlice {
    public int solution(int[] A) {
        int N = A.length;

        // To store the starting index of the slice with minimal average
        int minIndex = 0;
        // Initialize the minimal average with a large value
        double minAverage = Double.MAX_VALUE;

        // Loop through the array and check pairs and triplets
        for (int i = 0; i < N - 1; i++) {
            // Check the average of the slice (i, i+1) -> a pair of elements
            double avg2 = (A[i] + A[i + 1]) / 2.0;
            if (avg2 < minAverage) {
                minAverage = avg2;
                minIndex = i;
            }

            // Check the average of the slice (i, i+2) -> a triplet if possible
            if (i < N - 2) {
                double avg3 = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
                if (avg3 < minAverage) {
                    minAverage = avg3;
                    minIndex = i;
                }
            }
        }

        return minIndex;
    }
    public static void main(String[] args) {
        MinAvgTwoSlice solution = new MinAvgTwoSlice();

        // Test case 1: Given array
        int[] A1 = {4, 2, 2, 5, 1, 5, 8};
        System.out.println("Minimal average slice starts at index: " + solution.solution(A1));  // Expected: 1

        // Test case 2: Another example
        int[] A2 = {1, 3, 5, 7, 9};
        System.out.println("Minimal average slice starts at index: " + solution.solution(A2));  // Expected: 0

        // Test case 3: Negative numbers in the array
        int[] A3 = {-1, -2, -3, -4, -5};
        System.out.println("Minimal average slice starts at index: " + solution.solution(A3));  // Expected: 0

        // Test case 4: Small array with only two elements
        int[] A4 = {10, 20};
        System.out.println("Minimal average slice starts at index: " + solution.solution(A4));  // Expected: 0

        // Test case 5: Large array (performance test)
        int[] A5 = new int[100000];
        for (int i = 0; i < 100000; i++) {
            A5[i] = i;
        }
        long startTime = System.nanoTime();
        System.out.println("Minimal average slice starts at index: " + solution.solution(A5));
        long endTime = System.nanoTime();
        System.out.println("Performance test executed in " + (endTime - startTime) / 1000000 + " ms");
    }
}

/*
A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

For example, array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
contains the following example slices:

slice (1, 2), whose average is (2 + 2) / 2 = 2;
slice (3, 4), whose average is (5 + 1) / 2 = 3;
slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
The goal is to find the starting position of a slice whose average is minimal.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

For example, given array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−10,000..10,000].
 */