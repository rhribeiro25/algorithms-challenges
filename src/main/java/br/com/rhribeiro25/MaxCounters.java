package br.com.rhribeiro25;

import java.util.Arrays;

public class MaxCounters {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int maxCounter = 0;
        int currentMax = 0;

        for (int value : A) {
            if (value >= 1 && value <= N) {
                if (counters[value - 1] < maxCounter) {
                    counters[value - 1] = maxCounter;
                }
                counters[value - 1]++;
                currentMax = Math.max(currentMax, counters[value - 1]);
            } else if (value == N + 1) {
                maxCounter = currentMax;
            }
        }

        for (int i = 0; i < N; i++) {
            if (counters[i] < maxCounter) {
                counters[i] = maxCounter;
            }
        }

        return counters;
    }

    public static void main(String[] args) {
        MaxCounters solution = new MaxCounters();

        // Test case 1
        int N = 5;
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int[] result = solution.solution(N, A);
        System.out.println("Resultado para N=5 e A=[3, 4, 4, 6, 1, 4, 4]: " + Arrays.toString(result));

        // Test case 2
        N = 3;
        A = new int[]{1, 2, 2, 4, 1, 3};
        result = solution.solution(N, A);
        System.out.println("Resultado para N=3 e A=[1, 2, 2, 4, 1, 3]: " + Arrays.toString(result));

        // Test case 3
        N = 4;
        A = new int[]{4, 4, 4, 4, 5};
        result = solution.solution(N, A);
        System.out.println("Resultado para N=4 e A=[4, 4, 4, 4, 5]: " + Arrays.toString(result));
    }
}

/*
You are given N counters, initially set to 0, and you have two possible operations on them:

increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.
A non-empty array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max counter.
For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.

Write a function:

class Solution { public int[] solution(int N, int[] A); }

that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.

Result array should be returned as an array of integers.

For example, given:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.

Write an efficient algorithm for the following assumptions:

N and M are integers within the range [1..100,000];
each element of array A is an integer within the range [1..N + 1].
 */