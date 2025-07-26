package com.nk.ds.array;

import com.nk.metadata.Complexity;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 3487: Maximum Unique Subarray Sum After Deletion
 * You are given an integer array nums.
 * <p>
 * You are allowed to delete any number of elements from nums without making it empty. After performing the deletions, select a subarray of nums such that:
 * <p>
 * All elements in the subarray are unique.
 * The sum of the elements in the subarray is maximized.
 * Return the maximum sum of such a subarray.
 * <p>
 * Example1:
 * Input: nums = [1,2,3,4,5], Output = 15
 * Exp: Select the entire array without deleting any element to get the maximum sum.
 * <p>
 * Input: nums = [1,1,0,1,1], Output = 1
 * Exp: Delete the element nums[0] == 1, nums[1] == 1, nums[2] == 0, and nums[3] == 1. Select the entire array [1] to get the maximum sum.
 * <p>
 * Input: nums = [1,2,-1,-2,1,0,-1], Output = 3
 * Exp: Delete the elements nums[2] == -1 and nums[3] == -2, and select the subarray [2, 1] from [1, 2, 1, 0, -1] to get the maximum sum.
 */
public class MaxUniqSubArraySum {

    @Complexity(time = "O(N)", space = "O(N)")
    public static int maxSum(int[] nums) {
        //create a set to store unique numbers
        Set<Integer> uniqSet = new HashSet<>();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            // if the number is positive and added into uniqSet, then add into a sum
            // else calculate max if all numbers in an array are negative
            if (i > 0 && uniqSet.add(i)) {
                sum += i;
            } else {
                max = Math.max(max, i);
            }
        }

        // if all number are negetive then uniqSet would be empty, return max
        if (uniqSet.isEmpty()) {
            return max;
        }

        //return sum
        return sum;
    }

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 5};
        int[] input2 = {1, 1, 0, 1, 1};
        int[] input3 = {1, 2, -1, -2, 1, 0, -1};

        int[] input4 = {-100};

        System.out.println(maxSum(input1));
        System.out.println(maxSum(input2));
        System.out.println(maxSum(input3));
        System.out.println(maxSum(input4));
    }
}
