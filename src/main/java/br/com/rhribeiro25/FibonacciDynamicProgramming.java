package br.com.rhribeiro25;

import java.util.HashMap;
import java.util.Map;

public class FibonacciDynamicProgramming {
    private static Map<Integer, Long> memo = new HashMap<>();

    public static long fibonacci(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);

        long result = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        int n = 50;
        System.out.println("Fibonacci of " + n + ": " + fibonacci(n));
    }
}
