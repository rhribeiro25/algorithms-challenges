package br.com.rhribeiro25;

import java.util.Arrays;

public class MissingInteger {
    public int solution(int[] A) {
        Arrays.sort(A); // Ordena o array
        int smallest = 1; // Começa pelo menor número positivo esperado

        for (int num : A) {
            if (num == smallest) {
                smallest++; // Avança para o próximo número esperado
            }
        }

        return smallest; // Retorna o menor número positivo ausente
    }

    public static void main(String[] args) {
        MissingInteger solution = new MissingInteger();

        // Testes
        int[] A1 = {1, 3, 6, 4, 1, 2};
        System.out.println("Resultado: " + solution.solution(A1)); // Saída: 5

        int[] A2 = {1, 2, 3};
        System.out.println("Resultado: " + solution.solution(A2)); // Saída: 4

        int[] A3 = {-1, -3};
        System.out.println("Resultado: " + solution.solution(A3)); // Saída: 1
    }
}

/*
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */