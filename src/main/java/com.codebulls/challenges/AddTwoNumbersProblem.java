package com.codebulls.challenges;

import java.math.BigInteger;

public class AddTwoNumbersProblem {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        // Example usage
        AddTwoNumbersProblem problem = new AddTwoNumbersProblem();
        ListNode l1 = problem.new ListNode(9);
        ListNode l2 = problem.new ListNode(1,
                problem.new ListNode(9,
                        problem.new ListNode(9,
                                problem.new ListNode(9,
                                        problem.new ListNode(9,
                                            problem.new ListNode(9,
                                                problem.new ListNode(9,
                                                        problem.new ListNode(9,
                                                                problem.new ListNode(9,
                                                                        problem.new ListNode(9))))))))));
        ListNode result = problem.addTwoNumbers(l1, l2);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    //Non performant
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuilder sb = populateStacks(l1);
        String reversedNumber = sb.reverse().toString();
        BigInteger reversedNumberInt = new BigInteger(reversedNumber);

        StringBuilder sb2 = populateStacks(l2);
        String reversedNumber2 = sb2.reverse().toString();
        BigInteger reversedNumberInt2 = new BigInteger(reversedNumber2);

        BigInteger sum = reversedNumberInt.add(reversedNumberInt2);

        String sumString = new StringBuilder(sum.toString()).reverse().toString();

        char[] characters = sumString.toCharArray();
        // Create the linked list from the reversed string

        if (characters.length == 0) {
            return null; // Return null if the sum is empty
        }

        ListNode current = new ListNode(Character.getNumericValue(characters[0]));
        ListNode head = current;
        for (int i = 1; i < characters.length; i++) {
            current.next = new ListNode(Character.getNumericValue(characters[i]));
            current = current.next;
        }
        return head;
    }

    private static StringBuilder populateStacks(ListNode nodeList) {
        StringBuilder stringBuilder = new StringBuilder();
        while (nodeList != null) {
            stringBuilder.append(nodeList.val);
            nodeList = nodeList.next;
        }
        return stringBuilder;
    }

    public ListNode addTwoNumbersPerformance(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode mover = head;

        int carry =0;
        while(l1 != null && l2!= null){
            int sum = l1.val + l2.val + carry;

            mover.next = new ListNode(sum%10);
            mover = mover.next;
            l1 = l1.next;
            l2 = l2.next;

            carry = sum/10;
        }

        while(l1 != null){
            int sum = l1.val+carry;

            mover.next = new ListNode(sum%10);
            mover = mover.next;
            l1 = l1.next;

            carry = sum/10;
        }

        while(l2 != null){
            int sum = l2.val+carry;

            mover.next = new ListNode(sum%10);
            mover = mover.next;
            l2 = l2.next;

            carry = sum/10;
        }

        if(carry != 0){
            mover.next = new ListNode(carry);
        }

        return head.next;
    }
}
