Here is a well-structured `README.md` file to document your `ReverseInt` Java challenge, covering both the performant and string-based solutions:

---

```markdown
# Reverse Integer Problem

This challenge is part of the `com.codebulls.challenges` package. It demonstrates how to reverse a signed 32-bit integer in Java and handle overflow conditions correctly.

---

## 🧠 Problem Statement

Given a signed 32-bit integer `x`, return the number reversed. If reversing `x` causes the value to go outside the signed 32-bit integer range (`[-2³¹, 2³¹ - 1]`), return `0`.

### Example:
```

Input:  x = -123
Output: -321

Input:  x = 1534236469
Output: 0 (since reversed value exceeds Integer.MAX\_VALUE)

````

---

## 📦 Package

```java
package com.codebulls.challenges;
````

---

## 🚀 Implementations

### 1. `reversePerformance(int x)` – Efficient Integer Reversal

This method reverses the integer using mathematical operations without converting the number to a string.

#### 🔧 How it works:

* Repeatedly extract the last digit using modulus.
* Append it to the reversed number using multiplication and addition.
* Use a `long` to detect overflow before casting to `int`.

#### ✅ Pros:

* No string conversions
* Faster and more memory-efficient
* Properly handles edge cases including overflow

```java
public static int reversePerformance(int x) {
    long reversed = 0;
    while (x != 0) {
        int digit = x % 10;
        reversed = reversed * 10 + digit;
        x /= 10;
    }
    if (reversed < Integer.MIN_VALUE || reversed > Integer.MAX_VALUE) {
        return 0;
    }
    return (int) reversed;
}
```

---

### 2. `reverse(int x)` – String-Based Reversal

This alternative approach converts the absolute value of the integer to a string, reverses it, and parses it back to a number.

#### ✅ Pros:

* Readable and simple to understand
* Quick prototyping method

#### ❌ Cons:

* Less performant due to string manipulation and parsing
* Still requires overflow checks

```java
public static int reverse(int x) {
    if (x <= Integer.MIN_VALUE || x >= Integer.MAX_VALUE) {
        return 0;
    }
    boolean isNegative = x < 0;
    x = Math.abs(x);
    String reversedString = new StringBuilder(String.valueOf(x)).reverse().toString();
    long reversed = Long.parseLong(reversedString);
    if (reversed <= Integer.MIN_VALUE || reversed >= Integer.MAX_VALUE) {
        return 0;
    }
    if (isNegative) {
        reversed = -reversed;
    }
    return (int) reversed;
}
```

---

## 🧪 Example Outputs

```java
Input: -2147483648 → Output: 0
Input: -123         → Output: -321
Input: 1534236469   → Output: 0
Input: 0            → Output: 0
```

---

## 👨‍💻 Author

* Challenge & Solution by `@codebulls`

---

## ✅ To Run

```bash
javac ReverseInt.java
java com.codebulls.challenges.ReverseInt
```

---

## 📌 Notes

* Always validate for overflow using `long` before casting back to `int`.
* Prefer `reversePerformance` for production-grade solutions due to better performance characteristics.

```

---

Let me know if you’d like to combine this with the previous challenge doc or add visuals or test scaffolding (like JUnit).
```
