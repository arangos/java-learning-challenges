package com.codebulls.challenges;

import java.io.*;
import java.util.regex.Pattern;

public class JavaRegex {

    /*
        Sample Input
        000.12.12.034
        121.234.12.12
        23.45.12.56
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        bufferedReader.lines()
                .forEach(line -> {
                    String regex =
                            "^((25[0-5]|2[0-4]\\d|[01]?\\d?\\d)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)$"; //

                    if (Pattern.matches(regex, line)) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }

                });
        bufferedReader.close();
    }
}
