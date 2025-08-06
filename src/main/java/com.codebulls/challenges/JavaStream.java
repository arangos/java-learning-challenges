package com.codebulls.challenges;

import java.util.*;
import java.util.stream.*;

public class JavaStream {

    /*
        Java Streams intermediate operations vs terminal operations

        Intermediate operations are operations that return a new stream, allowing for further processing.
        Examples include map, filter, and sorted.
        Terminal operations are operations that produce a result or a side effect, such as forEach
        and collect. They trigger the processing of the stream pipeline.
        For example, in the code above, map and filter are intermediate operations,
        while forEach and collect are terminal operations.
        This means that intermediate operations are lazy and do not execute until a terminal operation is called
        which triggers the processing of the stream pipeline.
        This allows for efficient processing of large datasets, as only the necessary operations are executed.
        */

    public static void main(String[] args) {
        // Example usage of Java Streams
        String[] words = {"apple", "banana", "cherry", "banana", "date", "elderberry", "raspberry", "kiwi", "lemon", "mango"};

        // Print all words in uppercase
        System.out.println("Words in uppercase:");
        Arrays.stream(words)
              .map(String::toUpperCase)
              .forEach(System.out::println);

        // Count words with more than 5 characters
        long count = Arrays.stream(words)
                           .filter(word -> word.length() > 5)
                           .count();
        System.out.println("Number of words with more than 5 characters: " + count);

        //remove duplicates and print unique words
        var noDuplicates = Arrays.stream(words)
                .collect(Collectors.toSet());
        noDuplicates.forEach(word -> System.out.println("Unique word: " + word));

        // Join words with a comma
        String joinedWords = Arrays.stream(words)
                .distinct() // Remove duplicates
                .collect(Collectors.joining(", "));
        System.out.println("Joined words: " + joinedWords);

        // Find the longest word
        String longestWord = Arrays.stream(words)
                .max(Comparator.comparingInt(String::length))
                .orElse("No words available");
        System.out.println("Longest word: " + longestWord);

        // Sort words by length and print them
        System.out.println("Words sorted by length:");
        Arrays.stream(words)
              .sorted(Comparator.comparingInt(String::length))
              .forEach(System.out::println);

        //diffrence between map and flatMap
        //map applies a function to each element of the stream and returns a new stream with the
        //results, while flatMap applies a function that returns a stream for each element and
        //flattens the results into a single stream.
        String[][] nestedWords = {{"codebulls", "epam"}, {"mccusa", "jaltech"}, {"eteka", "nogales"}};
        System.out.println("Flattened words:");
        Arrays.stream(nestedWords)
              .flatMap(Arrays::stream) // Flatten the nested arrays into a single stream
              .map(String::toUpperCase) // Convert each word to uppercase
              .forEach(System.out::println);

        // Example of using reduce to concatenate words
        String concatenatedWords = Arrays.stream(words)
                .reduce("", (partialString, word) -> partialString + word + " ");
        System.out.println("Concatenated words: " + concatenatedWords.trim());


        // Example of using reduce to find the sum of lengths of all words
        int totalLength = Arrays.stream(words)
                .reduce(0, (sum, word) -> sum + word.length(), Integer::sum);
        System.out.println("Total length of all words: " + totalLength);

        // Example of using anyMatch to check if any word is "banana"
        boolean hasBanana = Arrays.stream(words)
                .anyMatch("banana"::equals);
        System.out.println("Contains 'banana': " + hasBanana);

        // Example of using allMatch to check if all words are longer than 2 characters
        boolean allLongerThanTwo = Arrays.stream(words)
                .allMatch(word -> word.length() > 2);
        System.out.println("All words longer than 2 characters: " + allLongerThanTwo);

        // Example of using noneMatch to check if no word is "orange"
        boolean noOrange = Arrays.stream(words)
                .noneMatch("orange"::equals);
        System.out.println("No word is 'orange': " + noOrange);

        // Example of using findFirst to get the first word longer than 7 characters
        Optional<String> firstLong = Arrays.stream(words)
                .filter(w -> w.length() > 7)
                .findFirst();
        System.out.println("First word longer than 7 characters: " + firstLong.orElse("No such word"));

        // Example of using findAny to get any word that starts with 'b'
        Optional<String> anyWordStartingWithB = Arrays.stream(words)
                .filter(w -> w.startsWith("b"))
                .findAny();
        System.out.println("Any word starting with 'b': " + anyWordStartingWithB.orElse("No such word"));

        // Example of using skip and limit to get a subset of words
        System.out.println("Words after skipping first two and limiting to five:");
        Arrays.stream(words)
                .sorted()
                .skip(2)      // drop first two
                .limit(5)     // take next five
                .forEach(System.out::println);

        // Example of using peek to debug a stream operation
        System.out.println("Words with length greater than 4:");
        int sum = Arrays.stream(words)
                .peek(w -> System.out.println("before filter: " + w))
                .filter(w -> w.length() > 4)
                .peek(w -> System.out.println("after filter: " + w))
                .mapToInt(String::length)
                .sum();
        System.out.println("Total length of words greater than 4 characters: " + sum);


        // Example of using summaryStatistics to get statistics about word lengths
        IntSummaryStatistics stats = Arrays.stream(words)
                .mapToInt(String::length)
                .summaryStatistics();
        System.out.println("Count: " + stats.getCount());
        System.out.println("Max length: " + stats.getMax());
        System.out.println("Min length: " + stats.getMin());
        System.out.println("Average length: " + stats.getAverage());
        System.out.println("Sum of lengths: " + stats.getSum());


        // Example of using IntStream to generate a stream of integers
        System.out.println("Squares of numbers from 1 to 5:");
        IntStream.rangeClosed(1, 5)      // 1,2,3,4,5
                .map(i -> i * i)
                .forEach(System.out::println);

        // Example of generating an infinite stream of random numbers
        System.out.println("Random numbers:");
        Stream.generate(Math::random)    // infinite stream
                .limit(3)
                .forEach(System.out::println);

        // Example of using collect to group words by length
        System.out.println("Words grouped by length:");
        Map<Integer, List<String>> byLength =
                Arrays.stream(words)
                        .collect(Collectors.groupingBy(String::length));
        byLength.forEach((length, wordList) -> {
            System.out.println("Length " + length + ": " + wordList);
        });

        // Example of using partitioningBy to partition words based on a condition
        System.out.println("Words partitioned by containing 'e':");
        Map<Boolean, List<String>> partitioned =
                Arrays.stream(words)
                        .collect(Collectors.partitioningBy(w -> w.contains("e")));
        partitioned.forEach((containsE, wordList) -> {
            System.out.println("Contains 'e': " + containsE + " -> " + wordList);
        });

        // Example of using toMap to create a map from words to their lengths
        System.out.println("Words mapped to their lengths:");
        Map<String, Integer> toMap =
                Arrays.stream(words)
                        .distinct()
                        .collect(Collectors.toMap(w -> w, String::length));
        toMap.forEach((word, length) -> System.out.println("Word: " + word + ", Length: " + length));

        // Example of using flatMap to flatten a stream of lists
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("cherry", "date"),
                Arrays.asList("elderberry", "fig")
        );

