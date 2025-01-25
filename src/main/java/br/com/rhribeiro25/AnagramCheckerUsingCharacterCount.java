package br.com.rhribeiro25;

import java.util.HashMap;

public class AnagramCheckerUsingCharacterCount {

    // Method to check if two strings are anagrams using frequency count
    public static boolean areAnagrams(String s1, String s2) {
        // If the strings have different lengths, they cannot be anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Create a map to store the frequency of characters in s1
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        // Count the frequency of each character in s1
        for (char c : s1.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Check if each character in s2 has the same frequency in s1
        for (char c : s2.toCharArray()) {
            if (!charCountMap.containsKey(c)) {
                return false; // If s2 has a character not in s1, return false
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
            if (charCountMap.get(c) < 0) {
                return false; // If the frequency goes below 0, return false
            }
        }

        // If all characters matched and the frequencies are balanced, return true
        return true;
    }

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        // Call the function to check if they are anagrams
        boolean result = areAnagrams(s1, s2);

        // Print the result
        System.out.println("Are the strings anagrams? " + result);
    }
}

/*
 * Problem: Anagram Checker Using Character Count
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
 * The basic idea is to check if both strings have the same characters in the same frequency.
 * If two strings are anagrams, they must have the same characters, and the characters must appear the same number of times in both strings.
 *
 * **Steps**:
 * 1. **Check if the strings are of different lengths**: If they are not the same length, they cannot be anagrams, so return false immediately.
 * 2. **Character count**: Use an integer array (or hashmap) to count the frequency of each character in the first string.
 *    - Traverse through the first string and increment the count for each character.
 *    - Then, traverse through the second string and decrement the count for each character.
 *    - If at the end, all counts are zero, the strings are anagrams; otherwise, they are not.
 *
 * This approach ensures that we only need to traverse each string once, making the time complexity of the algorithm **O(n)**, where `n` is the length of the strings.
 * The space complexity is **O(1)** because we are using an array of fixed size (26) to store the counts, which is constant regardless of the input size.
 *
 * Example:
 * Input: "listen", "silent"
 * - Both strings are of length 6, so we proceed with counting the characters.
 * - For "listen", we count each character and store the count in an array:
 *     'l' -> 1, 'i' -> 1, 's' -> 1, 't' -> 1, 'e' -> 1, 'n' -> 1
 * - For "silent", we decrement the count for each character:
 *     's' -> 0, 'i' -> 0, 'l' -> 0, 'e' -> 0, 'n' -> 0, 't' -> 0
 * - All counts are zero, meaning the strings are anagrams.
 *
 * Time complexity:
 * - **O(n)**: We traverse each string once.
 * Space complexity:
 * - **O(1)**: We use a fixed-size array to store character counts (constant space for 26 letters).
 */
