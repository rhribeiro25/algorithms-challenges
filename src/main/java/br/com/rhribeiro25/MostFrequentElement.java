package br.com.rhribeiro25;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentElement {
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
