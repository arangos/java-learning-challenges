package com.codebulls.challenges;

public class StringPool {

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        String str4 = "Hello";

        // Comparing string literals
        System.out.println("str1 == str2: " + (str1 == str2)); // true, both refer to the same string literal in the pool
        System.out.println("str1 == str3: " + (str1 == str3)); // false, str3 is a new object in heap memory
        System.out.println("str1 == str4: " + (str1 == str4)); // true, both refer to the same string literal in the pool
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true, equals() checks the content of the strings
        System.out.println("str1.equals(str4): " + str1.equals(str4)); // true, equals() checks the content of the strings

        // Using intern() method
        String str5 = str3.intern();
        System.out.println("str1 == str5: " + (str1 == str5)); // true, str5 refers to the string literal in the pool
    }
}
