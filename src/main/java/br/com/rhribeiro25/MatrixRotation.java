package br.com.rhribeiro25;

public class MatrixRotation {

    // Method to rotate a matrix 90 degrees clockwise in-place
    public static void rotate(int[][] matrix) {
        int n = matrix.length;  // Get the size of the matrix (n x n)

        // Step 1: Transpose the matrix (swap elements across the diagonal)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row of the transposed matrix
        for (int i = 0; i < n; i++) {
            int left = 0; // Pointer for the start of the row
            int right = n - 1; // Pointer for the end of the row

            // While left pointer is less than the right pointer, swap the elements
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                // Move the pointers towards the center of the row
                left++;
                right--;
            }
        }
    }

    // Helper method to print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " "); // Print each element in a row
            }
            System.out.println(); // Move to the next line after printing a row
        }
    }

    public static void main(String[] args) {
        // Example input matrix (3x3 matrix)
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Print the original matrix
        System.out.println("Original Matrix:");
        printMatrix(matrix);

        // Rotate the matrix 90 degrees clockwise
        rotate(matrix);

        // Print the matrix after rotation
        System.out.println("\nMatrix after rotation:");
        printMatrix(matrix);
    }
}

/*
 * Problem: Rotate a 2D Matrix 90 Degrees Clockwise
 *
 * **Objective**:
 * The task is to rotate a given square matrix by 90 degrees in a clockwise direction.
 * A square matrix is a matrix with an equal number of rows and columns (n x n).
 *
 * **Problem Definition**:
 * Given a 2D matrix `matrix` of size `n x n`, the goal is to rotate the matrix such that the elements are
 * shifted 90 degrees clockwise. This means that:
 * - The element in the first row and first column moves to the first column in the last row.
 * - The element in the second row and first column moves to the first column in the second-last row.
 * - And so on.
 *
 * **Steps**:
 * There are two main steps to rotate a matrix 90 degrees clockwise:
 * 1. **Transpose the matrix**: This means converting rows into columns.
 *    In this step, the element at position `(i, j)` becomes the element at position `(j, i)`.
 * 2. **Reverse each row**: After transposing, reverse the elements of each row to achieve the 90-degree rotation.
 *
 * **In-place Rotation**:
 * - We can perform the rotation in place without using any extra space. This is done by transposing the matrix
 *   and then reversing the rows directly in the original matrix.
 *
 * **Time Complexity**:
 * - The time complexity of this algorithm is **O(n^2)**, where `n` is the number of rows (or columns) in the matrix.
 *   This is because both the transposition and the reversal of rows each take **O(n^2)** time.
 *
 * **Space Complexity**:
 * - The space complexity is **O(1)** since we are performing the operation in-place, modifying the matrix directly
 *   without using extra space.
 *
 * **Example**:
 * Given the matrix:
 * matrix = [
 *   [1, 2, 3],
 *   [4, 5, 6],
 *   [7, 8, 9]
 * ]
 * After rotating it 90 degrees clockwise, the matrix becomes:
 * matrix = [
 *   [7, 4, 1],
 *   [8, 5, 2],
 *   [9, 6, 3]
 * ]
 */
