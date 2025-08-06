# Java Stream API – Comprehensive Guide

## Overview

This Java class demonstrates a wide variety of **Java Stream API** features and functional programming patterns. It provides practical examples using:

- Intermediate and terminal operations
- Transformation with `map` and flattening with `flatMap`
- Stream filtering, reduction, grouping, and partitioning
- Use of `Collectors`, `Optional`, and parallel processing

It is a comprehensive reference for modern Java development using functional streams.

---

## Key Concepts

### Stream Operations

- **Intermediate operations**: `map`, `filter`, `distinct`, `sorted`, `flatMap`, `peek`
- **Terminal operations**: `forEach`, `collect`, `count`, `reduce`, `anyMatch`, `allMatch`, `noneMatch`, `findFirst`, `findAny`

Intermediate operations are **lazy** and only execute when a terminal operation is called.

---

## Examples in Action

### Uppercase Transformation
```java
Arrays.stream(words)
      .map(String::toUpperCase)
      .forEach(System.out::println);
````

* Uses `map` to convert each word to uppercase.

---

### Filtering Words by Length

```java
long count = Arrays.stream(words)
                   .filter(word -> word.length() > 5)
                   .count();
```

* Counts how many words are longer than 5 characters.

---

### Removing Duplicates

```java
Set<String> noDuplicates = Arrays.stream(words).collect(Collectors.toSet());
```

* Collects unique words using a `Set`.

---

### Joining Strings

```java
String joined = Arrays.stream(words)
                      .distinct()
                      .collect(Collectors.joining(", "));
```

* Joins unique words with commas.

---

### Finding the Longest Word

```java
String longest = Arrays.stream(words)
                       .max(Comparator.comparingInt(String::length))
                       .orElse("No words available");
```

---

### Sorting Words by Length

```java
Arrays.stream(words)
      .sorted(Comparator.comparingInt(String::length))
      .forEach(System.out::println);
```

---

### `map` vs. `flatMap`

```java
String[][] nestedWords = {{"codebulls", "epam"}, {"mccusa", "jaltech"}};
Arrays.stream(nestedWords)
      .flatMap(Arrays::stream)
      .map(String::toUpperCase)
      .forEach(System.out::println);
```

* `flatMap` flattens nested arrays.

---

### Reducing Streams

**Concatenating:**

```java
String concatenated = Arrays.stream(words)
                            .reduce("", (a, b) -> a + b + " ");
```

**Summing lengths:**

```java
int totalLength = Arrays.stream(words)
                        .reduce(0, (sum, word) -> sum + word.length(), Integer::sum);
```

---

### Matching Operations

```java
boolean hasBanana = Arrays.stream(words).anyMatch("banana"::equals);
boolean allLongerThanTwo = Arrays.stream(words).allMatch(w -> w.length() > 2);
boolean noOrange = Arrays.stream(words).noneMatch("orange"::equals);
```

---

### Finding Elements

```java
Optional<String> firstLong = Arrays.stream(words)
                                   .filter(w -> w.length() > 7)
                                   .findFirst();

Optional<String> anyStartsWithB = Arrays.stream(words)
                                        .filter(w -> w.startsWith("b"))
                                        .findAny();
```

---

### Skipping and Limiting

```java
Arrays.stream(words)
      .sorted()
      .skip(2)
      .limit(5)
      .forEach(System.out::println);
```

---

### Debugging with `peek`

```java
int sum = Arrays.stream(words)
                .peek(w -> System.out.println("before filter: " + w))
                .filter(w -> w.length() > 4)
                .peek(w -> System.out.println("after filter: " + w))
                .mapToInt(String::length)
                .sum();
```

---

### Summary Statistics

```java
IntSummaryStatistics stats = Arrays.stream(words)
                                   .mapToInt(String::length)
                                   .summaryStatistics();
```

* Provides count, min, max, average, and sum.

---

### Working with Ranges and Randoms

**Squares:**

```java
IntStream.rangeClosed(1, 5).map(i -> i * i).forEach(System.out::println);
```

**Random Numbers:**

```java
Stream.generate(Math::random).limit(3).forEach(System.out::println);
```

---

### Grouping and Partitioning

**Group by length:**

```java
Map<Integer, List<String>> grouped = Arrays.stream(words)
                                           .collect(Collectors.groupingBy(String::length));
```

**Partition by condition:**

```java
Map<Boolean, List<String>> partitioned = Arrays.stream(words)
                                               .collect(Collectors.partitioningBy(w -> w.contains("e")));
```

---

### Mapping to Key-Value

```java
Map<String, Integer> toMap = Arrays.stream(words)
                                   .distinct()
                                   .collect(Collectors.toMap(w -> w, String::length));
```

---

### Flattening Nested Lists

```java
List<List<String>> listOfLists = List.of(
    List.of("apple", "banana"),
    List.of("cherry", "date")
);

listOfLists.stream()
           .flatMap(List::stream)
           .distinct()
           .sorted()
           .forEach(System.out::println);
```

---

### Custom Collectors

**Joining with semicolon:**

```java
String customJoined = Arrays.stream(words)
                            .collect(Collectors.joining("; ", "Words: ", "."));
```

**Joining with custom `Collector`:**

```java
Collector<String, StringBuilder, String> joinWithBar =
    Collector.of(StringBuilder::new,
                 (sb, w) -> sb.append(w).append("|"),
                 StringBuilder::append,
                 StringBuilder::toString);

String barJoined = Arrays.stream(words).collect(joinWithBar);
```

---

### Parallel Streams

```java
long t0 = System.nanoTime();
long count = Arrays.stream(words)
                   .parallel()
                   .filter(w -> w.length() > 5)
                   .count();
System.out.println("Parallel count: " + count);
```

---

### Stream Builder

```java
Stream<String> stream = Stream.<String>builder()
                              .add("foo")
                              .add("bar")
                              .build();
```

---

## Summary

This class offers a **practical and exhaustive demonstration** of Java 8+ Stream capabilities, showcasing:

* How to transform, filter, and reduce collections
* When and why to use different stream operations
* Real-world scenarios like joining, grouping, partitioning, and debugging
* Use of collectors, lambdas, and functional-style operations
* Efficient data processing using parallel streams and lazy evaluation

---

## Complexity Summary

| Operation       | Time Complexity    | Notes                               |
| --------------- | ------------------ | ----------------------------------- |
| map/filter      | O(n)               | Traverses each element once         |
| collect/join    | O(n)               | Accumulates into a final structure  |
| distinct        | O(n) to O(n log n) | Depends on hash table or sort       |
| sort            | O(n log n)         | Uses TimSort (optimized merge sort) |
| flatMap         | Varies             | Depends on nested structure size    |
| parallel stream | Depends on cores   | May reduce wall-clock time          |

---

## Conclusion

This class serves as a **reference and teaching aid** for developers learning or mastering the Java Stream API. It demonstrates the power and flexibility of functional programming in Java, encouraging clean, concise, and expressive code.

---

```

Let me know if you’d like a downloadable `.md` file, a Spanish version, or visual examples (like diagrams) to go along with it.
```
