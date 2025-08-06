package com.codebulls.challenges;

import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSumOptimized(nums, target);
        if (result != null) {
            System.out.println("Indices of the two numbers that add up to " + target + ": [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No two numbers add up to " + target);
        }
    }

    public static int[] twoSumOptimized(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        int length = nums.length;
        int tempSum = 0;
        for (int i = 0; i < length; i++) {
            tempSum = target - nums[i];
            if (numToIndex.containsKey(tempSum)) {
                int number = numToIndex.get(tempSum);
                return new int[]{number, i};
            }else{
                numToIndex.put(nums[i], i); // Store the index of the current number
            }
        }
        return null; // Return null if no solution is found
    }

    public static int[] twoSumNonOptimized(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null; // Return null if no solution is found
    }

}
