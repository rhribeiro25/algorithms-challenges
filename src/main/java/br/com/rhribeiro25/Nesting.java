package br.com.rhribeiro25;

import java.util.Stack;

public class Nesting {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        if(S.isEmpty())
            return 1;
        for(Character C : S.toCharArray()){
            if(C == '(' || C == 'V')
                stack.push(C);
            else if(C == ')' || C == 'W'){
                if(stack.isEmpty())
                    return 0;
                char top = stack.pop();
                if(!this.isMatchingPair(top, C))
                    return 0;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == 'V' && close == 'W');
    }
    public static void main(String[] args) {
        Nesting solution = new Nesting();

        // Mock test cases
        String[] testStrings = {
                "(()(())())", // Properly nested
                "())",         // Not properly nested
                "((()))",      // Properly nested
                "())(()",       // Not properly nested
                "",            // Empty string (properly nested)
                "((())"         // Not properly nested
        };

        for (String testString : testStrings) {
            int result = solution.solution(testString);
            if (result == 1) {
                System.out.println("The string \"" + testString + "\" is properly nested.");
            } else {
                System.out.println("The string \"" + testString + "\" is NOT properly nested.");
            }
        }
    }
}

/*
A string S consisting of N characters is called properly nested if:

S is empty;
S has the form "(U)" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..1,000,000];
string S is made only of the characters '(' and/or ')'.
 */