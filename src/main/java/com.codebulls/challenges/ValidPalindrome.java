package com.codebulls.challenges;

public class ValidPalindrome {

    public static void main(String[] args) {
        String input1 = "A man, a plan, a canal: Panama";
        System.out.println(input1 + " Is valid palindrome: " + isValidPalindrome(input1));
        System.out.println(input1 + " Is valid palindrome easy way: " + isValidPalindromeEasy(input1));
        String s1 = "geeks";
        System.out.println(s1 +" Is valid palindrome: " + isValidPalindrome(s1));
        System.out.println(s1 +" Is valid palindrome easy way: " + isValidPalindromeEasy(s1));
        String s2 = "Racecar";
        System.out.println(s2 + " Is valid palindrome: " + isValidPalindrome(s2));
        System.out.println(s2 + " Is valid palindrome easy way: " + isValidPalindromeEasy(s2));
    }

    public static boolean isValidPalindrome(String text){
        if(text != null && !text.isEmpty()){
            String cleanedText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // Remove non-alphanumeric characters and convert to lowercase
            int left = 0;
            int right = cleanedText.length() - 1;

            while (left < right) {
                if (cleanedText.charAt(left) != cleanedText.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }


    public static boolean isValidPalindromeEasy(String text){
        boolean isPalindrome = false;
        if(text != null && !text.isEmpty()){
            String cleanedText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // Remove non-alphanumeric characters and convert to lowercase
            String reversedText = new StringBuilder(cleanedText).reverse().toString();
            if(cleanedText.equals(reversedText)){
                isPalindrome = true;
            }
        }
        return isPalindrome;
    }
}
