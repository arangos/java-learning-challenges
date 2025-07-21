package com.codebulls.challenges;

import java.io.*;
import java.util.regex.Pattern;

public class JavaRegex {

    /*
        Sample Input to test if IP adress are ok
        000.12.12.034
        121.234.12.12
        23.45.12.56
     */

    /*
    How REGEX it works

    25[0-5] → matches 250–255

    2[0-4][0-9] → matches 200–249

    [01]?[0-9]?[0-9] → matches 0–199 in 1–3 digits (so “0”, “00”, “000” … up through “199”)

    The (...)\. group is repeated three times for the first three octets, then the same alternation is applied to the fourth octet, anchored at start (^) and end ($). This guarantees each segment is 0–255 and no longer than three digits.
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
