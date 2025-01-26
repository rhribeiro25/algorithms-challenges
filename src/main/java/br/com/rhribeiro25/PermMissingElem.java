package br.com.rhribeiro25;

public class PermMissingElem {
    public int solution(int[] A) {
        int N = A.length;
        int xorTotal = 0;

        // XOR de todos os elementos do array
        for (int num : A) {
            xorTotal ^= num;
        }

        // XOR de todos os números de 1 até N+1
        for (int i = 1; i <= N + 1; i++) {
            xorTotal ^= i;
        }

        // O número ausente é o resultado final do XOR
        return xorTotal;
    }
    public static void main(String[] args) {
        PermMissingElem solution = new PermMissingElem();

        // Exemplo 1
        int[] A1 = {2, 3, 1, 5};
        System.out.println("Missing number: " + solution.solution(A1)); // Output: 4

        // Exemplo 2
        int[] A2 = {1, 2, 3, 5, 6};
        System.out.println("Missing number: " + solution.solution(A2)); // Output: 4

        // Exemplo 3
        int[] A3 = {1};
        System.out.println("Missing number: " + solution.solution(A3)); // Output: 2

        // Exemplo 4 - Array vazio
        int[] A4 = {};
        System.out.println("Missing number: " + solution.solution(A4)); // Output: 1

        // Exemplo 5 - Array com o maior número ausente
        int[] A5 = {2, 3, 4, 5};
        System.out.println("Missing number: " + solution.solution(A5)); // Output: 1
    }

}

/*
An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
 */