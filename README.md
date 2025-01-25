# Anagram Checker Using Character Count

## Problem Description

The task is to determine whether two strings are anagrams of each other. An anagram is a word or phrase formed by rearranging the letters of another. For example, "listen" is an anagram of "silent".

### Constraints:
- Both strings are assumed to be non-null.
- Both strings contain only alphabetical characters (ignoring spaces, punctuation, etc.).
- The length of the strings is important. If the strings are of different lengths, they cannot be anagrams.

## Approach

The basic idea is to check if both strings have the same characters with the same frequency. If two strings are anagrams, they must have the same characters, and the characters must appear the same number of times in both strings.

### Steps:
1. **Check if the strings are of different lengths**: If they are not the same length, they cannot be anagrams, so return false immediately.
2. **Character Count**:
    - Use a data structure, such as a `HashMap`, to count the frequency of each character in the first string.
    - Traverse through the second string and decrement the count for each character.
    - If at the end, all counts are zero, the strings are anagrams; otherwise, they are not.

### Time and Space Complexity:
- **Time Complexity**: O(n) - We traverse each string once, where `n` is the length of the strings.
- **Space Complexity**: O(1) - We use a fixed-size map to store the counts of characters (constant space for the 26 letters in the alphabet).

## Explanation of the Code:
The program utilizes a `HashMap` to count the frequency of characters from the first string. It then checks if each character in the second string exists in the map and has the same frequency. If all characters match and their counts are balanced, the strings are anagrams.

### Example:
Input: `"listen"`, `"silent"`

- Both strings are of length 6, so we proceed with counting the characters.
- For `"listen"`, we count each character and store the count in a `HashMap`:
    - 'l' -> 1, 'i' -> 1, 's' -> 1, 't' -> 1, 'e' -> 1, 'n' -> 1
- For `"silent"`, we decrement the count for each character:
    - 's' -> 0, 'i' -> 0, 'l' -> 0, 'e' -> 0, 'n' -> 0, 't' -> 0
- All counts are zero, meaning the strings are anagrams.

### Performance:
- The program runs in **O(n)** time where `n` is the length of the input strings, as we only traverse each string once.
- The space complexity is **O(1)** since the `HashMap` used for counting characters has a fixed size (26 characters for the alphabet).

## Conclusion:
This solution provides an efficient way to check for anagrams by counting the frequency of characters. The algorithm works in linear time and uses constant space, making it well-suited for large input sizes.

# Anagram Checker Using Sorting

## Problem Description

The task is to determine whether two strings are anagrams of each other. An anagram is a word or phrase formed by rearranging the letters of another. For example, "listen" is an anagram of "silent".

### Constraints:
- Both strings are assumed to be non-null.
- Both strings contain only alphabetical characters (ignoring spaces, punctuation, etc.).
- The length of the strings is important. If the strings are of different lengths, they cannot be anagrams.

## Approach

The basic idea behind this approach is that if two strings are anagrams, they must contain the same characters in the same frequencies. Therefore, if we sort both strings, their sorted versions should be identical if the strings are anagrams.

### Steps:
1. **Check if the strings are of different lengths**: If they are not the same length, they cannot be anagrams, so return false immediately.
2. **Sort both strings**: Sort both input strings alphabetically.
3. **Compare sorted strings**: After sorting, if the strings are anagrams, their sorted versions should be identical. If they are identical, the strings are anagrams; otherwise, they are not.

### Time and Space Complexity:
- **Time Complexity**: The time complexity of this approach is dominated by the sorting step, which is **O(n log n)**, where `n` is the length of the strings. After sorting, comparing the two strings takes **O(n)** time.
- **Space Complexity**: The space complexity of the solution depends on the sorting algorithm. If using an in-place sorting algorithm (like QuickSort), the space complexity is **O(1)**, otherwise, it may be **O(n)** for algorithms like MergeSort that require additional space.

## Explanation of the Code:
The program uses the `Arrays.sort()` method to sort both input strings. After sorting, it compares the sorted versions of the strings. If the sorted strings are identical, then the original strings are anagrams.

### Example:
Input: `"listen"`, `"silent"`

- Both strings are of length 6, so we proceed with sorting the strings.
- Sorting "listen" gives `"eilnst"`.
- Sorting "silent" gives `"eilnst"`.
- Both sorted strings are identical, so the strings are anagrams.

### Performance:
- The program runs in **O(n log n)** time where `n` is the length of the input strings, as the sorting step dominates the time complexity.
- The space complexity is **O(1)** or **O(n)** depending on the sorting algorithm used.

## Conclusion:
This solution provides an efficient and simple way to check for anagrams by sorting the strings. The algorithm works in O(n log n) time due to the sorting step and is easy to understand and implement.


# Big O Analysis

## Problem Description

Big O notation is used to describe the performance or complexity of an algorithm in terms of time or space. It helps to analyze how the runtime or memory requirements grow as the input size increases.

In this example, we will examine the time complexity of different types of functions:

- **O(1) (constant time)**: The runtime is constant and does not depend on the input size.
- **O(n) (linear time)**: The runtime grows linearly with the input size.
- **O(n^2) (quadratic time)**: The runtime grows quadratically with the input size.

We will implement three functions with different time complexities and analyze how the runtime changes with the input size. Additionally, we will simulate a method to measure the time taken by these functions for different input sizes.

### Example Functions:
- **Function 1**: O(1) complexity
- **Function 2**: O(n) complexity
- **Function 3**: O(n^2) complexity

### Approach:
1. **O(1) - Constant Time Complexity**:
    - This function performs a constant-time operation that doesn't depend on the size of the input. For example, accessing an array element.

2. **O(n) - Linear Time Complexity**:
    - This function iterates over the input, performing an operation for each element. The time complexity grows linearly with the input size.

3. **O(n^2) - Quadratic Time Complexity**:
    - This function involves nested loops. The runtime grows quadratically with the input size, as the inner loop runs `n` times for each iteration of the outer loop.

### Performance Measurement:
The program uses `System.nanoTime()` to measure the time taken by each of the functions. This allows us to observe the difference in execution time for different time complexities.

### Time and Space Complexity:
- **O(1)**: Constant time complexity means the function's runtime remains the same regardless of the input size.
- **O(n)**: Linear time complexity means the function's runtime grows directly in proportion to the input size.
- **O(n^2)**: Quadratic time complexity indicates that the function's runtime grows quadratically with the input size.

### Example Analysis:

- **O(1) Example**:
    - This function accesses an element in an array. The time to access is constant, independent of the size of the array.

- **O(n) Example**:
    - This function prints each element in an array. As the array size increases, the execution time increases linearly.

- **O(n^2) Example**:
    - This function prints pairs of indices for a two-dimensional structure. The execution time grows quadratically because of the nested loops.

### Real-World Applications:
- **O(1)**: Operations like accessing an element in an array or performing a hash map lookup.
- **O(n)**: Functions that process each element in a collection, such as searching through a list.
- **O(n^2)**: Algorithms with nested iterations, such as bubble sort or matrix multiplication.

### Performance Note:
The performance timing will depend on the system's load and hardware. However, the key takeaway is the relationship between input size `n` and runtime, which illustrates the importance of Big O notation in analyzing algorithm efficiency.
