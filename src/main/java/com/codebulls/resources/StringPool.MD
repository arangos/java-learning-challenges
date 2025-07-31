# Java String Pool Explained

## Overview

This Java class demonstrates the behavior of **Java's String Pool** and how string objects are handled in memory. It covers:

- String literals vs. `new String()`
- Reference comparison using `==`
- The effect of using the `.intern()` method

This is a foundational topic for understanding **memory management** and **object referencing** in Java.

---

## Code Summary

### Java Class: `StringPool`

```java
public class StringPool {

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        String str4 = "Hello";

        // Comparing string literals
        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1 == str3: " + (str1 == str3));
        System.out.println("str1 == str4: " + (str1 == str4));

        // Using intern() method
        String str5 = str3.intern();
        System.out.println("str1 == str5: " + (str1 == str5));
    }
}
````

---

## Key Concepts

### 1. String Pool

* The **String Pool** is a special memory region where Java stores **string literals**.
* When you write:

  ```java
  String str1 = "Hello";
  String str2 = "Hello";
  ```

  both `str1` and `str2` point to the **same object** in the String Pool.

---

### 2. `new String()` vs. String Literals

```java
String str3 = new String("Hello");
```

* This creates a **new object in heap memory**, **not** the pool.
* Even though the value is the same, `str3` refers to a different object than `str1` or `str2`.

---

### 3. Reference Comparison (`==`)

```java
System.out.println("str1 == str2: " + (str1 == str2)); // true
System.out.println("str1 == str3: " + (str1 == str3)); // false
System.out.println("str1 == str4: " + (str1 == str4)); // true
```

* `==` compares **object references**, not content.
* `str1 == str2` and `str1 == str4` are `true` because they're the **same literal** in the pool.
* `str1 == str3` is `false` because `str3` is a new heap object.

---

### 4. `.intern()` Method

```java
String str5 = str3.intern();
System.out.println("str1 == str5: " + (str1 == str5)); // true
```

* The `intern()` method checks if a string with the same value exists in the **pool**.
* If it exists, it returns the reference from the pool.
* So `str5` now points to the same object as `str1` and `str2`.

---

## Output Summary

```
str1 == str2: true
str1 == str3: false
str1 == str4: true
str1 == str5: true
```

This clearly demonstrates:

* How Java optimizes memory by reusing string literals.
* How using `new` creates distinct objects.
* How `intern()` bridges between heap and pool references.

---

## Practical Implications

* Avoid `new String("...")` unless necessary — it's less memory efficient.
* Use `equals()` to compare **string content** instead of `==`.
* Use `intern()` carefully when optimizing for memory with many duplicate strings.

---

## Conclusion

The `StringPool` class is a minimal but powerful demonstration of:

* **Java's String interning behavior**
* **Heap vs. pool memory for strings**
* **Reference vs. value comparison**

Understanding this concept is critical when working with large-scale Java applications where memory efficiency and object identity matter.

---
