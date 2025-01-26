package br.com.rhribeiro25;

class TapeEquilibrium {
    public int solution(int[] A) {
        int totalSum = 0;
        for (int num : A) {
            totalSum += num; // Calcula a soma total do array
        }

        int leftSum = 0;
        int minimalDifference = Integer.MAX_VALUE;

        for (int P = 0; P < A.length - 1; P++) {
            leftSum += A[P]; // Soma acumulada do lado esquerdo
            int rightSum = totalSum - leftSum; // Soma acumulada do lado direito
            int currentDifference = Math.abs(leftSum - rightSum); // Diferença absoluta
            minimalDifference = Math.min(minimalDifference, currentDifference); // Atualiza o menor valor
        }

        return minimalDifference;
    }
    public static void main(String[] args) {
        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();

        // Teste 1
        int[] A1 = {3, 1, 2, 4, 3};
        System.out.println("Minimal difference: " + tapeEquilibrium.solution(A1)); // Output: 1

        // Teste 2
        int[] A2 = {5, 6, 2, 4, 1};
        System.out.println("Minimal difference: " + tapeEquilibrium.solution(A2)); // Output: 4

        // Teste 3
        int[] A3 = {1, 2};
        System.out.println("Minimal difference: " + tapeEquilibrium.solution(A3)); // Output: 1

        // Teste 4
        int[] A4 = {-10, -20, -30, -40, 100};
        System.out.println("Minimal difference: " + tapeEquilibrium.solution(A4)); // Output: 20

        // Teste 5
        int[] A5 = {1, 1, 1, 1, 1};
        System.out.println("Minimal difference: " + tapeEquilibrium.solution(A5)); // Output: 1
    }
}

/*
A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example, consider array A such that:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
We can split this tape in four places:

P = 1, difference = |3 − 10| = 7
P = 2, difference = |4 − 9| = 5
P = 3, difference = |6 − 7| = 1
P = 4, difference = |10 − 3| = 7
Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.

For example, given:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−1,000..1,000].
 */