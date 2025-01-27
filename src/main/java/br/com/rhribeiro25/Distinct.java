package br.com.rhribeiro25;

import java.util.HashSet;
import java.util.Set;

public class Distinct {
    public int solution(int[] A) {
        // Create a HashSet to store distinct values
        Set<Integer> distinctValues = new HashSet<>();

        // Add each element from the array into the HashSet
        for (int num : A) {
            distinctValues.add(num);
        }

        // Return the number of distinct values
        return distinctValues.size();
    }
    public static void main(String[] args) {
        Distinct solution = new Distinct();

        int[] A = {2, 1, 1, 2, 3, 1};  // Example input array
        int result = solution.solution(A);

        System.out.println("Number of distinct values: " + result);  // Expected output: 3
    }
}

/*
Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the number of distinct values in array A.

For example, given array A consisting of six elements such that:

 A[0] = 2    A[1] = 1    A[2] = 1
 A[3] = 2    A[4] = 3    A[5] = 1
the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */