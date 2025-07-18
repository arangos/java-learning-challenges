package com.codebulls.challenges;

import java.util.Scanner;

public class CalculateAreaOfParallelogramChallenge {
    /*
        Sample Input
        1
        3
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int B = scanner.nextInt();
        int H = scanner.nextInt();
        if( B <= 0 || H <= 0 ){
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }else{
            System.out.println(B * H);
        }
    }
}
