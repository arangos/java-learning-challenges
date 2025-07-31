package com.codebulls.challenges;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacter {

    public static void main(String[] args) {
        String inputa = " ";
        System.out.println("Length of the longest substring without repeating characters: " + lengthOfLongestSubstring(inputa));
        String inputb = "bbbbba";
        System.out.println("Length of the longest substring without repeating characters: " + lengthOfLongestSubstring(inputb));
        String inputc = "pwwkew";
        System.out.println("Length of the longest substring without repeating characters: " + lengthOfLongestSubstring(inputc));
        String inputd = "abcabcbb";
        System.out.println("Length of the longest substring without repeating characters: " + lengthOfLongestSubstring(inputd));

    }

    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int[] charIndexes = new int[256]; // ASCII character set
        Arrays.fill(charIndexes, -1); // Initialize all character indexes to -1, indicating they haven't been seen yet
        int start = 0; // Start length of the current substring
        int best = 0; // Best length found so far
        for (int end = 0; end < length; end++) {
            char character = s.charAt(end);
            start = Math.max(start, charIndexes[character] + 1); // Update start index if the character was seen before with the index of the last occurrence
            best = Math.max(best, end - start + 1); // Calculate the length of the current substring
            charIndexes[character] = end; // Update the last seen index of the character thi will be used to check for repeating characters
        }
        return best; // Return the length of the longest substring found
    }
}
