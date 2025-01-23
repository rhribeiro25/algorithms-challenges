package br.com.rhribeiro25;

import java.util.Arrays;

public class StringAnagrams {

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
