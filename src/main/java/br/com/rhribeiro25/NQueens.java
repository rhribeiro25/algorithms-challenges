package br.com.rhribeiro25;

public class NQueens {

    private int N; // Size of the chessboard (NxN)
    private int[] board; // Array to store positions of queens on the board

    // Constructor to initialize the N-Queens problem
    public NQueens(int N) {
        this.N = N;
        board = new int[N]; // Array to hold the column positions of queens
    }

    // Method to solve the N-Queens problem using backtracking
    public void solveNQueens() {
        if (solve(0)) {
            printSolution();
        } else {
            System.out.println("Solution does not exist.");
        }
    }

    // Helper method to solve the problem using backtracking
    private boolean solve(int row) {
        if (row == N) {
            // All queens are placed successfully
            return true;
        }

        for (int col = 0; col < N; col++) {
            // Check if placing a queen at (row, col) is safe
            if (isSafe(row, col)) {
                board[row] = col; // Place queen
                // Recursively place queens in the next row
                if (solve(row + 1)) {
                    return true;
                }
                // Backtrack if placing queen does not lead to a solution
                board[row] = -1;
            }
        }
        return false; // No solution found in this row
    }

    // Method to check if it's safe to place a queen at (row, col)
    private boolean isSafe(int row, int col) {
        // Check the column for previous rows
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false; // Same column or diagonal conflict
            }
        }
        return true; // No conflict
    }

    // Method to print the solution
    private void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i] == j) {
                    System.out.print("Q "); // Place queen
                } else {
                    System.out.print(". "); // Empty space
                }
            }
            System.out.println();
        }
    }

    // Main method to test the solution
    public static void main(String[] args) {
        int N = 4; // Size of the board (4x4)
        NQueens nQueens = new NQueens(N);
        nQueens.solveNQueens();
    }
}

/*
 * Problem Description: N-Queens Problem
 *
 * The N-Queens problem is a classic problem in computer science and artificial intelligence. The goal is to place N queens on an N x N chessboard such that no two queens
 * threaten each other. This means no two queens can be placed on the same row, column, or diagonal.
 *
 * Approach:
 * - Use backtracking to try placing queens on the board row by row.
 * - For each row, attempt to place a queen in each column and check if it is safe to do so.
 * - The placement is considered safe if no other queen can attack the new queen, meaning no two queens share the same column or diagonal.
 * - If a queen can be placed safely, move on to the next row. If all rows are successfully filled, a solution has been found.
 * - If placing a queen does not lead to a solution, backtrack and try a different column for the queen.
 *
 * Requirements:
 * - The algorithm must find a solution where all queens are placed on the board such that no two queens threaten each other.
 * - It must be implemented efficiently to work for various values of N.
 * - The solution must be displayed visually, showing the board with queens represented by "Q" and empty spaces represented by ".".
 *
 * Limitation:
 * - The current solution finds only one valid arrangement of queens. If multiple solutions are needed, the algorithm can be modified to continue searching for other solutions.
 */
