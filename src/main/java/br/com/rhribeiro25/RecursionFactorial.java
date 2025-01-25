package br.com.rhribeiro25;

public class RecursionFactorial {

    // Recursive method to compute the factorial of a number
    public static int factorial(int n) {
        // Base case: if n is 0, return 1 (factorial of 0 is 1)
        if (n == 0) {
            return 1;
        }

        // Recursive case: n * factorial(n-1)
        return n * factorial(n - 1);
    }

    // Main method to test the factorial function
    public static void main(String[] args) {
        int number = 5; // Example number

        // Compute and print the factorial of the given number
        int result = factorial(number);
        System.out.println("The factorial of " + number + " is: " + result); // Output: 120
    }
}

/*
 * Problem: Recursion Factorial
 *
 * **Objective**:
 * The task is to compute the factorial of a non-negative integer `n` using recursion.
 * The factorial of a number `n`, denoted as `n!`, is the product of all positive integers less than or equal to `n`.
 * Specifically, the factorial function can be defined as:
 *
 * - `n! = n * (n-1) * (n-2) * ... * 1` for `n > 0`
 * - `0! = 1` (base case)
 *
 * **Problem Definition**:
 * Given a non-negative integer `n`, we need to compute `n!` recursively. The recursive function should call itself to compute the factorial of smaller values of `n` until the base case (`n == 0`) is reached.
 *
 * **Base Case**:
 * - The factorial of 0 is defined as 1. This is the stopping condition for the recursion.
 *
 * **Recursive Case**:
 * - For any positive integer `n`, the factorial of `n` is `n * factorial(n-1)`.
 *
 * **Approach**:
 * - The factorial function can be implemented recursively. In the base case, we return 1 for `n == 0`.
 * - In the recursive case, we return the product of `n` and the factorial of `n-1`.
 * - This recursive call will continue until it reaches the base case.
 *
 * **Time Complexity**:
 * - The time complexity is **O(n)**, where `n` is the input number. This is because the function makes `n` recursive calls, each performing a constant-time multiplication.
 *
 * **Space Complexity**:
 * - The space complexity is **O(n)** due to the recursive call stack. In the worst case, the recursion depth is equal to `n`, so the space used by the recursion stack is proportional to `n`.
 *
 * **Example**:
 * Given `n = 5`, the factorial calculation proceeds as follows:
 *
 * factorial(5) = 5 * factorial(4)
 * factorial(4) = 4 * factorial(3)
 * factorial(3) = 3 * factorial(2)
 * factorial(2) = 2 * factorial(1)
 * factorial(1) = 1 * factorial(0)
 * factorial(0) = 1 (base case)
 *
 * Thus, the factorial of 5 is: `5 * 4 * 3 * 2 * 1 = 120`
 */
