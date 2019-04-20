package com.rainytiger.www.PalindromeNumber;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        int length = (int) Math.log10(x);
        int[] arr = new int[length + 1];
        for (int i = 0; i <= length; i++) {
            arr[i] = x % 10;
            x /= 10;
        }
        for (int i = 0; i < length / 2 + 1; i ++) {
            if (arr[i] != arr[length - i]) {
                return false;
            }
        }
        return true;
    }
}
