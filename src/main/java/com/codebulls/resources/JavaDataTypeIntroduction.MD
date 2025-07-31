
# Java Data Type Introduction

## Overview

This Java program demonstrates the use of **various data types and object types** in Java, along with a few **core concepts**, such as:

- Primitive vs. wrapper types
- Mutable vs. immutable types
- Collections (List, Map, Set)
- Basic object-oriented concepts (classes, inheritance)
- String operations
- Exception awareness (commented out example)

It serves as a primer for understanding how Java handles memory, immutability, type precision, and object manipulation.

---

## Key Concepts Demonstrated

### 1. **String & Character Handling**
```java
String str1 = "Hol trabajo en codebulls";
char character = str1.charAt(0);
````

* `String` is immutable.
* `charAt(0)` fetches the first character of the string.

---

### 2. **Primitive vs. Wrapper Classes**

```java
Short str2;  // Wrapper class (nullable)
short str3;  // Primitive type (default 0)

Integer num1 = 1000;
int num4 = 1000;

Long num2 = 1000L;
long num5 = 1000L;

Float num44 = 1000.0f;
float num6 = 1000.0f;

Boolean bool1 = true;
boolean bool2 = false;
```

* Wrapper types (e.g. `Integer`, `Boolean`) are objects and can be `null`.
* Primitive types (e.g. `int`, `boolean`) have default values and lower memory use.

---

### 3. **Precision with `BigDecimal`**

```java
BigDecimal num3 = new BigDecimal("1000.00");
num3.multiply(new BigDecimal("2.5"));
```

* Preferred for financial or precise calculations over `float` or `double`.

---

### 4. **Mutable Strings with `StringBuilder`**

```java
StringBuilder strBuilder = new StringBuilder("Hola, soy un StringBuilder");
strBuilder.append(" y puedo ser modificado.");
strBuilder.insert(5, "mundo ");
strBuilder.delete(0, 5);
```

* Unlike `String`, `StringBuilder` allows modification without creating a new object.

---

### 5. **Immutable vs. Mutable Lists**

```java
List<String> stringList = List.of("Hola", "mundo", "Codebulls", "Java", "Programación");
stringList.add("Nuevo Elemento"); // Throws UnsupportedOperationException
```

* `List.of()` creates immutable lists.
* Attempting to modify them will throw an exception.

---

### 6. **Iteration Techniques**

* **Classic For Loop**

```java
for (int i = 0; i < stringList.size(); i++) {  }
```

* **Enhanced For Loop**

```java
for (String str : stringList) {  }
```

* **Streams (Java 8+)**

```java
stringList.stream().forEach(str -> {  });
```

* All try to identify `"Codebulls"` in the list, but each `add()` throws an exception due to immutability.

---

### 7. **Instance Checking**

```java
var priemrPosicion = stringList.get(0);
if(priemrPosicion instanceof String) {  
    System.out.println("El primer elemento es un String");
}
```

* Confirms object types at runtime.

---

### 8. **Class Definitions: Client & Product**

```java
class Client {  }
class Product {  }
```

* Basic class modeling with fields and constructors.
* `Product` includes common attributes like `sku`, `price`, and `tags`.

---

### 9. **Map and Set Usage**

```java
Map<Integer, Client> stringIntegerMap = Map.of(1, new Client("Juan", "Perez"),
    2, new Client("Maria", "Gomez"),
    3, new Client("Carlos", "Lopez"));
Set<String> stringSet = Set.of("uno", "dos", "tres", "tres", "cinco");
```

* `Map.of` creates an immutable mapping of keys to client objects.
* `Set.of` eliminates duplicates (e.g. `"tres"` appears once).

---

### 10. **Inheritance and Overriding**

```java
class Figura {  }
class Circulo extends Figura {  }
```

* Demonstrates inheritance.
* `Circulo` overrides `getArea()` to calculate using `πr²`.

---

### 11. **Commented Try-Catch Example**

```java
try {
    int resultado = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());
}
```

* Included as a comment, shows how Java handles runtime exceptions (like divide by zero).

---

## Summary

This code introduces:

* Core Java data types and object types
* Memory characteristics (primitive vs wrapper)
* Collections and immutability
* Basic OOP principles
* Java 5–8 features including Streams and `var`

It is a practical reference for understanding Java fundamentals, both for beginners and intermediate learners.

---