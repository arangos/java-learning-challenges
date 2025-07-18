package com.codebulls.challenges;

import java.util.Scanner;

public class EndOfFileChallenge {

    /*
        Sample Input :
        Hello world
        I am a file
        Read me until end-of-file.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 1;
        while(scanner.hasNext()){
            System.out.println(counter + " " +scanner.nextLine());
            counter++;
        }
        scanner.close();
    }
}
