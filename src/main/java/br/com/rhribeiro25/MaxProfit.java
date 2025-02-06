package br.com.rhribeiro25;

public class MaxProfit {
    public int solution(int[] A) {
        if (A.length == 0) return 0;

        int minPrice = A[0]; // Track the lowest price
        int maxProfit = 0;    // Maximum profit found

        for (int i = 1; i < A.length; i++) {
            // Update minPrice if a lower value is found
            minPrice = Math.min(minPrice, A[i]);
            // Calculate possible profit and update maxProfit
            maxProfit = Math.max(maxProfit, A[i] - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit sol = new MaxProfit();
        int[] test1 = {23171, 21011, 21123, 21366, 21013, 21367}; // Expected: 356
        int[] test2 = {8, 9, 3, 2, 5, 1}; // Expected: 3 (buy at 2, sell at 5)
        int[] test3 = {5, 4, 3, 2, 1}; // Expected: 0 (No profit possible)
        int[] test4 = {100, 180, 260, 310, 40, 535, 695}; // Expected: 655 (buy at 40, sell at 695)
        int[] test5 = {}; // Expected: 0 (Empty array)

        System.out.println("Test 1: " + sol.solution(test1));
        System.out.println("Test 2: " + sol.solution(test2));
        System.out.println("Test 3: " + sol.solution(test3));
        System.out.println("Test 4: " + sol.solution(test4));
        System.out.println("Test 5: " + sol.solution(test5));
    }
}

/*
An array A consisting of N integers is given. It contains daily prices of a stock share for a period of N consecutive days. If a single share was bought on day P and sold on day Q, where 0 ≤ P ≤ Q < N, then the profit of such transaction is equal to A[Q] − A[P], provided that A[Q] ≥ A[P]. Otherwise, the transaction brings loss of A[P] − A[Q].

For example, consider the following array A consisting of six elements such that:

  A[0] = 23171
  A[1] = 21011
  A[2] = 21123
  A[3] = 21366
  A[4] = 21013
  A[5] = 21367
If a share was bought on day 0 and sold on day 2, a loss of 2048 would occur because A[2] − A[0] = 21123 − 23171 = −2048. If a share was bought on day 4 and sold on day 5, a profit of 354 would occur because A[5] − A[4] = 21367 − 21013 = 354. Maximum possible profit was 356. It would occur if a share was bought on day 1 and sold on day 5.

Write a function,

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers containing daily prices of a stock share for a period of N consecutive days, returns the maximum possible profit from one transaction during this period. The function should return 0 if it was impossible to gain any profit.

For example, given array A consisting of six elements such that:

  A[0] = 23171
  A[1] = 21011
  A[2] = 21123
  A[3] = 21366
  A[4] = 21013
  A[5] = 21367
the function should return 356, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..400,000];
each element of array A is an integer within the range [0..200,000].
 */
