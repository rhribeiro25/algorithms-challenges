package br.com.rhribeiro25;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentElement {
    /**
     * Finds the most frequently occurring element in the given array.
     * @param array The input array of integers.
     * @return The most frequent element.
     */
    public static int mostFrequent(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxCount = 0, mostFrequent = -1;

        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

            if (frequencyMap.get(num) > maxCount) {
                maxCount = frequencyMap.get(num);
                mostFrequent = num;
            }
        }

        return mostFrequent;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 3, 3, 1, 4};

        System.out.println("Most Frequent Element: " + mostFrequent(array));
    }
}

/*
 * Problem: Most Frequent Element
 *
 * **Objective**:
 * The task is to find the element that appears the most frequently in a given collection (like an array or list).
 * If there are multiple elements with the same highest frequency, return any one of them.
 *
 * **Problem Definition**:
 * Given an array `arr` of integers, you need to identify the element that appears the most frequently.
 * The output should be the element with the maximum frequency.
 *
 * **Approach**:
 * - A direct approach would be to iterate through the array, count the frequency of each element, and
 *   return the element with the highest frequency.
 * - We can use a hash map (or dictionary) to store the count of each element as we iterate through the array.
 * - Once the frequency of all elements is known, we can simply traverse the map to find the element with the maximum count.
 *
 * **Steps**:
 * 1. Iterate through the array and store the frequency of each element in a hash map.
 * 2. Traverse the hash map to find the element with the maximum frequency.
 *
 * **Time Complexity**:
 * - The time complexity is **O(n)**, where `n` is the number of elements in the array. This is because we only
 *   iterate through the array once to count the frequencies, and then we iterate through the hash map to
 *   find the most frequent element, which is also done in **O(n)** time in the worst case.
 *
 * **Space Complexity**:
 * - The space complexity is **O(n)** because we are using a hash map to store the frequency of each element
 *   and in the worst case, each element in the array could be unique.
 *
 * **Example**:
 * Given the array:
 * arr = [1, 3, 2, 3, 2, 1, 3]
 * The most frequent element is 3, as it appears 3 times.
 */
