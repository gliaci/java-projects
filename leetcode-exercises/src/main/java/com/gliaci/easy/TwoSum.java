package com.gliaci.easy;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int finish = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int current = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (current + nums[j] == target) {
                    return new int[]{i, j};
                }
                else if (nums[finish-i] + nums[finish-j] == target) {
                    return new int[] {finish-i,finish-j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.printf("TwoSum of %s with target %d is %s\n", Arrays.toString(nums), target, Arrays.toString(twoSum.twoSum(nums, target)));
    }
}
