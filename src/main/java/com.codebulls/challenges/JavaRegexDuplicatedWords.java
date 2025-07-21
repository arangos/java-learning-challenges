package com.codebulls.challenges;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class JavaRegexDuplicatedWords {
    public static void main(String[] args) {
        String regex = "(?i)\\b([A-Za-z]+)\\b\\s+\\1\\b";
        Pattern pattern = Pattern.compile(regex, CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.valueOf(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();
            Matcher m = pattern.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(regex, "$1");
            }

            // Prints the modified sentence.
            System.out.println(input);
        }

        in.close();
    }
}
