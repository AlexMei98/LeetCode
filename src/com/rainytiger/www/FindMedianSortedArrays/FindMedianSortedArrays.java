package com.rainytiger.www.FindMedianSortedArrays;

public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        boolean flag = len % 2 == 0;
        int iMin = 0, iMax = len1, half = (len + 1) / 2;
        while (true) {
            int i = (iMax + iMin) >> 1;
            int j = half - i;
            if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i;
            } else if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else {
                int maxLeft;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if (!flag) return maxLeft;

                int minRight;
                if (i == len1) {
                    minRight = nums2[j];
                } else if (j == len2) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (minRight + maxLeft) / 2.0;
            }
        }
    }
}
