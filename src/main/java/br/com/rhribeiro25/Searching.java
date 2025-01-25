package br.com.rhribeiro25;

public class Searching {

    // Binary Search Algorithm (Requires a sorted array)
    public static int binarySearch(int[] arr, int target) {
        int left = 0; // Start of the array
        int right = arr.length - 1; // End of the array

        // Loop until the search interval is valid
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            // If the target is found at the middle, return the index
            if (arr[mid] == target) {
                return mid;
            }

            // If the target is smaller than the middle element, search the left half
            if (arr[mid] > target) {
                right = mid - 1;
            }
            // If the target is larger than the middle element, search the right half
            else {
                left = mid + 1;
            }
        }

        return -1; // Return -1 if the target is not found
    }

    // Main method to test the Binary Search algorithm
    public static void main(String[] args) {
        // Example sorted array for Binary Search
        int[] sortedArray = {1, 3, 5, 7, 8};
        int target = 5; // The target value to search for

        // Perform Binary Search and print the result
        int result = binarySearch(sortedArray, target);
        if (result != -1) {
            System.out.println("Binary Search: Target " + target + " found at index " + result);
        } else {
            System.out.println("Binary Search: Target " + target + " not found");
        }
    }
}

/*
 * Problem: Binary Search
 *
 * **Objective**:
 * The task is to implement and demonstrate the Binary Search algorithm, which is an efficient method for finding the index of a target value in a **sorted array**.
 *
 * **Binary Search**:
 * - Binary Search works by repeatedly dividing the search interval in half. If the value of the search key is less than the item in the middle of the interval, the algorithm narrows the interval to the lower half. Otherwise, it narrows the interval to the upper half.
 * - It requires that the array is **sorted** in ascending or descending order.
 * - **Key Idea**: Instead of checking every element, Binary Search narrows down the possible locations of the target by comparing it with the middle element and eliminating half of the search space in each step.
 *
 * **Time Complexity**:
 * - **O(log n)**, where `n` is the number of elements in the array. The time complexity is logarithmic because the algorithm cuts the search space in half each time.
 *
 * **Space Complexity**:
 * - **O(1)**, as Binary Search only requires a constant amount of space (aside from the input array).
 *
 * **Approach**:
 * - Set `left` to the first index (0) and `right` to the last index (`arr.length - 1`).
 * - In a loop, calculate the middle index `mid = left + (right - left) / 2`.
 * - Compare the element at `mid` with the target:
 *   - If it's equal, return `mid` (target found).
 *   - If the target is smaller, narrow the search to the left half by setting `right = mid - 1`.
 *   - If the target is larger, narrow the search to the right half by setting `left = mid + 1`.
 * - Repeat the process until the target is found or the search interval becomes invalid (`left > right`).
 *
 * **Example**:
 * Given a sorted array: `[1, 3, 5, 7, 8]` and a target value `5`:
 * - Start with `left = 0` and `right = 4`.
 * - Calculate `mid = (0 + 4) / 2 = 2`.
 * - The element at index `2` is `5`, which matches the target.
 * - Return index `2` as the result.
 */
