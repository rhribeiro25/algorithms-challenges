package br.com.rhribeiro25;

public class Searching {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Verifica se o alvo está no meio
            if (arr[mid] == target) {
                return mid;
            }

            // Se o alvo for maior, ignora a metade esquerda
            if (arr[mid] < target) {
                left = mid + 1;
            } else { // Caso contrário, ignora a metade direita
                right = mid - 1;
            }
        }

        return -1; // Não encontrado
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9};
        int result = binarySearch(numbers, 5);
        System.out.println(result);  // Output: 2 (índice do número 5)
    }
}
