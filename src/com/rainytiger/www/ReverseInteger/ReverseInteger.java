package com.rainytiger.www.ReverseInteger;

public class ReverseInteger {

    public int reverse(int x) {
        int temp = 0;
        while (x != 0) {
            int r = x % 10;
            x /= 10;
            if (temp > Integer.MAX_VALUE / 10) {
                return 0;
            } else if (temp == Integer.MAX_VALUE / 10 && r > 7) {
                return 0;
            } else if (temp < Integer.MIN_VALUE / 10) {
                return 0;
            } else if (temp == Integer.MIN_VALUE / 10 && r < -8) {
                return 0;
            } else {
                temp = temp * 10 + r;
            }
        }
        return temp;
    }
}
