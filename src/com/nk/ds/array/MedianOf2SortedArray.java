package com.nk.ds.array;

import com.nk.metadata.Complexity;

import java.util.Arrays;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

    Input: nums1 = [1,3], nums2 = [2]
    Output: 2.00000
    Explanation: merged array = [1,2,3] and median is 2.

Example 2:

    Input: nums1 = [1,2], nums2 = [3,4]
    Output: 2.50000
    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class MedianOf2SortedArray {

    @Complexity(time = "O(M+N)", space = "O(M+N)")
    public static double findMedianOfSortedArrays(int[] arr1, int[] arr2) {
        double median;
        int[] sortedArray = new int[arr1.length + arr2.length];
        int i1 = 0, i2 = 0, index = 0;
        //merge the array into sortedArray
        while( (i1 + i2) < sortedArray.length){
            if(i1 < arr1.length && i2 < arr2.length) {
                if(arr1[i1] < arr2[i2]) {
                    sortedArray[index++] = arr1[i1++];
                }
                else {
                    sortedArray[index++] = arr2[i2++];
                }
            }
            else if(i1 < arr1.length) {
                sortedArray[index++] = arr1[i1++];
            }
            else if (i2 < arr2.length) {
                sortedArray[index++] = arr2[i2++];
            }
        }

        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
        int midIndex = sortedArray.length / 2;
        System.out.println("Median: " + midIndex);
        if(midIndex != 0 && sortedArray.length % 2 == 0) {
            median = (double) (sortedArray[midIndex] + sortedArray[midIndex - 1]) / 2;
        }
        else {
            median = sortedArray[midIndex];
        }
        return median;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3};
        int[] arr2 = {2,4};
        System.out.println("Median of 2 Sorted Arrays: " + findMedianOfSortedArrays(arr1, arr2));
    }
}
