package br.com.rhribeiro25;

import java.util.Arrays;

class ArrayRotation {
    public int[] solution(int[] A, int K) {
        // Verificar se o array está vazio ou se não há necessidade de rotação
        if (A.length == 0 || K % A.length == 0) {
            return A;
        }

        int arrayLength = A.length;
        int rotations = K % arrayLength; // Reduz o número de rotações se K > n
        int[] result = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            // Calcular a nova posição após a rotação
            int newPosition = (i + rotations) % arrayLength;
            result[newPosition] = A[i];
        }

        return result;
    }
    public static void main(String[] args){
        ArrayRotation arrayRotation = new ArrayRotation();
        Arrays.stream(arrayRotation.solution(new int[]{2, 5, 6, 9, 70}, 3))
                .forEach(System.out::print);
    }
}