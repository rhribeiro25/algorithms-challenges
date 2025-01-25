package br.com.rhribeiro25;

import java.util.Arrays;

public class FractionalKnapsack {

    // Method to solve the Fractional Knapsack problem using Greedy Algorithm
    public static double getMaxValue(int capacity, FractionalKnapsackItem[] fractionalKnapsackItems) {
        // Sorting fractionalKnapsackItems based on the value-to-weight ratio in descending order
        Arrays.sort(fractionalKnapsackItems, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        double totalValue = 0.0; // To store the total value we can carry
        int currentWeight = 0; // To keep track of the weight we have currently in the knapsack

        for (FractionalKnapsackItem fractionalKnapsackItem : fractionalKnapsackItems) {
            if (currentWeight + fractionalKnapsackItem.weight <= capacity) {
                // If the fractionalKnapsackItem can fit in the knapsack, take it completely
                currentWeight += fractionalKnapsackItem.weight;
                totalValue += fractionalKnapsackItem.value;
            } else {
                // If the fractionalKnapsackItem can't fit completely, take the fractional part of it
                int remainingCapacity = capacity - currentWeight;
                totalValue += fractionalKnapsackItem.value * ((double) remainingCapacity / fractionalKnapsackItem.weight);
                break; // No need to continue, the knapsack is full
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        // Defining a set of fractionalKnapsackItems
        FractionalKnapsackItem[] fractionalKnapsackItems = {
                new FractionalKnapsackItem(60, 10),  // FractionalKnapsackItem 1: value = 60, weight = 10
                new FractionalKnapsackItem(100, 20), // FractionalKnapsackItem 2: value = 100, weight = 20
                new FractionalKnapsackItem(120, 30)  // FractionalKnapsackItem 3: value = 120, weight = 30
        };

        int knapsackCapacity = 50; // Maximum capacity of the knapsack

        // Calculating the maximum value that can be obtained with the given knapsack capacity
        double maxValue = getMaxValue(knapsackCapacity, fractionalKnapsackItems);

        // Printing the result
        System.out.println("Maximum value we can obtain: " + maxValue);
    }
}

/*
 * Problem: Fractional Knapsack
 *
 * The Fractional Knapsack problem is a variation of the Knapsack problem where
 * you can take fractions of an item rather than having to take the entire item.
 * The goal is to maximize the total value of the items placed in the knapsack,
 * given that each item has a weight and a value.
 *
 * **Objective**:
 * Given a knapsack with a weight capacity `W` and a list of `n` items, each with
 * a weight and value, determine the maximum value of items that can be carried in the knapsack.
 * You can take fractional amounts of an item, i.e., if you can't carry the entire item,
 * you can take a fraction of it.
 *
 * **Input**:
 * - `W`: The maximum weight capacity of the knapsack.
 * - A list of `n` items, where each item has a weight `wi` and value `vi`.
 *
 * **Output**:
 * - The maximum value that can be obtained by taking fractional items.
 *
 * **Greedy Approach**:
 * The Fractional Knapsack problem can be solved using a greedy approach by selecting
 * the items based on their value-to-weight ratio. The idea is to first choose items
 * that have the highest value per unit of weight (value/weight ratio). You continue
 * selecting items in descending order of this ratio until the knapsack is full or
 * the items run out.
 *
 * **Steps**:
 * 1. Compute the value-to-weight ratio for each item.
 * 2. Sort the items in descending order of their value-to-weight ratio.
 * 3. Select items in the sorted order. For each item:
 *    - If the item can fit completely in the knapsack, take it entirely.
 *    - If the item cannot fit completely, take the fractional part that can fit.
 * 4. Stop when the knapsack is full or all items have been considered.
 *
 * **Time Complexity**:
 * - Sorting the items takes **O(n log n)**, where `n` is the number of items.
 * - The process of selecting items takes **O(n)**.
 * - Overall time complexity: **O(n log n)**.
 *
 * **Space Complexity**:
 * - The space complexity is **O(n)** due to the storage of the items and their ratios.
 *
 * **Example**:
 * Input:
 * - W = 50 (maximum weight capacity)
 * - Items = [(60, 10), (100, 20), (120, 30)] where each tuple represents (value, weight)
 * Output:
 * - Maximum value that can be obtained: 240
 * Explanation:
 * The value-to-weight ratios are [6, 5, 4], so we take the item with ratio 6 (item 1),
 * then item 2, and a fraction of item 3 to fill the knapsack. The total value is 240.
 */