        System.out.println("Flattened list of lists:");
        listOfLists.stream()
                .flatMap(List::stream) // Flatten the lists into a single stream
                .distinct() // Remove duplicates
                .sorted() // Sort the words
                .forEach(System.out::println);

        // Example of using collect with a custom collector
        System.out.println("Custom collector to join words with a semicolon:");
        String customJoined = Arrays.stream(words)
                .collect(Collectors.joining("; ", "Words: ", "."));
        System.out.println(customJoined);

        // Example of using a custom collector to join words with a bar
        System.out.println("Custom collector to join words with a bar:");
        Collector<String, StringBuilder, String> joinWithBar =
                Collector.of(StringBuilder::new,
                        (sb, w) -> sb.append(w).append("|"),
                        StringBuilder::append,
                        StringBuilder::toString);
        String barJoined = Arrays.stream(words)
                .collect(joinWithBar);
        System.out.println(barJoined);

        long t0 = System.nanoTime();
        long cnt = Arrays.stream(words)
                .parallel()
                .filter(w -> w.length() > 5)
                .count();
        System.out.println("Parallel count: " + cnt +
                ", took " + (System.nanoTime()-t0)/1e6 + " ms");

        // Example of creating a stream using Stream.builder()
        System.out.println("Creating a stream using Stream.builder():");
        Stream<String> stream = Stream.<String>builder()
                .add("foo")
                .add("bar")
                .build();
        stream.forEach(System.out::println);

    }
}
