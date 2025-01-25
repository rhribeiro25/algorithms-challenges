package br.com.rhribeiro25;

import java.util.Arrays;

public class AnagramCheckerUsingSorting {

    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("listen", "silent"));  // Output: true
        System.out.println(areAnagrams("hello", "world"));    // Output: false
    }
}

/*
 * Problem: Anagram Checker Using Sorting
 *
 * Given two strings, determine whether one string is an anagram of the other.
 * An anagram is a word or phrase formed by rearranging the letters of another.
 * For example, "listen" is an anagram of "silent".
 *
 * Constraints:
 * - Both strings are assumed to be non-null.
 * - Both strings are assumed to contain only alphabetical characters (ignoring spaces, punctuation, etc.).
 * - The length of the strings is important. If the strings are of different lengths, they cannot be anagrams.
 *
 * Approach:
 *
 * The basic idea behind this approach is that if two strings are anagrams, they must contain the same characters in the same frequencies.
 * Therefore, if we sort both strings, their sorted versions should be identical if the strings are anagrams.
 *
 * **Steps**:
 * 1. **Check if the strings are of different lengths**: If they are not the same length, they cannot be anagrams, so return false immediately.
 * 2. **Sort both strings**: Sort both input strings alphabetically.
 * 3. **Compare sorted strings**: After sorting, if the strings are anagrams, their sorted versions should be identical. If they are identical, the strings are anagrams; otherwise, they are not.
 *
 * Sorting the strings will typically take **O(n log n)** time complexity, where `n` is the length of the strings.
 * After sorting, comparing the two strings takes **O(n)** time.
 *
 * **Time Complexity**: The time complexity of this approach is dominated by the sorting step, which is **O(n log n)**, where `n` is the length of the strings.
 *
 * **Space Complexity**: The space complexity of the solution depends on the sorting algorithm. If using an in-place sorting algorithm (like QuickSort), the space complexity is **O(1)**,
 * otherwise, it may be **O(n)** for algorithms like MergeSort that require additional space.
 *
 * Example:
 * Input: "listen", "silent"
 * - Both strings are of length 6, so we proceed with sorting the strings.
 * - Sorting "listen" gives "eilnst".
 * - Sorting "silent" gives "eilnst".
 * - Both sorted strings are identical, so the strings are anagrams.
 *
 * Time complexity:
 * - **O(n log n)**: Sorting the strings takes O(n log n) time.
 * Space complexity:
 * - **O(1)** or **O(n)**: Depending on the sorting algorithm used.
 */
