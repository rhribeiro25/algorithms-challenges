package br.com.rhribeiro25;

import java.util.HashSet;

public class LongestSubstring {

    // Method to find the length of the longest substring without repeating characters
    public static int lengthOfLongestSubstring(String s) {
        // A HashSet to store characters in the current window
        HashSet<Character> charSet = new HashSet<>();
        int maxLength = 0; // To store the length of the longest substring
        int left = 0; // Left pointer for the sliding window

        // Iterate over the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            // If the character is already in the set, shrink the window from the left
            while (charSet.contains(s.charAt(right))) {
                // Remove the leftmost character and move the left pointer to the right
                charSet.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the set
            charSet.add(s.charAt(right));

            // Update the maximum length of the substring
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength; // Return the length of the longest substring
    }

    public static void main(String[] args) {
        String input = "abcabcbb"; // Example string
        int result = lengthOfLongestSubstring(input); // Call the function to get the result
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }
}

/*
 * Problem: Solving the Longest Substring Without Repeating Characters
 *
 * **Objective**:
 * The goal of this problem is to find the length of the **longest substring** of a given string
 * that does not contain any repeating characters.
 *
 * **Problem Definition**:
 * Given a string `s`, the task is to determine the length of the longest substring
 * that contains no duplicate characters. The substring is contiguous, meaning characters must
 * appear in the original order, and there cannot be any characters that repeat within that substring.
 *
 * **Sliding Window Approach**:
 * The optimal solution uses a **sliding window** approach combined with a hash map (or hash set)
 * to efficiently track the characters in the current window (substring) as we iterate through the string.
 *
 * The idea is to maintain a "window" (a range of indices) that holds a substring without repeating characters.
 * As we traverse the string, we extend the window by adding characters to the right. If a character
 * repeats within the window, we contract the window from the left until the repeated character is removed.
 * The length of the window at each step gives us the current length of a substring without repeating characters.
 *
 * **Steps**:
 * 1. Initialize a hash set to keep track of characters in the current window.
 * 2. Use two pointers (`start` and `end`) to represent the left and right bounds of the window.
 * 3. As `end` pointer moves through the string, if the character at `s[end]` is not in the set,
 *    add it to the set and update the maximum length.
 * 4. If the character is already in the set, move the `start` pointer to the right of the previous
 *    occurrence of the character, effectively shrinking the window.
 * 5. Return the maximum length of the substring found during this process.
 *
 * **Time Complexity**:
 * - The time complexity is **O(n)**, where `n` is the length of the input string `s`.
 *   Both the `start` and `end` pointers traverse the string only once, and each character is added and removed
 *   from the hash set at most once.
 *
 * **Space Complexity**:
 * - The space complexity is **O(k)**, where `k` is the size of the character set (typically 256 for extended ASCII
 *   characters, or 128 for basic ASCII characters). In the worst case, the set could store all unique characters
 *   in the string, so the space complexity is proportional to the number of distinct characters in the string.
 *
 * **Example**:
 * Given the string:
 * s = "abcabcbb"
 * The longest substring without repeating characters is "abc" with a length of 3.
 */
