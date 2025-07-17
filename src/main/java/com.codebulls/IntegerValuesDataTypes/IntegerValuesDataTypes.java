package com.codebulls.IntegerValuesDataTypes;

import java.util.*;

public class IntegerValuesDataTypes {

    /*
    Sample Input

    5
    -150
    150000
    1500000000
    213333333333333333333333333333333333
    -100000000000000
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            try{
                long x = sc.nextLong();
                System.out.println(x+" can be fitted in:");
                // Note: The range for byte is from -128 to 127
                if(x >= -128 && x <= 127) System.out.println("* byte");
                // Note: The range for short is from -32768 to 32767
                if(x>= -32768 &&  x <= 32767) System.out.println("* short");
                // Note: The range for int is from -2147483648 to 2147483647
                if(x>= -2147483648 &&  x <= 2147483647) System.out.println("* int");
                // Note: The range for long is from -9223372036854775808 to 9223372036854775807
                if(x>= -9223372036854775808L &&  x <= 9223372036854775807L) System.out.println("* long");
            }catch(Exception e){
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }
        }
        sc.close();
    }

}
