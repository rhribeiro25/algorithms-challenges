package br.com.rhribeiro25;

import java.util.Stack;

public class Brackets {
    public int solution(String S) {
        // Stack to store opening brackets
        Stack<Character> stack = new Stack<>();

        // Loop through each character in the string
        for (char c : S.toCharArray()) {
            // Push opening brackets onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // Check for matching closing brackets
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return 0; // Unmatched closing bracket
                }
                char top = stack.pop();
                if (!isMatchingPair(top, c)) {
                    return 0; // Mismatched brackets
                }
            }
        }

        // If stack is empty, all brackets are matched
        return stack.isEmpty() ? 1 : 0;
    }

    // Helper method to check if brackets match
    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        Brackets solution = new Brackets();

        // Test cases
        String S1 = "{[()()]}"; // Properly nested
        String S2 = "([)()]";   // Not properly nested

        System.out.println("Result for S1: " + solution.solution(S1)); // Expected: 1
        System.out.println("Result for S2: " + solution.solution(S2)); // Expected: 0
    }
}

/*
A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..200,000];
string S is made only of the following characters: '(', '{', '[', ']', '}' and/or ')'.
 */