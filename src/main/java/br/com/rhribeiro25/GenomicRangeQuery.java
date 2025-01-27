package br.com.rhribeiro25;

import java.util.Arrays;

public class GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        int N = S.length();
        int M = P.length;
        int[] result = new int[M];

        // Arrays de prefix sum para A, C, G, T
        int[] prefixA = new int[N + 1];
        int[] prefixC = new int[N + 1];
        int[] prefixG = new int[N + 1];
        int[] prefixT = new int[N + 1];

        // Preencher os arrays de prefix sums
        for (int i = 0; i < N; i++) {
            prefixA[i + 1] = prefixA[i];
            prefixC[i + 1] = prefixC[i];
            prefixG[i + 1] = prefixG[i];
            prefixT[i + 1] = prefixT[i];

            char nucleotide = S.charAt(i);
            if (nucleotide == 'A') {
                prefixA[i + 1]++;
            } else if (nucleotide == 'C') {
                prefixC[i + 1]++;
            } else if (nucleotide == 'G') {
                prefixG[i + 1]++;
            } else if (nucleotide == 'T') {
                prefixT[i + 1]++;
            }
        }

        // Processar cada consulta
        for (int i = 0; i < M; i++) {
            int start = P[i];
            int end = Q[i];

            // Verificar o impacto mínimo entre os intervalos usando os prefix sums
            if (prefixA[end + 1] - prefixA[start] > 0) {
                result[i] = 1;
            } else if (prefixC[end + 1] - prefixC[start] > 0) {
                result[i] = 2;
            } else if (prefixG[end + 1] - prefixG[start] > 0) {
                result[i] = 3;
            } else if (prefixT[end + 1] - prefixT[start] > 0) {
                result[i] = 4;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        GenomicRangeQuery solution = new GenomicRangeQuery();

        // Example Test Case: "CAGCCTA"
        String S1 = "CAGCCTA";
        int[] P1 = {2, 5, 0};
        int[] Q1 = {4, 5, 6};
        int[] result1 = solution.solution(S1, P1, Q1);
        System.out.println("Example 1 result: " + Arrays.toString(result1)); // Expected: [2, 4, 1]

        // Extreme Test Case: Single character string
        String S2 = "A";
        int[] P2 = {0};
        int[] Q2 = {0};
        int[] result2 = solution.solution(S2, P2, Q2);
        System.out.println("Extreme Single character result: " + Arrays.toString(result2)); // Expected: [1]

        // Extreme Test Case: Double character string
        String S3 = "AC";
        int[] P3 = {0, 1};
        int[] Q3 = {0, 1};
        int[] result3 = solution.solution(S3, P3, Q3);
        System.out.println("Extreme Double character result: " + Arrays.toString(result3)); // Expected: [1, 2]

        // Simple Test Case
        String S4 = "AAGCTT";
        int[] P4 = {0, 1, 3};
        int[] Q4 = {1, 2, 5};
        int[] result4 = solution.solution(S4, P4, Q4);
        System.out.println("Simple Test Case result: " + Arrays.toString(result4)); // Expected: [1, 1, 1]

        // Small Length String
        String S5 = "AGCT";
        int[] P5 = {0, 1};
        int[] Q5 = {3, 2};
        int[] result5 = solution.solution(S5, P5, Q5);
        System.out.println("Small Length String result: " + Arrays.toString(result5)); // Expected: [1, 1]

        // Small Random String
        String S6 = "TGCATG";
        int[] P6 = {0, 1, 2};
        int[] Q6 = {2, 4, 5};
        int[] result6 = solution.solution(S6, P6, Q6);
        System.out.println("Small Random String result: " + Arrays.toString(result6)); // Expected: [1, 1, 1]

        // Performance Test 1: Almost all same letters (G repeated)
        String S7 = "G".repeat(1000000); // 1 million 'G's
        int[] P7 = {100000, 500000, 0};
        int[] Q7 = {200000, 600000, 999999};
        long startTime7 = System.nanoTime();
        int[] result7 = solution.solution(S7, P7, Q7);
        long endTime7 = System.nanoTime();
        System.out.println("Almost all same letters result: " + Arrays.toString(result7)); // Expected: [3, 3, 3]
        System.out.println("Performance test executed in " + (endTime7 - startTime7) / 1000000 + " ms");

        // Performance Test 3: Extreme Large case
        String S9 = "A".repeat(1000000); // One million 'A'
        int[] P9 = {0, 999999};
        int[] Q9 = {500000, 999999};
        long startTime9 = System.nanoTime();
        int[] result9 = solution.solution(S9, P9, Q9);
        long endTime9 = System.nanoTime();
        System.out.println("Extreme Large test executed in " + (endTime9 - startTime9) / 1000000 + " ms");
    }
}

/*
A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?

The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).

For example, consider string S = CAGCCTA and arrays P, Q such that:

    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
The answers to these M = 3 queries are as follows:

The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
Write a function:

class Solution { public int[] solution(String S, int[] P, int[] Q); }

that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.

Result array should be returned as an array of integers.

For example, given the string S = CAGCCTA and arrays P, Q such that:

    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
the function should return the values [2, 4, 1], as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
M is an integer within the range [1..50,000];
each element of arrays P and Q is an integer within the range [0..N - 1];
P[K] ≤ Q[K], where 0 ≤ K < M;
string S consists only of upper-case English letters A, C, G, T.
 */