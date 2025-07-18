package com.codebulls.challenges;

import java.util.Scanner;

public class IntegerToStringConversion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //the trick is using Inetegr object since it has to string by default
        Integer n = scanner.nextInt();
        int a = 3;
        String.valueOf(a);
        try{
            String result = n.toString();
            System.out.println("Good job");
        }catch(Exception e){
            System.out.println("Wrong answer");
        }
    }
}

