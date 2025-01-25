package br.com.rhribeiro25;

public class WordSearch {

    private char[][] board; // The board grid
    private int rows, cols; // Number of rows and columns in the board

    // Constructor to initialize the board
    public WordSearch(char[][] board) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
    }

    // Method to find the word in the grid
    public boolean exist(String word) {
        // Loop through each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Start a DFS from the current cell if the first character matches
                if (board[i][j] == word.charAt(0) && dfs(i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false; // Return false if the word was not found
    }

    // DFS helper method to search for the word
    private boolean dfs(int row, int col, String word, int index) {
        // If the index is equal to the length of the word, we have found the word
        if (index == word.length()) {
            return true;
        }

        // Check if the current position is out of bounds or if the character does not match
        if (row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Temporarily mark the cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore all 8 directions (up, down, left, right, and the 4 diagonals)
        boolean found = dfs(row + 1, col, word, index + 1) ||
                dfs(row - 1, col, word, index + 1) ||
                dfs(row, col + 1, word, index + 1) ||
                dfs(row, col - 1, word, index + 1) ||
                dfs(row + 1, col + 1, word, index + 1) ||
                dfs(row + 1, col - 1, word, index + 1) ||
                dfs(row - 1, col + 1, word, index + 1) ||
                dfs(row - 1, col - 1, word, index + 1);

        // Restore the cell after visiting
        board[row][col] = temp;

        return found; // Return true if the word is found, otherwise false
    }

    // Main method to test the solution
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        WordSearch wordSearch = new WordSearch(board);

        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";

        System.out.println(word1 + " exists: " + wordSearch.exist(word1)); // true
        System.out.println(word2 + " exists: " + wordSearch.exist(word2)); // true
        System.out.println(word3 + " exists: " + wordSearch.exist(word3)); // false
    }
}

/*
 * Problem Description: Word Search
 *
 * The problem involves searching for a word in a 2D grid of letters, where the word can be formed by moving horizontally, vertically, or diagonally.
 * The challenge is to find if a given word exists in the grid by navigating through adjacent cells.
 *
 * Approach:
 * - The solution uses Depth-First Search (DFS) to explore all possible directions starting from each cell in the grid.
 * - For each cell, the algorithm tries to match the first character of the word, and if it matches, it recursively checks all adjacent cells (up, down, left, right, and diagonals).
 * - If the word is found, the search terminates early and returns true.
 * - To avoid revisiting cells during the search, we temporarily mark cells as visited by changing their character (using a marker like '#').
 * - After the search is complete, we restore the original state of the cell.
 * - If all the possibilities are explored without finding the word, the algorithm returns false.
 *
 * Requirements:
 * - The algorithm must efficiently search the grid for the word, considering all possible directions of movement.
 * - It must return true if the word exists, and false otherwise.
 *
 * Constraints:
 * - The grid size is MxN, where M is the number of rows and N is the number of columns.
 * - The word to search for has a length of W.
 * - The search needs to handle grids of varying sizes and words of different lengths.
 *
 * Time Complexity:
 * - The time complexity is O(M * N * 4^L), where M is the number of rows, N is the number of columns, and L is the length of the word being searched.
 * - The search explores all possible directions at each cell, which leads to exponential growth in the number of recursive calls as the length of the word increases.
 *
 * Space Complexity:
 * - The space complexity is O(L) due to the recursion stack, where L is the length of the word.
 */
