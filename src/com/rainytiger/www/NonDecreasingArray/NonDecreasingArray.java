package com.rainytiger.www.NonDecreasingArray;

public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] > nums[left + 1]) {
                break;
            }
            left++;
        }
        while (left < right) {
            if (nums[right - 1] > nums[right]) {
                break;
            }
            right--;
        }
        if (left == right) return true;
        if (left == right - 1) {
            if (nums[left] <= nums[right] || left == 0 || right == nums.length - 1) return true;
            return nums[left - 1] <= nums[right] || nums[left] <= nums[right + 1];
        } else return false;
    }
}
