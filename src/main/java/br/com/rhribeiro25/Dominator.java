package br.com.rhribeiro25;

import java.util.HashMap;
import java.util.Map;

public class Dominator {
    public int solution(int[] A) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(int N : A){
            counter.put(N, counter.getOrDefault(N, 0) + 1);
        }
        for(int key : counter.keySet()){
            if(counter.get(key) > (A.length/2))
                return indexOf(A, key);

        }
        return -1;
    }
    // Helper method to find the index of the first occurrence of 'key' in the array A
    private int indexOf(int[] A, int key) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == key) {
                return i;
            }
        }
        return -1; // In case the key is not found
    }
    public static void main(String[] args) {
        Dominator solution = new Dominator();

        // Exemplo 1
        int[] A1 = {1, 2, 3, 3, 3, 4, 5};
        System.out.println("Índice do elemento majoritário: " + solution.solution(A1));  // Esperado: 2 (index do valor 3)

        // Exemplo 2
        int[] A2 = {1, 1, 2, 2, 3};
        System.out.println("Índice do elemento majoritário: " + solution.solution(A2));  // Esperado: -1 (não há elemento majoritário)

        // Exemplo 3
        int[] A3 = {10, 10, 10, 20, 20, 10};
        System.out.println("Índice do elemento majoritário: " + solution.solution(A3));  // Esperado: 0 (index do valor 10)
    }
}

/*
An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

For example, consider array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

For example, given array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
the function may return 0, 2, 4, 6 or 7, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 */