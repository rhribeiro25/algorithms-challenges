package br.com.rhribeiro25;

import java.util.HashSet;

public class PermCheck {
    public int solution(int[] A) {
        // Tamanho do array
        int n = A.length;

        // Conjunto para verificar duplicatas e valores fora do intervalo
        HashSet<Integer> seen = new HashSet<>();

        for (int value : A) {
            // Verifique se o valor está fora do intervalo permitido
            if (value < 1 || value > n) {
                return 0;
            }

            // Verifique duplicatas
            if (!seen.add(value)) {
                return 0;
            }
        }
        // Se todas as condições forem atendidas, é uma permutação
        return 1;
    }
    public static void main(String[] args) {
        PermCheck solution = new PermCheck();

        // Testes
        int[] test1 = {4, 1, 3, 2};
        int[] test2 = {4, 1, 3};
        int[] test3 = {4, 1, 3, 3};
        int[] test4 = {4, 1, 3, 5};
        int[] test5 = {1};

        System.out.println("Teste 1: " + solution.solution(test1)); // Esperado: 1
        System.out.println("Teste 2: " + solution.solution(test2)); // Esperado: 0
        System.out.println("Teste 3: " + solution.solution(test3)); // Esperado: 0
        System.out.println("Teste 4: " + solution.solution(test4)); // Esperado: 0
        System.out.println("Teste 5: " + solution.solution(test5)); // Esperado: 1
    }
}

/*
A non-empty array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

For example, given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.

Given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].
 */