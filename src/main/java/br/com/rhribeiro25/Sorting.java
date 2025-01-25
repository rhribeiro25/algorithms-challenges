package br.com.rhribeiro25;

import java.util.Arrays;

public class Sorting {

    // Merge Sort Algorithm
    public static void mergeSort(int[] arr) {
        // Base case: if the array has one or fewer elements, it's already sorted
        if (arr.length <= 1) {
            return;
        }

        // Step 1: Divide the array into two halves
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid); // Copy the left half
        System.arraycopy(arr, mid, right, 0, arr.length - mid); // Copy the right half

        // Step 2: Recursively sort both halves
        mergeSort(left);
        mergeSort(right);

        // Step 3: Merge the sorted halves
        merge(arr, left, right);
    }

    // Helper method to merge two sorted arrays into one sorted array
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge the left and right arrays into arr
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // If there are remaining elements in the left array, add them to arr
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // If there are remaining elements in the right array, add them to arr
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Main method to test Merge Sort
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1}; // Example array to sort

        System.out.println("Before sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Perform Merge Sort
        mergeSort(arr);

        System.out.println("After sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

/*
 * Problem: Merge Sort
 *
 * **Objective**:
 * The task is to implement the Merge Sort algorithm, which is a classic example of the **divide-and-conquer** paradigm.
 * The idea is to divide the array into two halves, recursively sort each half, and merge the sorted halves to produce the final sorted array.
 *
 * **Merge Sort**:
 * - Merge Sort works by recursively dividing the array into two halves until each subarray contains only one element (which is trivially sorted).
 * - Then, it merges the sorted subarrays to form a single sorted array.
 * - The merging process involves comparing the elements of the two subarrays and combining them in sorted order.
 *
 * **Time Complexity**:
 * - **O(n log n)**, where `n` is the number of elements in the array. This is because the array is recursively divided in half (`log n` divisions), and each division requires merging all `n` elements.
 *
 * **Space Complexity**:
 * - **O(n)**, as merge sort requires additional space to store the left and right subarrays during the merge process.
 *
 * **Approach**:
 * - **Step 1**: Divide the array into two halves.
 * - **Step 2**: Recursively sort each half.
 * - **Step 3**: Merge the sorted halves together.
 *
 * **Example**:
 * Given the array: `[4, 3, 2, 1]`:
 * - **Step 1**: Divide the array into two halves: `[4, 3]` and `[2, 1]`.
 * - **Step 2**: Recursively sort each half:
 *   - `[4, 3]` becomes `[3, 4]`.
 *   - `[2, 1]` becomes `[1, 2]`.
 * - **Step 3**: Merge the sorted halves to get `[1, 2, 3, 4]`.
 */
