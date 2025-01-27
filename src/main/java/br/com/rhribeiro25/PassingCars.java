package br.com.rhribeiro25;

public class PassingCars {
    public int solution(int[] A) {
        int countEast = 0; // Conta os carros indo para o leste (0)
        int passingCars = 0; // Conta os pares de carros que se cruzam

        for (int car : A) {
            if (car == 0) {
                countEast++; // Um carro indo para o leste foi encontrado
            } else {
                passingCars += countEast; // Para cada carro indo para o oeste, adicione todos os carros que foram para o leste
                if (passingCars > 1_000_000_000) {
                    return -1; // Retorna -1 se exceder o limite
                }
            }
        }

        return passingCars; // Retorna o número total de pares de carros que se cruzam
    }

    public static void main(String[] args) {
        PassingCars solution = new PassingCars();

        // Testes
        int[] A1 = {0, 1, 0, 1, 1};
        System.out.println("Resultado: " + solution.solution(A1)); // Saída: 5

        int[] A2 = {0, 0, 1, 1, 1};
        System.out.println("Resultado: " + solution.solution(A2)); // Saída: 6

        int[] A3 = {1, 0, 1, 0};
        System.out.println("Resultado: " + solution.solution(A3)); // Saída: 1
    }

}

/*
A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.

Array A contains only 0s and/or 1s:

0 represents a car traveling east,
1 represents a car traveling west.
The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.

For example, consider array A such that:

  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the number of pairs of passing cars.

The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.

For example, given:

  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
the function should return 5, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer that can have one of the following values: 0, 1.
 */