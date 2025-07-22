package com.codebulls.challenges;

public class DeleteCharacterToMakeFancyString {

    public static void main(String[] args){
        String input = "leeetcode";
        System.out.println(makeFancyString(input));
    }

    public static String makeFancyString(String text){
        //i need to check if a character is repeated more than 2 times to removed
        int length = text.length();
        int count = 0;
        char prev = '\0';
        StringBuilder stringBuilder = new StringBuilder();
        for (int end = 0; end < length; end++) {
            char character = text.charAt(end);
            if(character == prev){
                count++;
            } else{
                prev = character;
                count = 1;
            }

            if(count < 3) {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }
}
